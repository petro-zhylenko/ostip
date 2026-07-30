package com.interviewos.ostip.service;

public interface EmailSender {
    void sendVerificationEmail(
            String email,
            String token
    );
}
