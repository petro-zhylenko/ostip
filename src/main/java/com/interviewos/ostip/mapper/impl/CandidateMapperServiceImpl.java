package com.interviewos.ostip.mapper.impl;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.entity.Candidate;
import com.interviewos.ostip.entity.Organization;
import com.interviewos.ostip.mapper.CandidateMapper;
import com.interviewos.ostip.mapper.CandidateMapperService;
import com.interviewos.ostip.repository.OrganizationRepo;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateMapperServiceImpl implements CandidateMapperService {
    private final CandidateMapper mapper;
    private final OrganizationRepo organizationRepo;
    @Override
    public Candidate toEntity(CandidateCreateRequest request) {
        Candidate entity = mapper.toEntity(request);
        entity.setOrganization(organizationRepo.findByNameIgnoreCase(request.organization()).orElseGet(() -> createNewOrganization(request.organization())));

        return entity;
    }

    private Organization createNewOrganization(@NotBlank String name) {
        Organization org = new Organization();
        org.setName(name);
        return organizationRepo.save(org);
    }

    @Override
    public CandidateResponse toResponse(Candidate candidate) {
        return mapper.toResponse(candidate);
    }
}
