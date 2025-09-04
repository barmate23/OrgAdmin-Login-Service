package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_SubModules")
@Data
public class SubModules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrganizationId")
    private Organization organizationId;

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Modules module;

    @Column(name = "subModuleCode", length = 15)
    private String subModuleCode;

    @Column(name = "subModuleName", length = 100)
    private String subModuleName;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "modifiedBy")
    private Date modifiedBy;

    @Column(name = "modifiedOn")
    private Date modifiedOn;
}
