package com.AccessManagement.Request;

import com.AccessManagement.Model.Reason;
import com.AccessManagement.Model.SubModules;
import com.AccessManagement.Model.Supplier;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
public class UserRequest {
    private Integer modulesId;
    private Integer userLicenseKeyId;
    private String userType;
    private String users;
    private String erpUserId;
    private String userName;
    private Boolean isLicenseAssign;
    private Integer supplierId;
    private Integer shiftId;
    private List<Integer> itemIds;
    private Integer reasonId;
    private Integer orgId;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String emailID;
    private String mobileNo;
    private Boolean isEmailVerified;
    private String department;
    private String designation;
    private Date startDate;
    private Date endDate;
    private Date dateOfBirth;
    private String loginUrl;
    private List<Integer> additionalDeviceLicense;
}
