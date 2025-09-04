package com.AccessManagement.Config;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data

public class JwtResponse {
	private  String jwttoken;
	private String refreshToken;
	private SessionData sessionData;

}




