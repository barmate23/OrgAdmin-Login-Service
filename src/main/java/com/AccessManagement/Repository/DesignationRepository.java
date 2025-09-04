//package com.AccessManagement.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DesignationRepository extends JpaRepository<Designation,Integer> {
//    Designation findByIsDeletedAndId(boolean b, Integer designation);
//
//    Designation findByIsDeletedAndIsActiveAndId(boolean b, boolean b1, Integer designationId);
//
//    List<Designation> findByIsDeleted(boolean b);
//}
