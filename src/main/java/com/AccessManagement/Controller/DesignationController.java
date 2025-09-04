//package com.AccessManagement.Controller;
//
//import com.AccessManagement.Response.BaseResponse;
//import com.AccessManagement.Service.DesignationService;
//import com.AccessManagement.Utils.ConstantsForAPIs;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping({ConstantsForAPIs.PREFIX+ConstantsForAPIs.DESIGNATION})
//public class DesignationController {
//    @Autowired
//    DesignationService designationService;
//
//    @GetMapping(ConstantsForAPIs.GET_ALL_DESIGNATION)
//    public BaseResponse<Designation> getAllDesignations(){
//        return designationService.getAllDesignation();
//    }
//    @DeleteMapping({ConstantsForAPIs.ACTIVE_DESIGNATION_BY_ID})
//    public BaseResponse<Designation>activeDesignationsById(@RequestParam Integer designationId,
//                                                            @RequestParam Boolean status){
//        return designationService.activeDesignationById(designationId,status);
//    }
//}
