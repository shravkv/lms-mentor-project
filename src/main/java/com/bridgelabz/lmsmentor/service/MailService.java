package com.bridgelabz.lmsmentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/*
 * Purpose : MailService is  used to Send a mail
 * Version : 1.0
 * @author : Sravan Kumar
 * */

@Component

public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String body, String subject) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sravan.k.vodnala@gmail.com");
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            System.out.println("Email Sent Successfully.........");
    }

    public void send(String email, String body, String subject) {
    }
}
