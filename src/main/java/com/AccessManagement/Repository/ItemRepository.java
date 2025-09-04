package com.AccessManagement.Repository;

import com.AccessManagement.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByIsDeletedAndIdIn(boolean b, List<Integer> itemIds);

    Item findByIsDeletedAndId(boolean b, Integer itemId);


    List<Item> findByIsDeletedAndSubOrganizationId(boolean b, Integer subOrgId);

    List<Item> findByIsDeletedAndSubOrganizationIdAndIdNotIn(boolean b, Integer subOrgId, List<Integer> itemIdList);
}
