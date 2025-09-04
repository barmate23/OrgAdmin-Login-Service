//package com.AccessManagement.Service;
//
//import com.AccessManagement.Model.LoginUser;
//import com.AccessManagement.Repository.DepartmentRepository;
//import com.AccessManagement.Response.BaseResponse;
//import com.AccessManagement.Utils.Const;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class DepartmentsServiceImpl implements DepartmentService {
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    @Autowired
//    LoginUser loginUser;
//     @Override
//    public BaseResponse<Department> getAllDepartments() {
//        long startTime = System.currentTimeMillis();
//        log.info(loginUser.getLogId() + " GET ALL DEPARTMENTS METHOD START ");
//        BaseResponse<Department> baseResponse = new BaseResponse<>();
//        try {
//            List<Department> departmentList =departmentRepository.findByIsDeleted(false);
//            baseResponse.setData(departmentList);
//            baseResponse.setLogId(loginUser.getLogId());
//            baseResponse.setCode(Const.CODE_1);
//            baseResponse.setStatus(Const.STATUS_200);
//            baseResponse.setMessage(" SUCCESSFULLY FETCHED DEPARTMENTS LIST");
//            log.info(loginUser.getLogId()+" SUCCESSFULLY FETCHED DEPARTMENTS LIST ");
//            return baseResponse;
//        } catch (Exception e) {
//            baseResponse.setData(new ArrayList<>());
//            baseResponse.setLogId(loginUser.getLogId());
//            baseResponse.setCode(Const.CODE_0);
//            baseResponse.setStatus(Const.STATUS_500);
//            baseResponse.setMessage(" FAILED TO FETCHED DEPARTMENTS LIST");
//            long endTime = System.currentTimeMillis();
//            log.error(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" ERROR OCCURS AT FETCHED TO DEPARTMENT LIST EXECUTED TIME ").append(endTime-startTime)),e);
//        }
//        long endTime = System.currentTimeMillis();
//        log.info(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" GET ALL DEPARTMENT LIST METHOD EXECUTED TIME ").append(endTime-startTime)));
//        return baseResponse;
//    }
//
//    @Override
//    public BaseResponse<Department> activeDepartmentById(Integer departmentsId, Boolean status){
//        long startTime = System.currentTimeMillis();
//        log.info(loginUser.getLogId()+" DEPARTMENT ACTIVE AND DEACTIVATE METHOD START");
//        BaseResponse baseResponse=new BaseResponse<>();
//        try{
//            Department department = this.departmentRepository.findByIsDeletedAndIsActiveAndId(false,true,departmentsId);
//            if(status) {
//                department.setIsActive(status);
//                departmentRepository.save(department);
//                List<Department> departmentList = new ArrayList<>();
//                departmentList.add(department);
//                baseResponse.setCode(Const.CODE_1);
//                baseResponse.setData(departmentList);
//                baseResponse.setLogId(loginUser.getLogId());
//                baseResponse.setStatus(Const.STATUS_200);
//                baseResponse.setMessage(" DEPARTMENT ACTIVATED SUCCESSFULLY ");
//                log.info(loginUser.getLogId() + " DEPARTMENT ACTIVATED SUCCESSFULLY ");
//            }else {
//                department.setIsActive(status);
//                departmentRepository.save(department);
//                List<Department> departmentList = new ArrayList<>();
//                departmentList.add(department);
//                baseResponse.setCode(Const.CODE_0);
//                baseResponse.setData(departmentList);
//                baseResponse.setLogId(loginUser.getLogId());
//                baseResponse.setStatus(Const.STATUS_200);
//                baseResponse.setMessage(" DEPARTMENT DEACTIVATED SUCCESSFULLY ");
//                log.info(loginUser.getLogId() + " DEPARTMENT DEACTIVATED SUCCESSFULLY ");
//            }
//        }catch(Exception e){
//            baseResponse.setCode(0);
//            baseResponse.setData(new ArrayList<>());
//            baseResponse.setLogId(null);
//            baseResponse.setStatus(500);
//            baseResponse.setMessage("FAILED TO DELETE DEPARTMENT ");
//            long endTime = System.currentTimeMillis();
//            log.error(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" ERROR OCCURS AT DELETED DEPARTMENT EXECUTED TIME ").append(endTime-startTime)),e);
//        }
//        long endTime = System.currentTimeMillis();
//        log.info(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" DELETE DEPARTMENT METHOD  EXECUTED TIME ").append(endTime-startTime)));
//        return baseResponse;
//    }
//}
