package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Modules")
@Data
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "moduleName", length = 500)
    private String moduleName;

    @Column(name = "moduleCode", length = 100)
    private String moduleCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrganizationId")
    private Organization organizationId;

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
