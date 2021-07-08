package com.edts.tdlib.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("wahyuok69@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        mailSender.send(msg);

    }

    public void sendMailHtml(String emailTo, String code, String name) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(emailTo);
        helper.setSubject("Verification Code for TMS Password Recovery");
        helper.setText(templateEmail(emailTo, code, name), true);
        mailSender.send(message);
    }

    String templateEmail(String to, String code, String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b>Dear " + name + " </b>, ");
        stringBuilder.append("<br><br> To verify your password recovery for Telegram Management System,");
        stringBuilder.append("<br> enter the following Verification Code into the verification screen:");
        stringBuilder.append("<br> <b>" + code + "</b>");
        stringBuilder.append("<br>This verification code will expire within five (5) minutes.");
        stringBuilder.append("<br><br>If this code does not work or has expired, Please request for a new verification code via Resend Code button.");
        stringBuilder.append("<br><br><b>Telegram Management System by EDTS<b>");

        return stringBuilder.toString();
    }


}
