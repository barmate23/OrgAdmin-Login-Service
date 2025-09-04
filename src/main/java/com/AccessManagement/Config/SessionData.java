package com.AccessManagement.Config;

import com.AccessManagement.Model.Organization;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SessionData {
    private Integer userId;
    private String username;
    private String userCode;
    private String firstName;
    private String lastName;
    private Integer groupId;
    private Integer organization;
    private Organization organizationDetails;
    private List<Permission> permission;
    private String designation;
    private String department;
}
