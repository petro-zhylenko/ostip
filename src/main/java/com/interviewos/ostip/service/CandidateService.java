package com.interviewos.ostip.service;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;

import java.util.UUID;

public interface CandidateService {
    CandidateResponse getById(UUID id);
    CandidateResponse create(CandidateCreateRequest request);
}
