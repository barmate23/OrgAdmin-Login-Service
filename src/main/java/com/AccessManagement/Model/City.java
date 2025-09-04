package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_City")
public class City {
    @Id
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "city_name")
    private String cityName;

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

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "pincode")
    private Integer pincode;

}

