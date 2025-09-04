package com.AccessManagement.Repository;

import com.AccessManagement.Model.BuyerItemMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerItemMapperRepository extends JpaRepository<BuyerItemMapper,Integer> {
    List<BuyerItemMapper> findByUserIdAndIsDeleted(Integer id, boolean b);

    List<BuyerItemMapper> findBySubOrganizationIdAndIsDeleted(Integer subOrgId, boolean b);
}
