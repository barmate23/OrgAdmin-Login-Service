package com.AccessManagement.Model;

import lombok.Data;

@Data
public class GenerateOTPRequest {
    public String email;
    public String username;
    public String defaultPassword;
    public String newPassword;
    public Integer otp;
}
