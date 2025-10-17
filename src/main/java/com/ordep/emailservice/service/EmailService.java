package com.ordep.emailservice.service;

import com.ordep.emailservice.dto.ContactRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendContactRequest(ContactRequest contactRequest) {
        try {
            MimeMessagePreparator mailMessage = mimeMessage -> {
                MimeMessageHelper message = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                message.setTo(contactRequest.recipient());
                message.setSubject(contactRequest.subject());
                message.setText(contactRequest.message());
            };
            mailSender.send(mailMessage);
            return "Contact request email sent successfully";
        } catch (Exception e) {
            return "An error occurred while trying to send a contact request - "+e.getMessage();
        }
    }

}
