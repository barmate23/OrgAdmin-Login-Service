package com.AccessManagement.Config;

import com.AccessManagement.Model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {


	private String secret;
	private int refreshExpirationDateInMin;

	private int jwtExpirationInMin;

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Value("${jwt.refreshExpirationDateInMin}")
	public void setRefreshExpirationDateInMin(int refreshExpirationDateInMin) {
		this.refreshExpirationDateInMin = refreshExpirationDateInMin;
	}

	@Value("${jwt.expirationDateInMin}")
	public void setJwtExpirationInMin(int jwtExpirationInMin) {

		this.jwtExpirationInMin = jwtExpirationInMin;
	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getIssuedAtDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}

	public String generateToken(UserDetails userDetails,Users users) {
		Map<String, Object> claims = new HashMap<>();

		if (users.getSubOrganization()!=null) {
			claims.put("subOrgId", users.getSubOrganization().getId());
			claims.put("subOrgName", users.getSubOrganization().getOrganizationName());
		}
		if (users.getUsername()!=null)
			claims.put("userName",users.getUsername());
		if (users.getId()!=null) {
			claims.put("userId", users.getId());
		}if(users.getOrganization()!=null){
			claims.put("orgId",users.getOrganization().getId());
			claims.put("orgIdName",users.getOrganization().getOrganizationName());
			claims.put("subOrganizationCode",users.getOrganization().getSubOrganizationSequence());
		}
		if(users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("SADM")){
			claims.put("subModuleCode",users.getDefaultUserCode());
		} else if (users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("APVR")) {
			claims.put("subModuleCode",users.getDefaultUserCode());
		}
		else if (users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("ADMN")) {
			claims.put("subModuleCode",users.getDefaultUserCode());
		} else {
			claims.put("subModuleCode",users.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getSubModuleCode());
		}
		return doGenerateToken(claims, userDetails.getUsername());
	}

	public String generateRefreshToken(UserDetails userDetails,Users users) {
		Map<String, Object> claims = new HashMap<>();


		if (users.getSubOrganization()!=null) {
			claims.put("subOrgId", users.getSubOrganization().getId());
			claims.put("subOrgName", users.getSubOrganization().getOrganizationName());
		}
		if (users.getUsername()!=null)
			claims.put("userName",users.getUsername());
		if (users.getId()!=null) {
			claims.put("userId", users.getId());
		}if(users.getOrganization()!=null){
			claims.put("orgId",users.getOrganization().getId());
			claims.put("orgIdName",users.getOrganization().getOrganizationName());
			claims.put("subOrganizationCode",users.getOrganization().getSubOrganizationSequence());
		}
		if(users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("SADM")){
			claims.put("subModuleCode",users.getDefaultUserCode());
		} else if (users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("APVR")) {
			claims.put("subModuleCode",users.getDefaultUserCode());
		}
		else if (users.getDefaultUserCode()!=null && users.getDefaultUserCode().equals("ADMN")) {
			claims.put("subModuleCode",users.getDefaultUserCode());
		} else {
			claims.put("subModuleCode",users.getModuleUserLicenceKey().getLicenceLine().getPartNumberSubModuleMapper().getSubModule().getSubModuleCode());
		}

		return doGenerateRefreshToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (120*60000L)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();

	}

	public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (refreshExpirationDateInMin * 60000L)))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	//To do: validate the token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
