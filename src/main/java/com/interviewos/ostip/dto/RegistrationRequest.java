package com.interviewos.ostip.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8)
        String password,

        @NotBlank
        @Size(min = 3, max = 100)
        String organizationName,

        @NotBlank
        @Size(min = 3, max = 100)
        String nickname,

        String firstName,

        String lastName

) {
}