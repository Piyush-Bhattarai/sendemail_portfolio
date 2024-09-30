package com.SendEmail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendContactMessage(@RequestBody ContactRequest contactRequest) {
        try {
            emailService.sendEmail(contactRequest.getName(), contactRequest.getEmail(), contactRequest.getMessage());
            return new ResponseEntity<>("Message sent successfully!", HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>("Failed to send the message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
