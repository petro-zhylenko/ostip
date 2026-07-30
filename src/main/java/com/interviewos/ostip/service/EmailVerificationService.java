package com.interviewos.ostip.service;

import com.interviewos.ostip.entity.AppUser;

public interface EmailVerificationService {
    String createToken(AppUser user);

    void verify(String token);
}
