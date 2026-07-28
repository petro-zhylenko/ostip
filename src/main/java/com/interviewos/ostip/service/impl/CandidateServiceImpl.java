package com.interviewos.ostip.service.impl;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.exception.CandidateNotFoundException;
import com.interviewos.ostip.mapper.CandidateMapper;
import com.interviewos.ostip.mapper.CandidateMapperService;
import com.interviewos.ostip.repository.CandidateRepo;
import com.interviewos.ostip.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepo candidateRepository;
    private final CandidateMapperService candidateMapper;

    @Override
    public CandidateResponse getById(UUID id) {
        return candidateMapper.toResponse(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException(id)));
    }

    @Override
    public CandidateResponse create(CandidateCreateRequest request) {
        return candidateMapper.toResponse(candidateRepository.save(candidateMapper.toEntity(request)));
    }
}
