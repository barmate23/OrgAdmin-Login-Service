package com.AccessManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Organization")
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "OrganizationName")
    private String organizationName;

    @Column(name = "OrganizationSequence")
    private String organizationSequence;

    @Column(name = "SubOrganizationSequence")
    private String subOrganizationSequence;

    @Column(name = "OrgRegNumber")
    private String orgRegNumber;

    @JsonIgnore
    @Column(name = "PanCardNumber")
    private String panCardNumber;

    @JsonIgnore
    @Column(name = "GstinNumber")
    private String gstinNumber;

    @JsonIgnore
    @Column(name = "PostCode")
    private Integer postCode;

    @JsonIgnore
    @Column(name = "District")
    private String district;

    @JsonIgnore
    @Column(name = "SubDistrict")
    private String subDistrict;

    @JsonIgnore
    @Column(name = "State")
    private String state;

    @JsonIgnore
    @Column(name = "Country")
    private String country;

    @JsonIgnore
    @Column(name = "CountryCode")
    private Integer countryCode;

    @JsonIgnore
    @Column(name = "OfficeNumber")
    private String officeNumber;

    @JsonIgnore
    @Column(name = "City")
    private String city;

    @JsonIgnore
    @Column(name = "Town")
    private String town;

    @JsonIgnore
    @Column(name = "Village")
    private String village;

    @JsonIgnore
    @Column(name = "Address1")
    private String address1;

    @JsonIgnore
    @Column(name = "Address2")
    private String address2;

    @JsonIgnore
    @Column(name = "Building")
    private String building;

    @JsonIgnore
    @Column(name = "Street")
    private String street;

    @JsonIgnore
    @Column(name = "LandMark")
    private String landMark;

    @JsonIgnore
    @Column(name = "Locality")
    private String locality;

    @JsonIgnore
    @Column(name = "SubLocality")
    private String subLocality;

    @JsonIgnore
    @Column(name = "AreaCode")
    private String areaCode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "LicenseType")
    private LicenseType licenseType;

    @JsonIgnore
    @Column(name = "StartDate")
    private Date startDate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EndDate")
    private Date endDate;

    @JsonIgnore
    @Column(name = "MobileNumber")
    private String mobileNumber;

    @JsonIgnore
    @Column(name = "LandlineNumber")
    private String landlineNumber;

    @JsonIgnore
    @Column(name = "IsSubOrg")
    private Boolean isSubOrg;

    @JsonIgnore
    @Column(name = "IsActive")
    private Boolean isActive;

    @JsonIgnore
    @Column(name = "IsAdminPresent")
    private Boolean isAdminPresent;

    @JsonIgnore
    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @JsonIgnore
    @Column(name = "CreatedBy")
    private Integer createdBy;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn")
    private Date createdOn;

    @JsonIgnore
    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ModifiedOn")
    private Date modifiedOn;

}
