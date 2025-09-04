package com.AccessManagement.Repository;

import com.AccessManagement.Model.Supplier;
import com.google.common.base.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findByIsDeletedAndId(boolean b, Integer supplierId);
}
