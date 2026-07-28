package com.interviewos.ostip.controller.impl;

import com.interviewos.ostip.controller.CandidateController;
import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CandidateControllerImpl implements CandidateController {
    private final CandidateService candidateService;

    @Override
    public CandidateResponse create(CandidateCreateRequest request) {
        return candidateService.create(request);
    }

    @Override
    public CandidateResponse findById(UUID id) {
        return candidateService.getById(id);
    }
}
