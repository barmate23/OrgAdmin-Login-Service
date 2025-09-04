package com.AccessManagement.Model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
public class LoginUser {
    private Integer userId;
    private String userName;
    private String logId;
    private String orgName;
    private String subOrgName;
    private Integer subOrgId;
    private Integer orgId;

}
