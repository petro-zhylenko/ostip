package com.interviewos.ostip.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSenderImpl implements EmailSender {
    @Override
    public void sendVerificationEmail(String email, String token) {
      log.info("sending email to: {} with token {}", email, token);
    }
}
