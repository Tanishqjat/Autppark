package com.tanishqpark.tkvparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNoReplyEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@tkvparking.com"); 
        message.setTo(to); // Receiver email
        message.setSubject(subject); // Email subject
        message.setText(text); // Email content
        mailSender.send(message); // Send the email
    }
}
