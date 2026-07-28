package com.interviewos.ostip.dto;

import java.util.UUID;

public record CandidateResponse(

        UUID id,
        String firstName,
        String lastName,
        String email

) {}