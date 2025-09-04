package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_PartNumberSubModuleMapper")
@Data
public class PartNumberSubModuleMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PartNumberId")
    private PartNumber partNumber;

    @ManyToOne
    @JoinColumn(name = "SubModuleId")
    private SubModules subModule;

    @Column(name = "DefaultKeyCount")
    private Integer defaultKeyCount;

    @Column(name = "LicenseCategory")
    private Integer licenseCategory;

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
