package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_LicenseLine")
@Data
public class LicenseLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;

    @ManyToOne
    @JoinColumn(name = "LicenseHeadId")
    private LicenseHead licenseHead;

    @ManyToOne
    @JoinColumn(name = "ModuleId")
    private Modules module;

    @ManyToOne
    @JoinColumn(name = "SubmoduleId")
    private SubModules subModule;

    @ManyToOne
    @JoinColumn(name = "ReasonId")
    private Reason reason;

    @ManyToOne
    @JoinColumn(name = "PartNumberId")
    private PartNumber partNumber;

    @ManyToOne
    @JoinColumn(name = "PartNumberSubModuleMapperId")
    private PartNumberSubModuleMapper partNumberSubModuleMapper;

    @Column(name = "KeyCount")
    private Integer keyCount;

    @Column(name = "ReasonFileId")
    private Integer reasonFileId;

    @Column(name = "SuperAdminReason", length = 30)
    private String superAdminReason;

    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "IsModuleSelected")
    private Boolean isModuleSelected;

    @Column(name = "IsApproved")
    private Integer isApproved;

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
