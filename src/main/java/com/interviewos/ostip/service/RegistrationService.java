package com.interviewos.ostip.service;

import com.interviewos.ostip.dto.RegistrationRequest;
import com.interviewos.ostip.dto.RegistrationResponse;

public interface RegistrationService {

    RegistrationResponse register(
            RegistrationRequest request
    );

    void verify(String token);
}
