package com.AccessManagement.Utils;

import com.AccessManagement.Model.LoginUser;
import com.AccessManagement.Model.Organization;
import com.AccessManagement.Model.Users;
import com.AccessManagement.Repository.OrganizationRepository;
import com.AccessManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginUser loginUser;


    @Override
    public  Boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(Const.EMAIL_REGEX);
        Pattern gmail=Pattern.compile(Const.GMAIL_REGEX);
        Pattern yahoo=Pattern.compile(Const.YAHOO_REGEX);
        Pattern outlook=Pattern.compile(Const.OUTLOOK_REGEX);
        Matcher matcher = pattern.matcher(email);
        Matcher gmailMatcher = gmail.matcher(email);
        Matcher yahooMatcher = yahoo.matcher(email);
        Matcher outlookMatcher = outlook.matcher(email);
        if(gmailMatcher.matches()){
            return true;
        } else if (yahooMatcher.matches()) {
            return false;
        } else if (outlookMatcher.matches()) {
            return false;
        }else {
            return matcher.matches();
        }
    }
    @Override
    public Boolean isValidPAN(String pan) {
        Pattern pattern = Pattern.compile(Const.PAN_REGEX);
        Matcher matcher = pattern.matcher(pan);
        return matcher.matches();
    }
    @Override
    public boolean isValidPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return Pattern.matches(pattern, password);
    }
    @Override
    public Boolean isOrganizationNameValidation(String organizationName){
        List<Organization> organizationNameValidate=organizationRepository.findByIsDeleted(false);
        return organizationNameValidate.stream().anyMatch(key->key.getOrganizationName()!=null && key.getOrganizationName().equalsIgnoreCase( organizationName.trim().replaceAll(" +", "")));
    }

    @Override
    public Boolean isUsernameValidation(String username,String firstName,String lastName){
        List<Users>users=userRepository.findByIsDeletedAndSubOrganizationId(false,loginUser.getSubOrgId());
        return  users.stream().anyMatch(key->key.getUsername()!=null && key.getUsername().equalsIgnoreCase(username) && key.getFirstName().equalsIgnoreCase(firstName) && key.getLastName().equalsIgnoreCase(lastName) );
    }

    @Override
    // Method to validate the mobile number
    public Boolean isValidMobileNumber(String mobileNumber) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(Const.MOBILE_NUMBER_REGEX);
        // Match the input mobile number against the pattern
        Matcher matcher = pattern.matcher(mobileNumber);
        // Return true if the input matches the pattern, false otherwise
        if(matcher.matches()){
            Optional<Users> users=userRepository.findByIsDeletedAndSubOrganizationIdAndMobileNo(false,loginUser.getSubOrgId(),mobileNumber);
            return users.isEmpty();
        }
        return false;
    }
    @Override
    public Boolean duplicateEmailValidation(String email){
        List<Users>users=userRepository.findByIsDeletedAndOrganizationId(false,loginUser.getOrgId());
        return  users.stream().anyMatch(key->key.getEmailId()!=null && key.getEmailId().equalsIgnoreCase(email));
    }

//    @Override
//    public Boolean isRoleNameValidation(String roleName){
//        List<Roles> roles =roleRepository.findByIsDeletedAndOrganizationId(false,loginUser.getOrgId());
//        return roles.stream().anyMatch(key->key.getRoleName()!=null && key.getRoleName().equalsIgnoreCase(roleName));
//    }
    @Override
    public  String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(Const.CHAR.length());
            char randomChar = Const.CHAR.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
