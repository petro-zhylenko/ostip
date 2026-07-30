package com.interviewos.ostip.mapper.impl;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.entity.Candidate;
import com.interviewos.ostip.mapper.CandidateMapper;
import com.interviewos.ostip.mapper.CandidateMapperService;
import com.interviewos.ostip.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateMapperServiceImpl implements CandidateMapperService {
    private final CandidateMapper mapper;
    private final OrganizationService organizationService;
    @Override
    public Candidate toEntity(CandidateCreateRequest request) {
        Candidate entity = mapper.toEntity(request);
        entity.setOrganization(organizationService.getOrCreateAndGetOrganization(request.organization()));

        return entity;
    }

    @Override
    public CandidateResponse toResponse(Candidate candidate) {
        return mapper.toResponse(candidate);
    }
}
