//package com.AccessManagement.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface DepartmentRepository extends JpaRepository<Department,Integer> {
//    Department findByIsDeletedAndId(boolean b, Integer departmentId);
//
//    List<Department> findByIsDeleted(boolean b);
//
//    Department findByIsDeletedAndIsActiveAndId(boolean b, boolean b1, Integer departmentsId);
//}
