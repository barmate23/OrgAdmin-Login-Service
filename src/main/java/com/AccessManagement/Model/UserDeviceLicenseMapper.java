package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_UserDeviceLicenseMapper")
@Data
public class UserDeviceLicenseMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "module_user_licence_key_id")
    private ModuleUserLicenceKey moduleUserLicenceKey;

    @ManyToOne
    @JoinColumn(name = "additionalUserDeviceLicenseId")
    private ModuleUserLicenceKey additionalUserDeviceLicense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

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
