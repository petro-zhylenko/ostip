package com.interviewos.ostip.exception;

import java.util.UUID;

public class CandidateNotFoundException extends ResourceNotFoundException {
    public CandidateNotFoundException(UUID message) {
        super("Candidate not found %s".formatted(message));
    }
}
