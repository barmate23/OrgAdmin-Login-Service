package com.AccessManagement.Repository;
import com.AccessManagement.Model.Shift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Integer> {

    Page<Shift> findByOrganizationIdAndSubOrganizationIdAndIsDeleted(Integer orgId, Integer subOrgId, boolean active, Pageable pageable);

    boolean existsByOrganizationIdAndSubOrganizationIdAndIsDeletedAndShiftName(Integer orgId, Integer subOrgId,boolean b,String shiftName);
    boolean existsByOrganizationIdAndSubOrganizationIdAndIsDeletedAndShiftNameAndIdNot(Integer orgId, Integer subOrgId,boolean b,String shiftName, int shiftId);

    Shift findByOrganizationIdAndSubOrganizationIdAndIsDeletedAndId(Integer orgId, Integer subOrgId,boolean b, Integer shiftId);

    Shift findByIsDeletedAndId(boolean b, Integer shiftId);

    List<Shift> findAllBySubOrganizationIdAndIsDeleted(Integer subOrgId, boolean b);

    long countByOrganizationIdAndSubOrganizationIdAndIsDeleted(Integer orgId, Integer subOrgId, boolean b);

    Shift findBySubOrganizationIdAndIsDeletedAndId(Integer subOrgId, boolean b, Integer shiftId);

    Optional<Shift> findByIdAndSubOrganizationIdAndIsDeleted(int shiftId, Integer subOrgId, boolean b);

}
