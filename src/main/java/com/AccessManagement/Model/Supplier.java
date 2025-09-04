package com.AccessManagement.Model;//package com.AccessManagement.Model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "SupplierID")
    private String supplierId;

    @Column(name = "OrganizationId")
    private Integer organizationId;

    @Column(name = "SubOrganization")
    private Integer subOrganizationId;

    @Column(name = "ERPSupplierID")
    private String erpSupplierId;

    @Column(name = "SupplierName")
    private String supplierName;

    @Column(name = "DateOfRegistration")
    private Date dateOfRegistration;

    @Column(name = "SupplierCategory")
    private String supplierCategory;

    @Column(name = "SupplierGroup")
    private String supplierGroup;

    @Column(name = "OtherOrganizationName")
    private String otherOrganizationName;

    @Column(name = "SupplierGSTRegistrationNumber")
    private String supplierGSTRegistrationNumber;

    @Column(name = "SupplierPANNumber")
    private String supplierPANNumber;

    @Column(name = "SupplierTANNumber")
    private String supplierTANNumber;

    @Column(name = "PaymentTerms")
    private String paymentTerms;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "CreditLimitRs")
    private Integer creditLimitRs;

    @Column(name = "CreditLimitDays")
    private Integer creditLimitDays;

    @Column(name = "SupplierPrimaryBanker")
    private String supplierPrimaryBanker;

    @Column(name = "FullBranchAddress")
    private String fullBranchAddress;

    @Column(name = "MICRCode")
    private String micrCode;

    @Column(name = "IFSCCode")
    private String ifscCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "CountryCode")
    private Integer countryCode;

    @Column(name = "PostCode")
    private Integer postCode;

    @Column(name = "State")
    private String state;

    @Column(name = "District")
    private String district;

    @Column(name = "Taluka")
    private String taluka;

    @Column(name = "City")
    private String city;

    @Column(name = "Town")
    private String town;

    @Column(name = "Village")
    private String village;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "Building")
    private String building;

    @Column(name = "Street")
    private String street;

    @Column(name = "Landmark")
    private String landmark;

    @Column(name = "SubLocality")
    private String subLocality;

    @Column(name = "Locality")
    private String locality;

    @Column(name = "AreaCode")
    private Integer areaCode;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "OfficePrimaryPhone")
    private String officePrimaryPhone;

    @Column(name = "OfficeAlternatePhone")
    private String officeAlternatePhone;

    @Column(name = "ContactPersonName")
    private String contactPersonName;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Department")
    private String department;

    @Column(name = "PrimaryPhone")
    private String primaryPhone;

    @Column(name = "AlternatePhone")
    private String alternatePhone;

    @Column(name = "PrimaryEmail")
    private String primaryEmail;

    @Column(name = "AlternateEmail")
    private String alternateEmail;

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
