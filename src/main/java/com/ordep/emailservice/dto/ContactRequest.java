package com.ordep.emailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactRequest(@Email String sender, @NotBlank String subject, @NotBlank String message) {
}
