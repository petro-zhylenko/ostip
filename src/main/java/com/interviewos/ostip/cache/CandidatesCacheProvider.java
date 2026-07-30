package com.interviewos.ostip.cache;

import com.interviewos.ostip.dto.CandidateResponse;
import com.interviewos.ostip.util.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@CacheConfig(cacheNames = CacheNames.CANDIDATES)
public class CandidatesCacheProvider {

    @Cacheable(key = "#candidateId.toString()")
    public CandidateResponse get(final UUID candidateId) {
        return null;
    }

    @CachePut(key = "#candidateId.toString()")
    public CandidateResponse put(final UUID candidateId, final CandidateResponse dto) {
        return dto;
    }

    @CacheEvict(key = "#candidateId.toString()")
    public void refresh(final UUID candidateId) {
    }

    @CacheEvict(allEntries = true)
    public void refresh() {
    }

}
