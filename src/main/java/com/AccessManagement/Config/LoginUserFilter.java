package com.AccessManagement.Config;

import com.AccessManagement.Model.LoginUser;
import com.AccessManagement.Model.Users;
import com.AccessManagement.Repository.UserRepository;
import com.AccessManagement.Utils.ConstantsForAPIs;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
@WebFilter(urlPatterns = "/*")
@Order(1) // Set the order in which the filter should be executed
public class LoginUserFilter implements Filter {



    @Autowired
    UserRepository userRepository;
    @Autowired
    private final LoginUser loginUser;



    @Autowired
    public LoginUserFilter(LoginUser user) {
        this.loginUser = user;
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(((HttpServletRequest) request).getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.JWT_AUTHENTICATION_CONTROLLER) ) {
			chain.doFilter(request, response);
		} else if (((HttpServletRequest) request).getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.RESET_PASSWORD) ) {
			chain.doFilter(request, response);
		}
		else if (((HttpServletRequest) request).getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.GENERATE_OTP) ) {
			chain.doFilter(request, response);
		}
        else if (((HttpServletRequest) request).getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.GENERATE_OTP) ) {
            chain.doFilter(request, response);
        }else if (((HttpServletRequest) request).getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.IS_FIRST_LOGIN) ) {
            chain.doFilter(request, response);

        } else {
            // Extract data from headers and set it in the user bean
            String userId = httpRequest.getHeader("userId");

            if (userId != null) {
                loginUser.setUserId(Integer.parseInt(userId));
            } else {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Un Authorized");
                return;
            }
            String userName = httpRequest.getHeader("userName");
            if (userName != null) {
                loginUser.setUserName(userName);
            } else {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Un Authorized");
                return;
            }
            String organizationId = httpRequest.getHeader("orgId");
            if (organizationId != null) {
                loginUser.setOrgId(Integer.parseInt(organizationId));
            }
            String organizationName = httpRequest.getHeader("orgName");
            if (organizationName != null) {
                loginUser.setOrgName(organizationName);
            }
            String logId = httpRequest.getHeader("logId");
            if (logId != null) {
                loginUser.setLogId(logId);
            }
            String subOrgId = httpRequest.getHeader("subOrgId");
            if (subOrgId != null) {
                loginUser.setSubOrgId(Integer.parseInt(subOrgId));
            }
            String subOrgName = httpRequest.getHeader("subOrgName");
            if (subOrgName != null) {
                loginUser.setSubOrgName(subOrgName);
            }

            chain.doFilter(request, response);
        }
    }



    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}
