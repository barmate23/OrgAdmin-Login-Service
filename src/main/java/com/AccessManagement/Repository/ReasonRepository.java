package com.AccessManagement.Repository;

import com.AccessManagement.Model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason,Integer> {
    Reason findByIsDeletedAndSubOrganizationIdAndId(boolean b, Integer subOrgId, Integer reasonId);
}
