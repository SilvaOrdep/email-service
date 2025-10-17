package com.ordep.emailservice.controller;

import com.ordep.emailservice.dto.ContactRequest;
import com.ordep.emailservice.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmailContactRequest(@RequestBody @Valid ContactRequest contactRequest) {
        String response = emailService.sendContactRequest(contactRequest);
        return ResponseEntity.ok(response);
    }

}
