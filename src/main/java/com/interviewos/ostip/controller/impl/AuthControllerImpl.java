package com.interviewos.ostip.controller.impl;

import com.interviewos.ostip.controller.AuthController;
import com.interviewos.ostip.dto.RegistrationRequest;
import com.interviewos.ostip.dto.RegistrationResponse;
import com.interviewos.ostip.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final RegistrationService registrationService;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        return registrationService.register(request);
    }

    @Override
    public ResponseEntity<Void> verify(String token) {
        registrationService.verify(token);

        return ResponseEntity.noContent().build();
    }
}
