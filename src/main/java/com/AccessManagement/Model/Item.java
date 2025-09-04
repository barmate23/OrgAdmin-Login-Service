package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganizationId")
    private Integer subOrganizationId;

    @Column(name = "ItemId")
    private String itemId;

    @Column(name = "PartNumber")
    private String partNumber;

    @Column(name = "ERPItemID")
    private String erpItemID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "ItemGroup")
    private String itemGroup;

    @Column(name = "ItemCategory")
    private String itemCategory;

    @Column(name = "ItemSubcategory")
    private String itemSubcategory;

    @Column(name = "TypeDirectIndirect")
    private String typeDirectIndirect;

    @Column(name = "TypeSerialBatchNone")
    private String typeSerialBatchNone;

    @Column(name = "IssueType")
    private String issueType;

    @Column(name = "ClassABC")
    private String classABC;

    @Column(name = "Attribute")
    private String attribute;

    @Column(name = "Source")
    private String source;

    @Column(name = "UOM")
    private String uom;

    @Column(name = "ItemUnitWeight")
    private Float itemUnitWeight;

    @Column(name = "ItemUnitRate")
    private Float itemUnitRate;

    @Column(name = "Currency")
    private String currency;

    @Column(name = "OptimumLevel")
    private Integer optimumLevel;

    @Column(name = "ReorderLevel")
    private Integer reorderLevel;

    @Column(name = "SafetyStockLevel")
    private Integer safetyStockLevel;

    @Column(name = "CriticalLevel")
    private Integer criticalLevel;

    @Column(name = "LeadTime")
    private Date leadTime;


    @ManyToOne
    @JoinColumn(name = "DockID")
    private Dock dockId;

    @Column(name = "DockName")
    private String dockName;

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
