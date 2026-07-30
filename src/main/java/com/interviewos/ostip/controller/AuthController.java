package com.interviewos.ostip.controller;

import com.interviewos.ostip.dto.RegistrationRequest;
import com.interviewos.ostip.dto.RegistrationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
public interface AuthController {

    @PostMapping("/register")
    RegistrationResponse register(
            @Valid @RequestBody RegistrationRequest request
    );

    @GetMapping("/verify")
    ResponseEntity<Void> verify(
            @RequestParam String token
    );

}
