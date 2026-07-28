package com.interviewos.ostip.mapper;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.entity.Candidate;

public interface CandidateMapperService {
    Candidate toEntity(CandidateCreateRequest request);
    CandidateResponse toResponse(Candidate candidate);
}
