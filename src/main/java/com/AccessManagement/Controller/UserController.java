package com.AccessManagement.Controller;

import com.AccessManagement.Model.Users;
import com.AccessManagement.Request.UserRequest;
import com.AccessManagement.Response.BaseResponse;
import com.AccessManagement.Service.UserService;
import com.AccessManagement.Utils.ConstantsForAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ConstantsForAPIs.PREFIX+ConstantsForAPIs.USERS_CONTROLLER})
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping({ConstantsForAPIs.CREATE_USERS})
    public BaseResponse<Users> createUser(@RequestBody UserRequest userRequest) {
        return userService.createUsers(userRequest);
    }
    @PostMapping({ConstantsForAPIs.UPDATE_USERS})
    public BaseResponse<Users> updateUser(@RequestBody UserRequest userRequest, @PathVariable Integer userId) {
        return userService.updateUsers(userRequest,userId);
    }

    @GetMapping({ConstantsForAPIs.GET_USERS_BY_ID})
    public BaseResponse<Users> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping({ConstantsForAPIs.GET_ALL_USERS})
    public BaseResponse<Users> geAllUser() {
        return userService.getAllUser();
    }
    @GetMapping(ConstantsForAPIs.GET_ALL_USERS_WITH_PAGINATION)
    public BaseResponse<Users> getAllUserWithPagination(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String userType,
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) Integer moduleId) {

        return userService.getAllUserWithPagination(pageNo, pageSize, department, userType, designation, moduleId);
    }

    @DeleteMapping({ConstantsForAPIs.DELETE_USERS_BY_ID})
    public BaseResponse<Users> deleteUserById(@PathVariable Integer userId) {
        return userService.deleteUserById(userId);
    }

    @DeleteMapping({ConstantsForAPIs.ACTIVE_USERS_BY_ID})
    public BaseResponse<Users> activeUserById(@RequestParam Integer userId,
                                              @RequestParam Boolean status) {
        return userService.activeUserById(userId,status);
    }

    @GetMapping({ConstantsForAPIs.GET_LIC_MODULE})
    public BaseResponse getModule() {
        return userService.getModule();
    }
    @GetMapping({ConstantsForAPIs.GET_LIC_SUB_MODULE})
    public BaseResponse getSubModule(@PathVariable Integer moduleId) {
        return userService.getSubModule(moduleId);
    }
    @GetMapping({ConstantsForAPIs.GET_USER_LICENSE})
    public BaseResponse getUserLicense(@PathVariable Integer subModuleId) {
        return userService.getUserLicense(subModuleId);
    }
    @GetMapping({ConstantsForAPIs.GET_DEVICE_LICENSE})
    public BaseResponse getDeviceLicense(@PathVariable Integer subModuleId) {
        return userService.getDeviceLicense(subModuleId);
    }

    @GetMapping({ConstantsForAPIs.GET_BUYER_ITEM_LIST})
    public BaseResponse getItemBuyerList() {
        return userService.getItemBuyerList();
    }

    @GetMapping({ConstantsForAPIs.GET_DROPDOWN})
    public BaseResponse getDropdown(@RequestParam String dropDown) {
        return userService.getDropdown(dropDown);
    }



}
