package com.interviewos.ostip.dto;

import java.time.Instant;
import java.util.UUID;

public record EmailVerificationToken(

        UUID userId,

        String email,

        Instant createdAt

) {
}
