package com.ordep.emailservice.service;

import com.ordep.emailservice.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendContactRequest(ContactRequest contactRequest) {
        MimeMessagePreparator mailMessage = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true, "UTF-8");
            message.setFrom(sender);
            message.setTo(contactRequest.recipient());
            message.setSubject(contactRequest.subject());
            message.setText(contactRequest.message(), true);
        };
        mailSender.send(mailMessage);
        return "Contact request email sent successfully";
    }

}
