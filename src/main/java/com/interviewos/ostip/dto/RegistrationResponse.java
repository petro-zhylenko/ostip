package com.interviewos.ostip.dto;

import java.util.UUID;

public record RegistrationResponse(

        UUID userId,

        String message

) {
}