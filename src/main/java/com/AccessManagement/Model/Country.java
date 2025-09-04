package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_Country")
public class Country {
    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "isactive")
    private Integer isActive;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

}


