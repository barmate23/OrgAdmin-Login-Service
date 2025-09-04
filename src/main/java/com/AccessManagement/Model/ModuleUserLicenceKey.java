package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_ModuleUserLicenceKey")
@Data
public class ModuleUserLicenceKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;


    @ManyToOne
    @JoinColumn(name = "licence_line_id")
    private LicenseLine licenceLine;

    @Column(name = "userLicenseKey", length = 255)
    private String userLicenseKey;

    @Column(name = "isUsed")
    private Boolean isUsed;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @Column(name = "createdBy")
    private Integer createdBy;

    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

    @Column(name = "modifiedOn")
    private Date modifiedOn;
}
