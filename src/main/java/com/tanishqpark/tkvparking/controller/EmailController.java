package com.tanishqpark.tkvparking.controller;

import com.tanishqpark.tkvparking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendNoReplyEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message) {
        emailService.sendNoReplyEmail(to, subject, message);
        return "No-reply email sent successfully!";
    }
}
