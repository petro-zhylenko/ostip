package com.interviewos.ostip.controller;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/candidates")
public interface CandidateController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CandidateResponse create(
            @Valid @RequestBody CandidateCreateRequest request
    );

    @GetMapping("/{id}")
    CandidateResponse findById(
            @PathVariable UUID id
    );
}
