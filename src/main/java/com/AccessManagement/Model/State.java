package com.AccessManagement.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_State", schema = "public")
public class State {
    @Id
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_code")
    private Integer stateCode;

    @Column(name = "isActive")
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

