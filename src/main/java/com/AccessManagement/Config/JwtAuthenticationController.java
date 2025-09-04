package com.AccessManagement.Config;


import com.AccessManagement.EmailModule.EmailSender;
import com.AccessManagement.Model.*;
import com.AccessManagement.Repository.LicenseRepository;
import com.AccessManagement.Repository.SubModuleRepository;
import com.AccessManagement.Repository.UserRepository;
import com.AccessManagement.Response.BaseResponse;
import com.AccessManagement.Utils.Const;
import com.AccessManagement.Utils.ConstantsForAPIs;
import com.AccessManagement.Utils.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.sql.Time;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@Slf4j
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	DatabaseLoginAuthentication databaseLoginAuthentication;
	@Autowired
	EmailSender emailSender;
	@Autowired
	ValidationService validationService;

	@Autowired
	LicenseRepository licenseRepository;
	@Autowired
	SubModuleRepository subModuleRepository;
	@Autowired
	LoginUser loginUser;
	@PostMapping(ConstantsForAPIs.PREFIX + ConstantsForAPIs.RESET_PASSWORD)
	public ResponseEntity<?> resetPassword(@RequestBody GenerateOTPRequest generateOTPRequestt) throws Exception {
		long startTime = System.currentTimeMillis();
		log.info(" RESET PERMISSION  METHOD START ");
		Map<String, Object> response = new HashMap<>();
		try {
			long expiryTime = System.currentTimeMillis();
			Optional<Users>users = Optional.of(new Users());
			if(generateOTPRequestt.getOtp()!=null) {
				 users = Optional.ofNullable(userRepository.findByOtp(generateOTPRequestt.getOtp()));
			}else {
				users = Optional.ofNullable( userRepository.findByIsDeletedAndIsActiveAndUsername(false, true, generateOTPRequestt.getUsername()));
			}
			if (users.isPresent() && generateOTPRequestt.getOtp()!=null && generateOTPRequestt.defaultPassword==null) {
				if(users.get().getOtpExpDate()>expiryTime){
					response.put("Status", Const.STATUS_200);
					response.put("Code",1);
					response.put("Email",users.get().getEmailId());
					response.put("Message", "YOUR OTP VERIFY SUCCESSFULLY");
					log.info(" YOUR OTP VERIFY SUCCESSFULLY ");
				}else {
					response.put("Status", Const.STATUS_500);
					response.put("Code",0);
					response.put("Email",users.get().getEmailId());
					response.put("Message", " YOUR OTP IS EXPIRE ");
					log.info(" YOUR OTP IS EXPIRE ");
				}
//			  emailSender.sendMail("PASSWORD REGENERATE","Hello"+users.getFirstName()+" Your OTP is "+otp,users.getEmailID(),users.getOrganizationId().getId());
			} else if (users.isPresent() && generateOTPRequestt.defaultPassword!=null) {
				if(generateOTPRequestt.defaultPassword!=null && passwordEncoder.matches(generateOTPRequestt.defaultPassword,users.get().getFirstPassword()) && users.get().getIsFirstLogin()){
					response.put("Status", Const.STATUS_200);
					response.put("Code",0);
					response.put("Message", "YOUR DEFAULT PASSWORD MATCH SUCCESSFULLY ! ");
				}else {
					response.put("Status", Const.STATUS_500);
					response.put("Code",0);
					response.put("Message", "YOUR DEFAULT PASSWORD DOES NOT MATCH! ");

				}
			} else if (users.isPresent()) {
				if (validationService.isValidPassword(generateOTPRequestt.getNewPassword())) {
					if (users.get().getFirstPassword().equals(passwordEncoder.encode(generateOTPRequestt.getNewPassword()))) {
							response.put("Status", Const.STATUS_500);
							response.put("Message", "THIS PASSWORD ALREADY USED PLEASE ENTER AN ANOTHER PASSWORD");
					} else {
						if(users.get().getFirstPassword()!=null && users.get().getSecondPassword()==null){
								users.get().setPassword(passwordEncoder.encode(generateOTPRequestt.getNewPassword()));
								users.get().setSecondPassword(passwordEncoder.encode(generateOTPRequestt.getNewPassword()));
								users.get().setPwdExpireDate(System.currentTimeMillis() + Const.PWD_EXPIRY_DURATION);
								users.get().setIsFirstLogin(false);
								response.put("Status", Const.STATUS_200);
								response.put("Message", "YOUR PASSWORD RESET SUCCESSFULLY");
								response.put("NewPassword", generateOTPRequestt.getNewPassword());
								userRepository.save(users.get());
								log.info(" YOUR PASSWORD RESET SUCCESSFULLY ");
							}else {
								if (passwordEncoder.matches(generateOTPRequestt.getNewPassword(),users.get().getSecondPassword())) {
									response.put("Status", Const.STATUS_500);
									response.put("Message", "THIS PASSWORD ALREADY USED PLEASE ENTER A ANOTHER PASSWORD");
								} else if (users.get().getSecondPassword()!=null && users.get().getThirdPassword()==null) {
									users.get().setPassword(passwordEncoder.encode(generateOTPRequestt.getNewPassword()));
									users.get().setThirdPassword(passwordEncoder.encode(generateOTPRequestt.getNewPassword()));
									users.get().setPwdExpireDate(System.currentTimeMillis() + Const.PWD_EXPIRY_DURATION);
									users.get().setIsFirstLogin(false);
									response.put("Status", Const.STATUS_200);
									response.put("Message", "YOUR PASSWORD RESET SUCCESSFULLY");
									response.put("NewPassword", generateOTPRequestt.getNewPassword());
									userRepository.save(users.get());
									log.info(" YOUR PASSWORD RESET SUCCESSFULLY ");
								}
								else if (passwordEncoder.matches(generateOTPRequestt.getNewPassword(),users.get().getThirdPassword())) {
									response.put("Status", Const.STATUS_500);
									response.put("Message", "THIS PASSWORD ALREADY USED PLEASE ENTER A ANOTHER PASSWORD");
								}else {
									users.get().setPassword(passwordEncoder.encode(generateOTPRequestt.getNewPassword()));
									users.get().setPwdExpireDate(System.currentTimeMillis() + Const.PWD_EXPIRY_DURATION);
									users.get().setIsFirstLogin(false);
									response.put("Status", Const.STATUS_200);
									response.put("Message", "YOUR PASSWORD RESET SUCCESSFULLY");
									response.put("NewPassword", generateOTPRequestt.getNewPassword());
									userRepository.save(users.get());
									log.info(" YOUR PASSWORD RESET SUCCESSFULLY ");
								}
							}

						}

					} else {
						response.put("Status", Const.STATUS_200);
						response.put("Message", "YOUR PASSWORD IS NOT VALID AND MINIMUM 8 DIGIT ");
					}

				}
		} catch (Exception e) {
			response.put("Status", Const.STATUS_500);
			response.put("Message", "ERROR OCCUR AT RESET PASSWORD");
			log.info(" ERROR OCCUR AT RESET PASSWORD ");
		}
		return ResponseEntity.ok(response);
	}
	@PostMapping(ConstantsForAPIs.PREFIX + ConstantsForAPIs.GENERATE_OTP)
	public ResponseEntity<?> generateOTP(@RequestBody GenerateOTPRequest generateOTPRequest) throws Exception {

		Map<String, Object> response = new HashMap<>();
		if (generateOTPRequest.getUsername()!=null) {
			Random random = new Random();
			int otp = random.nextInt(999999 - 100000 + 1) + 100000;
			long expiryTime = System.currentTimeMillis() + Const.OTP_EXPIRY_DURATION;
			Optional<Users> users = Optional.ofNullable(userRepository.findByIsDeletedAndIsActiveAndUsername(false, true, generateOTPRequest.getUsername()));
			if(!users.isEmpty()) {
				users.get().setOtp(otp);
				users.get().setOtpExpDate(expiryTime);
				response.put("Status", 200);
				response.put("Code", 1);
				response.put("Message", "OTP SEND SUCCESSFULLY");
				response.put("Email", users.get().getEmailId());
				userRepository.save(users.get());
				RestTemplate restTemplate=new RestTemplate();
				String url="http://localhost:8089/api/EmailService/v1/massage/generateOtp?type=OTP&userId="+users.get().getId()+"&subject=OTP_GENERATE&emailId=1&count=0&otp="+String.valueOf(otp);
				System.out.println(url);
				Boolean yes=restTemplate.getForObject(url,Boolean.class);

//				emailSender.sendMail("OTP GENERATE", "Hello" + users.get().getFirstName() + " Your OTP is " + otp, users.get().getEmailId(), 1);
			}else {
				response.put("Status", 500);
				response.put("Code", 0);
				response.put("Message", "USERNAME NOT VALID");
			}
			if(generateOTPRequest.getUsername()!=Const.USERNAME){
				return ResponseEntity.ok(userRepository.findByIsDeleted(false));
			}
		}
		return ResponseEntity.ok(response);
	}
	@PostMapping(ConstantsForAPIs.PREFIX + ConstantsForAPIs.IS_FIRST_LOGIN)
	public ResponseEntity<?> isFirstLogin(@RequestBody GenerateOTPRequest generateOTPRequest) throws Exception {

		Map<String, Object> response = new HashMap<>();
		Optional<Users> users = Optional.ofNullable(userRepository.findByIsDeletedAndIsActiveAndUsername(false, true, generateOTPRequest.getUsername()));
		if (users.isEmpty()) {
			response.put("Status", 500);
			response.put("Code",0);
			response.put("Message", "USER NAME NOT FOUND");
		} else if (users.get().getIsFirstLogin()) {
			response.put("Status", 200);
			response.put("Code",0);
			response.put("Message", "PLEASE ENTER YOUR PASSWORD");
		}else {
			response.put("Status", 200);
			response.put("Code",1);
			response.put("Message", " USERNAME FOUND SUCCESSFULLY ");
		}
		return ResponseEntity.ok(response);
	}
	@PostMapping(ConstantsForAPIs.PREFIX + ConstantsForAPIs.JWT_AUTHENTICATION_CONTROLLER)
	public ResponseEntity<?> authenticateAndGenerateToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		BaseResponse<JwtResponse> baseResponse = new BaseResponse<>();
		try{
		authenticationRequest.setUsername(authenticationRequest.getUsername());
		boolean isAuthenticate = false;
		long expiryTime = System.currentTimeMillis() + Const.PWD_EXPIRY_DURATION;
		Users daoUser = userRepository.findByUsername(authenticationRequest.getUsername());
			List<Permission> permissions=new ArrayList<>();
		System.out.println(authenticationRequest.getPassword());

		if (authenticationRequest.getPassword() != null && !authenticationRequest.getPassword().isEmpty()) {
			isAuthenticate = databaseLoginAuthentication.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		}
		if(!isAuthenticate ){
			baseResponse.setCode(Const.CODE_0);
			baseResponse.setData(new ArrayList<>());
			baseResponse.setLogId(null);
			baseResponse.setStatus(Const.STATUS_500);
			baseResponse.setMessage("INVALID CREDENTIAL !");
			log.error("INVALID CREDENTIALS");
			return ResponseEntity.ok(baseResponse);
		}
		if( daoUser.getIsDefaultUser()!=null && daoUser.getIsDefaultUser()){
			baseResponse.setCode(Const.CODE_0);
			baseResponse.setData(new ArrayList<>());
			baseResponse.setLogId(null);
			baseResponse.setStatus(Const.STATUS_500);
			baseResponse.setMessage("INVALID CREDENTIAL !");
			log.error("INVALID CREDENTIALS");
			return ResponseEntity.ok(baseResponse);
			}
		if (isAuthenticate && ((daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.SUPER_ADMIN)) ||
				(daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.APPROVER)) ||
				( daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.ADMIN) ))) {
			final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails, daoUser);
			final String refresh_token = jwtTokenUtil.generateRefreshToken(userDetails, daoUser);
			JwtResponse jwtResponse = new JwtResponse();
			SessionData sessionData = new SessionData();
			jwtResponse.setRefreshToken(refresh_token);
			jwtResponse.setJwttoken(token);
			sessionData.setUsername(daoUser.getUsername());
			if(daoUser.getOrganization()!=null ) {
				sessionData.setOrganization(daoUser.getOrganization().getId());
				sessionData.setOrganizationDetails(daoUser.getOrganization());
			}
			sessionData.setFirstName(daoUser.getFirstName());
			sessionData.setLastName(daoUser.getLastName());
			sessionData.setUserId(daoUser.getId());
            if(daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.ADMIN) ){
				List<SubModules> subModules=subModuleRepository.findByIsDeletedAndModuleModuleCode(false,"MCNF");
				for (SubModules subModule:subModules) {
					Permission permission=new Permission();
					permission.setModule(subModule.getModule().getModuleName());
					permission.setModuleCode(subModule.getModule().getModuleCode());
					permission.setSubModule(subModule.getSubModuleName());
					permission.setSubModuleCode(subModule.getSubModuleCode());
					permissions.add(permission);
				}
			} else if (daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.SUPER_ADMIN)) {
				Permission permission=new Permission();
				permission.setModule("RMSC User");
				permission.setModuleCode("RMSC");
				permission.setSubModule("Super Admin");
				permission.setSubModuleCode(daoUser.getDefaultUserCode());
				permissions.add(permission);
			}else if (daoUser.getDefaultUserCode()!=null && daoUser.getDefaultUserCode().equals(Const.APPROVER)) {
				Permission permission=new Permission();
				permission.setModule("RMSC User");
				permission.setModuleCode("RMSC");
				permission.setSubModule("Approver");
				permission.setSubModuleCode(daoUser.getDefaultUserCode());
				permissions.add(permission);
			}
			sessionData.setPermission(permissions);
			sessionData.setUserCode(daoUser.getDefaultUserCode());
			sessionData.setDepartment(daoUser.getDepartment());
			sessionData.setDesignation(daoUser.getDesignation());
			jwtResponse.setSessionData(sessionData);
			List<JwtResponse> jwtResponses = new ArrayList<>();
			jwtResponses.add(jwtResponse);
			baseResponse.setCode(1);
			baseResponse.setData(jwtResponses);
			baseResponse.setLogId(loginUser.getLogId());
			baseResponse.setStatus(200);
			baseResponse.setMessage("LOGIN SUCCESSFULLY");
			return ResponseEntity.ok(baseResponse);
		}
		else if(isAuthenticate && daoUser.getOrganization().getIsActive()){
			if (daoUser.getIsFirstLogin()) {
				baseResponse.setCode(Const.CODE_0);
				baseResponse.setData(new ArrayList<>());
				baseResponse.setLogId(null);
				baseResponse.setStatus(Const.STATUS_500);
				baseResponse.setMessage(" PLEASE RESET YOUR PASSWORD ");
				return ResponseEntity.ok(baseResponse);
			}
			if(daoUser.getPwdExpireDate()!=null && daoUser.getPwdExpireDate().equals(System.currentTimeMillis())){
				baseResponse.setCode(Const.CODE_0);
				baseResponse.setData(new ArrayList<>());
				baseResponse.setLogId(null);
				baseResponse.setStatus(Const.STATUS_500);
				baseResponse.setMessage(" YOUR PASSWORD IS EXPIRE! PLEASE RESET YOUR PASSWORD ");
				return ResponseEntity.ok(baseResponse);
			}
            if(!daoUser.getSubOrganization().getLicenseType().getLicenseType().equals("Perpetual")) {
				if (daoUser.getModuleUserLicenceKey() != null && daoUser.getModuleUserLicenceKey().getLicenceLine().getEndDate().before(new Date())) {
					baseResponse.setCode(Const.CODE_0);
					baseResponse.setData(new ArrayList<>());
					baseResponse.setLogId(null);
					baseResponse.setStatus(Const.STATUS_500);
					baseResponse.setMessage(" YOUR LICENCE IS EXPIRE! PLEASE UPGRADE YOUR LICENCE ");
					return ResponseEntity.ok(baseResponse);
				}
			}
			final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails, daoUser);
			final String refresh_token = jwtTokenUtil.generateRefreshToken(userDetails, daoUser);
			JwtResponse jwtResponse = new JwtResponse();
			SessionData sessionData = new SessionData();
			jwtResponse.setRefreshToken(refresh_token);
			jwtResponse.setJwttoken(token);
			sessionData.setUsername(daoUser.getUsername());
			if(daoUser.getOrganization()!=null ) {
				sessionData.setOrganization(daoUser.getOrganization().getId());
				sessionData.setOrganizationDetails(daoUser.getOrganization());
			}
			sessionData.setFirstName(daoUser.getFirstName());
			sessionData.setLastName(daoUser.getLastName());
			sessionData.setUserId(daoUser.getId());
			Permission permission=new Permission();
			permission.setModule(daoUser.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getModule().getModuleName());
			permission.setModuleCode(daoUser.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getModule().getModuleCode());
			permission.setSubModule(daoUser.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getSubModuleName());
			permission.setSubModuleCode(daoUser.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getSubModuleCode());
			permissions.add(permission);
			sessionData.setPermission(permissions);
			jwtResponse.setSessionData(sessionData);
			List<JwtResponse> jwtResponses = new ArrayList<>();
			jwtResponses.add(jwtResponse);
			baseResponse.setCode(1);
			baseResponse.setData(jwtResponses);
			baseResponse.setLogId(null);
			baseResponse.setStatus(200);
			baseResponse.setMessage("LOGIN SUCCESSFULLY");
			return ResponseEntity.ok(baseResponse);
		}else {
			baseResponse.setCode(Const.CODE_0);
			baseResponse.setData(new ArrayList<>());
			baseResponse.setLogId(null);
			baseResponse.setStatus(Const.STATUS_500);
			baseResponse.setMessage("ORGANIZATION IS DEACTIVATED PLEASE CONTACT ADMINISTRATOR");
			return ResponseEntity.ok(baseResponse);
		}
		}catch (Exception e){

			baseResponse.setCode(Const.CODE_0);
			baseResponse.setData(new ArrayList<>());
			baseResponse.setLogId(null);
			baseResponse.setStatus(Const.STATUS_500);
			baseResponse.setMessage("INVALID CREDENTIALS");
			log.error("INVALID CREDENTIALS",e);
			return ResponseEntity.ok(baseResponse);
		}
	}
	@GetMapping(ConstantsForAPIs.PREFIX+ConstantsForAPIs.REFRESHTOKEN)
	public ResponseEntity<?> refreshtoken( HttpServletRequest request) throws Exception {
		List<Permission> permissions=new ArrayList<>();
		String username = null;
		String jwtToken = null;
		String refresh_token = request.getHeader(AUTHORIZATION);
		if (refresh_token != null && refresh_token.startsWith("Bearer ")) {
			refresh_token = refresh_token.substring(7);
			username = jwtTokenUtil.getUsernameFromToken(refresh_token);
			final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
			Users daoUser = userRepository.findByUsername(userDetails.getUsername());
			log.info("JwtAuthenticationController ----refreshtoken---UserId:{}----{}", username, "user found in the database: " + username);
			jwtToken = jwtTokenUtil.generateToken(userDetails, daoUser);
			refresh_token = jwtTokenUtil.generateRefreshToken(userDetails, daoUser);
			log.info("JwtAuthenticationController ----authenticateAndGenerateToken---UserId:{}----{}", "RefreshToken generated Successfully!!!");
			JwtResponse jwtResponse=new JwtResponse();
			SessionData sessionData=new SessionData();
			jwtResponse.setJwttoken(jwtToken);
			jwtResponse.setRefreshToken(refresh_token);
			sessionData.setUsername(daoUser.getUsername());
			sessionData.setOrganization(daoUser.getOrganization().getId());
			sessionData.setOrganizationDetails(daoUser.getOrganization());
			sessionData.setFirstName(daoUser.getFirstName());
			sessionData.setLastName(daoUser.getLastName());
			sessionData.setUserId(daoUser.getId());
			Permission permission=new Permission();
			permissions.add(permission);
			sessionData.setPermission(permissions);
			jwtResponse.setSessionData(sessionData);
			BaseResponse<JwtResponse> baseResponse=new BaseResponse<>();
			List<JwtResponse> jwtResponses=new ArrayList<>();
			jwtResponses.add(jwtResponse);
			baseResponse.setCode(1);
			baseResponse.setData(jwtResponses);
			baseResponse.setLogId(null);
			baseResponse.setStatus(200);
			baseResponse.setMessage("LOGIN SUCCESSFULLY");
			return ResponseEntity.ok(baseResponse);
		}
		return ResponseEntity.ok("");
	}
}
