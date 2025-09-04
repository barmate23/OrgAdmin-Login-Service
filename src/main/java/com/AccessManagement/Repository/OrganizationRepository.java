package com.AccessManagement.Repository;

import com.AccessManagement.Model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
    List<Organization> findByIsDeleted(boolean b);

    Organization findByIsDeletedAndId(boolean b, Integer orgId);

    Organization findByIsDeletedAndIsActiveAndId(boolean b, boolean b1, Integer orgId);
}
