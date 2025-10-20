package com.ordep.emailservice.controller;

import com.ordep.emailservice.dto.ContactRequest;
import com.ordep.emailservice.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmailContactRequest(@RequestBody @Valid ContactRequest contactRequest) {
        try {
            String response = emailService.sendContactRequest(contactRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred while trying to send a contact request"+e.getMessage());
        }
    }

}
