package com.SendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {



    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String email, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("piyushbhattarai04@gmail.com");  // Your email address
            mailMessage.setSubject("New Contact Form Submission from " + name);
            mailMessage.setText("Message: " + message + "\nFrom: " + name + " (" + email + ")");
            mailMessage.setReplyTo(email);  // Set the reply-to to the user's email

            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            throw e;
        }
    }
}
