package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_PartNumber")
@Data
public class PartNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ModuleId")
    private Modules module;

    @Column(name = "PartNumber", length = 30)
    private String partNumber;

    @Column(name = "DefaultAdditional")
    private Integer defaultAdditional;

    @Column(name = "Description", length = 30)
    private String description;

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
