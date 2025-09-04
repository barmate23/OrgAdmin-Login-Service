package com.AccessManagement.Utils;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

public class ConstantsForAPIs {
    public static final String PREFIX = "/api/loginService/v1/";
    public static final String JWT_AUTHENTICATION_CONTROLLER = "authenticate";
    public static final String RESET_PASSWORD="resetPassword";
    public static final String FIND_USER="findUser";
    public static final String GENERATE_OTP="generateOTP";
    public static final String OTP_VERIFY="OTPVerify";
    public static final String IS_FIRST_LOGIN="isFirstLogin";
    public static final String ORGANIZATION="organization";
    public static final String DEPARTMENTS="departments";

    public static final String DESIGNATION="designation";
    public static final String ROLES="roles";
    public static final String REFRESHTOKEN = "refreshToken";

    //users
    public static final String USERS_CONTROLLER="users";
    public static final String CREATE_USERS="/createUsers";
    public static final String UPDATE_USERS="/updateUsers/{userId}";
    public static final String GET_USERS_BY_ID= "/getUserById/{userId}";
    public static final String GET_ALL_USERS="/getAllUser";
    public static final String GET_ALL_USERS_WITH_PAGINATION="/geAllUserWithPagination";
    public static final String DELETE_USERS_BY_ID="/deleteUserById/{userId}";
    public static final String ACTIVE_USERS_BY_ID="/activeUserById";

    //ORGANIZATION
    public static final String GET_ORGANIZATION_BY_ID="getOrganizationById/{organizationId}";
    public static final String SAVE_ORGANIZATION="/saveOrganization";
    public static final String UPDATE_ORGANIZATION="/updateOrganization/{organizationId}";
    public static final String GET_ALL_ORGANIZATION="/getAllOrganization";
    public static final String GET_ALL_ORGANIZATION_WITH_PAGINATION="/getAllOrganizationWithPagination";
    public static final String DELETE_ORGANIZATION_BY_ID="/deleteOrganizationById/{organizationId}";
    public static final String ACTIVE_ORGANIZATION_BY_ID="/activeOrganizationById";

    //Roles....
    public static final String CREATE_ROLE="/crateRole";
    public static final String UPDATE_ROLE_BY_ID="/updateRole/{roleId}";
    public static final String DELETE_ROLE_BY_ID="/deleteRole/{id}";
    public static final String GET_ROLE_BY_ID="/getRoleById/{roleId}";
    public static final String GET_ALL_ROLE="/getAllRoles";
    public static final String GET_ALL_ROLE_WITH_PAGINATION="/getAllRolesWithPagination";

    //Role And Permission

    public static final String ROLE_AND_PERMISSION="roleAndPermission";
    public static final String CREATE_ROLE_AND_PERMISSION="/createRoleAndPermission";
    public static final String UPDATE_ROLE_AND_PERMISSION="/updateRoleAndPermission";
    public static final String GET_ROLE_AND_PERMISSION_BY_ROLE="/getRoleAndPermissionByRole/{roleId}";
    public static final String GET_ALL_PERMISSION="/getAllPermission";
    public static final String GET_ALL_PERMISSION_WITH_PAGINATION="/getAllPermissionWithPagination";
    public static final String CREATE_ROLE_AND_PERMISSION_MAPPER="/createRoleAndPermissionMapper";
    public static final String UPDATE_ROLE_AND_PERMISSION_MAPPER="/updateRoleAndPermissionMapper/{roleId}";

    public static final String GET_ALL_DESIGNATION="/getAllDesignations";
    public static final String GET_ALL_DEPARTMENT="/getAllDepartment";
    public static final String ACTIVE_DEPARTMENT_BY_ID="/activeDepartmentById";
    public static final String ACTIVE_DESIGNATION_BY_ID="/activeDesignationsById";

    //licence
    public static final String LICENCE_MODULE="licenceModule";
    public static final String SAVE_LICENCE_MODULE="/saveLicenceModule";

    public static final String UPDATE_LICENCE_MODULE="/updateLicenceModule";
    public static final String DELETE_LICENCE_MODULE="/deleteLicenceModuleById/{licenceModuleId}";
    public static final String GET_LICENCE_MODULE="/getLicenceModuleById/{licenceModuleId}";
    public static final String GET_ALL_LICENCE_MODULE="/getAllLicenceModule/{orgId}";

    public static final String GET_USER_LICENSE = "/getUserLicense/{subModuleId}";
    public static final String GET_DEVICE_LICENSE = "/getDeviceLicense/{subModuleId}";
    public static final String GET_LIC_MODULE = "/getModule";
    public static final String GET_LIC_SUB_MODULE = "/getSubMod/{moduleId}";
    public static final String SAVE_ERROR_LOG = "/saveErrorLog";
    public static final String GET_BUYER_ITEM_LIST = "/getBuyerItemMapperList";
    public static final String GET_DROPDOWN = "/getDropdown";
}
