//package com.AccessManagement.Controller;
//
//import com.AccessManagement.Response.BaseResponse;
//import com.AccessManagement.Service.DepartmentService;
//import com.AccessManagement.Utils.ConstantsForAPIs;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping({ConstantsForAPIs.PREFIX+ConstantsForAPIs.DEPARTMENTS})
//public class DepartmentController {
//
//    @Autowired
//    DepartmentService departmentService;
//
//    @GetMapping(ConstantsForAPIs.GET_ALL_DEPARTMENT)
//    public BaseResponse<Department> getAllDepartment(){
//        return departmentService.getAllDepartments();
//    }
//
//    @DeleteMapping({ConstantsForAPIs.ACTIVE_DEPARTMENT_BY_ID})
//    public BaseResponse<Department>activeDepartmentById(@RequestParam Integer departmentsId,
//                                                           @RequestParam Boolean status){
//        return departmentService.activeDepartmentById(departmentsId,status);
//    }
//
//}
