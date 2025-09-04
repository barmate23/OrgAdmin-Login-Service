package com.AccessManagement.EmailModule;

import com.AccessManagement.Model.LoginUser;
import com.AccessManagement.Model.SysConfiguration;
import com.AccessManagement.Repository.SysConfigurationRepository;
import com.AccessManagement.Utils.EmailConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EmailSenderImpl implements  EmailSender{

    @Autowired
    SysConfigurationRepository configurationRepository;

    @Autowired
    LoginUser loginUser;

    @Override
    public Boolean sendMail(String subject, String message, String to, Integer orgId) {
       Boolean status;
        List<SysConfiguration> config=configurationRepository.findByIsDeleted(false);

        SysConfiguration host = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_HOST)).findFirst().get();
        SysConfiguration port = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_PORT)).findFirst().get();
        SysConfiguration sslEnable = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_SSL_ENABLE)).findFirst().get();
        SysConfiguration username = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_USERNAME)).findFirst().get();
        SysConfiguration password = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_PASSWORD)).findFirst().get();
        SysConfiguration auth = config.stream().filter( key-> key.getConfigName().equals(EmailConstant.MAIL_SMTP_AUTH)).findFirst().get();

        Properties properties = System.getProperties();
        properties.setProperty(host.getConfigName(), host.getConfigValue());
        properties.setProperty(port.getConfigName(), port.getConfigValue());
        properties.setProperty(sslEnable.getConfigName(), sslEnable.getConfigValue());
        properties.setProperty(auth.getConfigName(), auth.getConfigValue());             // SMTP port

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username.getConfigValue(), password.getConfigValue());
            }
        });
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Recipient's email
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
            status=true;
            System.out.println("EMAIL SENT SUCCESSFULLY");
        } catch (MessagingException e) {
            e.printStackTrace();
            status=false;
            System.err.println("Error sending email: " + e.getMessage());
        }
        return status;
    }
}

