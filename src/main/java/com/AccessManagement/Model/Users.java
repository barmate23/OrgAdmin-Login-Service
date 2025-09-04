package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_Users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "ErpUserId")
    private String erpUserId;

    @Column(name = "Users")
    private String users;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "SubOrganizationId")
    private Organization subOrganization;

    @ManyToOne
    @JoinColumn(name = "shiftId")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "ModuleUserLicenceKeyId", referencedColumnName = "Id")
    private ModuleUserLicenceKey moduleUserLicenceKey;

    @Column(name = "IsDefaultUser")
    private Boolean isDefaultUser;

    @Column(name = "IsLicenseAssign")
    private Boolean isLicenseAssign;

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private Reason reason;

    @Column(name = "defaultUserCode")
    private String defaultUserCode;
    @Column(name = "Department")
    private String department;
    @Column(name = "Designation")
    private String designation;
    @Column(name = "UserType")

    private String userType;
    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Column(name = "Username")
    private String username;

    @Column(name = "EmployeeId")
    private String employeeId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Password")
    private String password;

    @Column(name = "FirstPassword")
    private String firstPassword;

    @Column(name = "SecondPassword")
    private String secondPassword;

    @Column(name = "ThirdPassword")
    private String thirdPassword;

    @Column(name = "PwdExpireDate")
    private Long pwdExpireDate;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "MobileNo")
    private String mobileNo;

    @Column(name = "LandLineNumber")
    private String landLineNumber;

    @Column(name = "Image")
    private String image;

    @Column(name = "ImagePath")
    private String imagePath;

    @Column(name = "UserLanguage")
    private String userLanguage;

    @Column(name = "BiometricID")
    private String biometricId;

    @Column(name = "IsEmailVerified")
    private Boolean isEmailVerified;

    @Column(name = "Otp")
    private Integer otp;

    @Column(name = "OtpExpDate")
    private Long otpExpDate;

    @Column(name = "IsFirstLogin")
    private Boolean isFirstLogin;

    @Column(name = "FreeField1")
    private String freeField1;

    @Column(name = "FreeField2")
    private Integer freeField2;

    @Column(name = "FreeField3")
    private String freeField3;

    @Column(name = "FreeField4")
    private Integer freeField4;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Column(name = "CreatedOn")
    private Date createdOn;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "ModifiedOn")
    private Date modifiedOn;
    @Transient
    private List<ModuleUserLicenceKey> additionalUserDeviceLicense;

}