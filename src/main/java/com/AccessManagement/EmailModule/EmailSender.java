package com.AccessManagement.EmailModule;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {
    Boolean sendMail(String subject, String message, String to, Integer orgId);
}
