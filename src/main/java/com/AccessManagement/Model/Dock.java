package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_docks")
@Data
public class Dock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;

    @Column(name = "DockId")
    private String dockId;

    @Column(name = "DockName")
    private String dockName;

    @Column(name = "Attribute")
    private String attribute;

    @ManyToOne
    @JoinColumn(name = "DockSupervisorId")
    private Users dockSupervisor;

    @Column(name = "IsOccupied")
    private Boolean isOccupied;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;


    @Column(name = "CreatedOn")
    private Date createdOn;

    @Column(name = "CreatedBy")
    private Integer createdBy;


    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

}

