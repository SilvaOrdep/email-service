package com.ordep.emailservice.service;

import com.ordep.emailservice.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String recipient;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendContactRequest(ContactRequest contactRequest) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(contactRequest.sender());
            mailMessage.setSubject(contactRequest.subject());
            mailMessage.setTo(recipient);
            mailSender.send(mailMessage);
            return "Contact request email sent successfully";
        } catch (Exception e) {
            return "An error occurred while trying to send a contact request: "+e.getMessage();
        }
    }

}
