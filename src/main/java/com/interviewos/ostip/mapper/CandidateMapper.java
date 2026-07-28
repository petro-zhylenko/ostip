package com.interviewos.ostip.mapper;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.entity.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    Candidate toEntity(CandidateCreateRequest request);

    CandidateResponse toResponse(Candidate candidate);

}