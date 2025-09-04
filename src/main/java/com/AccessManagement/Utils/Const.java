package com.AccessManagement.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Const {
    public static final int OTP_LENGTH = 6;
    public static final long OTP_EXPIRY_DURATION = 5 * 60 * 1000; // 5 minutes in milliseconds

    public static final long PWD_EXPIRY_DURATION = 90*24*60 * 60 * 1000;

    public static final String SUPER_ADMIN="SADM";
    public static final String APPROVER="APVR";
    public static final String EMAIL_REGEX = "^[a-z0-9+_.-]+@(.+)$";

    public static final String GMAIL_REGEX = "^[a-z0-9+_.-]+@gmail.com$";
    public static final String YAHOO_REGEX = "^[a-z0-9+_.-]+@yahoo.com$";
    public static final String OUTLOOK_REGEX ="^[a-z0-9+_.-]+@outlook.com$";
    public static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    public static final String MOBILE_NUMBER_REGEX = "^[6-9]\\d{9}$";

    public static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static final Integer STATUS_200=200;
    public static final Integer STATUS_500=500;
    public static final Integer CODE_1=1;
    public static final Integer CODE_0=0;
    public static final String ADMIN="ADMN";
    public static final AtomicInteger accepteRejectedCounter = new AtomicInteger(1);
    public static final int MAX_ACCEPTED_REJECTED__PER_AR = 9;
    public static final String PREFIX_ACCEPTED_REJECTED = "RM";
    public static final String DELIMITER_ACCEPTED_REJECTED_STAGING_AREA = "USER";
    public static final String USERNAME = "MFS1001";
}
