package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Device")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;

    @Column(name = "OrganizationName", length = 255)
    private String organizationName;

    @Column(name = "SubOrganizationName", length = 255)
    private String subOrganizationName;

    @Column(name = "OtherOrganizationId")
    private Integer otherOrganizationId;

    @Column(name = "OtherOrganizationName", length = 255)
    private String otherOrganizationName;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "CPUId", length = 255)
    private String cpuId;

    @Column(name = "LicenseKey", length = 255)
    private String licenseKey;

    @Column(name = "Validity")

    private Date validity;

    @Column(name = "Status")
    private Boolean status;

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


}

