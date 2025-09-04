package com.AccessManagement.Repository;

import com.AccessManagement.Model.LicenseLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface LicenseRepository extends JpaRepository<LicenseLine,Integer> {

    List<LicenseLine> findByIsDeletedAndOrganizationId(boolean b, Integer id);
}
