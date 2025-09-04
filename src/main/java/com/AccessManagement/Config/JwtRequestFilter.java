//package com.AccessManagement.Config;
//
//import com.AccessManagement.Model.LoginUser;
//import com.AccessManagement.Model.Users;
//import com.AccessManagement.Repository.UserRepository;
//import com.AccessManagement.Request.ChangePasswordRequest;
//import com.AccessManagement.Utils.ConstantsForAPIs;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.Map;
//import java.util.Random;
//import java.util.Scanner;
//
//@Component
//@RestController
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtUserDetailsService jwtUserDetailsService;
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
////	@Autowired
////	private LoginUser loginUser;
//	@Autowired
//	private UserRepository userRepository;
//
//
//	@Value("${jwt.secret}")
//	private String secretKey;
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//		if(request.getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.JWT_AUTHENTICATION_CONTROLLER) ) {
//			chain.doFilter(request, response);
//		} else if (request.getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.RESET_PASSWORD) ) {
//			chain.doFilter(request, response);
//		}
//		else if (request.getServletPath().equals( ConstantsForAPIs.PREFIX+ConstantsForAPIs.GENERATE_OTP) ) {
//			chain.doFilter(request, response);
//		}else {
//			final String requestTokenHeader = request.getHeader("Authorization");
//			String username = null;
//			String jwtToken = null;
//			// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
//			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//				jwtToken = requestTokenHeader.substring(7);
//				try {
//					username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//				} catch (IllegalArgumentException e) {
//					response.sendError ( 401,"Unable to get JWT Token" );
//					logger.error ( "Unable to get JWT Token" );
//					return;
//				} catch (ExpiredJwtException e) {
//					response.sendError(401,"JWT Token has expired");
//					logger.error ("JWT Token has expired" );
//					return;
//
//				}
//			} else {
//				response.sendError(401,"JWT Token does not begin with Bearer String");
//				logger.warn("JWT Token does not begin with Bearer String");
//				return;
//			}
//
//			//Once we get the token validate it.
//			//	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			if (username != null ) {
//
//				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//				// To do: if token is valid configure Spring Security to manually set authentication
//				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken (
//							userDetails , null , userDetails.getAuthorities ( ) );
//					usernamePasswordAuthenticationToken
//							.setDetails ( new WebAuthenticationDetailsSource ( ).buildDetails ( request ) );
//					// To do: After setting the Authentication in the context, we specify
//					//To do: that the current user is authenticated. So it passes the Spring Security Configurations successfully.
//					SecurityContextHolder.getContext ( ).setAuthentication ( usernamePasswordAuthenticationToken );
//					Map<String, Object> claims = getAllClaimsFromToken(jwtToken);
//					Integer userId = Integer.parseInt(claims.get("userId").toString());
//
////					Users user = this.userRepository.findByIsDeletedAndId(false,userId);
////					loginUser.setUsers ( user );
////					Random random = new Random();
////					int randomNumber = random.nextInt(9999 - 1000 + 1) + 1000;
////					loginUser.setLogId(("LG"+LocalDateTime.now().toLocalDate()+randomNumber).trim().replaceAll("-",""));
//
//					chain.doFilter ( request , response );
//				}
//				else {
//					response.sendError ( 401 );
//				}
//			}
//			else {
//				response.sendError ( 401 );
//			}
//
//		}
//
//	}
//	private Claims getAllClaimsFromToken(String token) {
//		Claims claims;
//		try {
//			claims = Jwts.parser()
//					.setSigningKey(secretKey)
//					.parseClaimsJws(token)
//					.getBody();
//		} catch (Exception e) {
//			claims = null;
//		}
//		return claims;
//	}
//
//}
//
//
