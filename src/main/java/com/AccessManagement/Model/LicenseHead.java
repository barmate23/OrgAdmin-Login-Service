package com.AccessManagement.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_LicenseHead")
public class LicenseHead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;

    @Column(name = "PoNumber")
    private Integer poNumber;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Note")
    private String note;

    @Column(name = "PoDocumentId")
    private Integer poDocumentId;

    @Column(name = "ApprovalDate")
    private Date approvalDate;

    @Column(name = "Status")
    private Integer status;

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
