package com.AccessManagement.Utils;

import org.springframework.stereotype.Service;

@Service
public interface ValidationService {
    Boolean isValidEmail(String email);

    Boolean isValidPAN(String pan);

    boolean isValidPassword(String password);

    Boolean isOrganizationNameValidation(String organizationName);

    Boolean isUsernameValidation(String username,String firstName,String lastName);

    // Method to validate the mobile number
    Boolean isValidMobileNumber(String mobileNumber);

    Boolean duplicateEmailValidation(String email);



    String generateRandomPassword();
}
