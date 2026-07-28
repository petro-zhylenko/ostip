package com.interviewos.ostip.mapper;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    @Mapping(target = "organization", ignore = true)
    Candidate toEntity(CandidateCreateRequest request);

    CandidateResponse toResponse(Candidate candidate);

}