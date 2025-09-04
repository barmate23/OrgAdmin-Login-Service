package com.AccessManagement.Service;

import com.AccessManagement.Model.Users;
import com.AccessManagement.Request.UserRequest;
import com.AccessManagement.Response.BaseResponse;


public interface UserService {
    BaseResponse<Users> createUsers(UserRequest userRequest);

    BaseResponse<Users> updateUsers(UserRequest userRequest, Integer userId);

    BaseResponse<Users> getUserById(Integer userId);

    BaseResponse<Users> getAllUser();


    BaseResponse getAllUserWithPagination(Integer pageNo, Integer pageSize, String department, String userType, String designation, Integer moduleId);

    BaseResponse<Users> deleteUserById(Integer userId);


    BaseResponse<Users> activeUserById(Integer userId, Boolean status);

    BaseResponse getModule();

    BaseResponse getSubModule(Integer moduleId);

    BaseResponse getUserLicense(Integer subModuleId);

    BaseResponse getDeviceLicense(Integer subModuleId);

    BaseResponse getItemBuyerList();


    BaseResponse getDropdown(String dropDown);
}
