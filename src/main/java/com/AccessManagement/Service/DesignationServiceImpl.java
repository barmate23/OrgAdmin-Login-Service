//package com.AccessManagement.Service;
//
//import com.AccessManagement.Model.LoginUser;
//import com.AccessManagement.Repository.DesignationRepository;
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
//public class DesignationServiceImpl implements DesignationService {
//    @Autowired
//    LoginUser loginUser;
//    @Autowired
//    DesignationRepository designationRepository;
//
//    @Override
//    public BaseResponse<Designation> getAllDesignation(){
//        long startTime = System.currentTimeMillis();
//        log.info(loginUser.getLogId() + " GET ALL DESIGNATION METHOD START ");
//        BaseResponse<Designation> baseResponse= new BaseResponse<>();
//        try {
//            List<Designation> designations=designationRepository.findByIsDeleted(false);
//            baseResponse.setCode(Const.CODE_1);
//            baseResponse.setStatus(Const.STATUS_200);
//            baseResponse.setData(designations);
//            baseResponse.setLogId(loginUser.getLogId());
//            baseResponse.setMessage(" SUCCESSFULLY FETCHED DESIGNATION LIST");
//            log.info(loginUser.getLogId()+" SUCCESSFULLY FETCHED DESIGNATION LIST ");
//        }catch (Exception e) {
//            baseResponse.setData(new ArrayList<>());
//            baseResponse.setLogId(loginUser.getLogId());
//            baseResponse.setCode(Const.CODE_0);
//            baseResponse.setStatus(Const.STATUS_500);
//            baseResponse.setMessage(" FAILED TO FETCHED DESIGNATION LIST");
//            long endTime = System.currentTimeMillis();
//            log.error(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" ERROR OCCURS AT FETCHED TO DESIGNATION LIST EXECUTED TIME ").append(endTime-startTime)),e);
//        }
//        return baseResponse;
//    }
//
//    @Override
//    public BaseResponse<Designation> activeDesignationById(Integer designationId, Boolean status){
//        long startTime = System.currentTimeMillis();
//        log.info(loginUser.getLogId()+" DESIGNATION ACTIVE AND DEACTIVATE METHOD START");
//        BaseResponse baseResponse=new BaseResponse<>();
//        try{
//            Designation designation  = this.designationRepository.findByIsDeletedAndIsActiveAndId(false,true,designationId);
//            if(status) {
//                designation.setIsActive(status);
//                designationRepository.save(designation);
//                List<Designation> designationList = new ArrayList<>();
//                designationList.add(designation);
//                baseResponse.setCode(Const.CODE_1);
//                baseResponse.setData(designationList);
//                baseResponse.setLogId(loginUser.getLogId());
//                baseResponse.setStatus(Const.STATUS_200);
//                baseResponse.setMessage(" DESIGNATION ACTIVATED SUCCESSFULLY ");
//                log.info(loginUser.getLogId() + " DESIGNATION ACTIVATED SUCCESSFULLY ");
//            }else {
//                designation.setIsActive(status);
//                designationRepository.save(designation);
//                List<Designation> designationList = new ArrayList<>();
//                designationList.add(designation);
//                baseResponse.setCode(Const.CODE_1);
//                baseResponse.setData(designationList);
//                baseResponse.setLogId(loginUser.getLogId());
//                baseResponse.setStatus(Const.STATUS_200);
//                baseResponse.setMessage(" DESIGNATION DEACTIVATED SUCCESSFULLY ");
//                log.info(loginUser.getLogId() + " DESIGNATION DEACTIVATED SUCCESSFULLY ");
//            }
//        }catch(Exception e){
//            baseResponse.setCode(Const.CODE_0);
//            baseResponse.setData(new ArrayList<>());
//            baseResponse.setLogId(null);
//            baseResponse.setStatus(Const.STATUS_500);
//            baseResponse.setMessage(" FAILED TO DELETE DESIGNATION ");
//            long endTime = System.currentTimeMillis();
//            log.error(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" ERROR OCCURS AT DELETED DESIGNATION EXECUTED TIME ").append(endTime-startTime)),e);
//        }
//        long endTime = System.currentTimeMillis();
//        log.info(String.valueOf(new StringBuilder(loginUser.getLogId()).append(" DELETE DESIGNATION METHOD  EXECUTED TIME ").append(endTime-startTime)));
//        return baseResponse;
//    }
//
//}
