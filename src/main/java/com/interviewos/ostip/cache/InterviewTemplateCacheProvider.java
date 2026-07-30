package com.interviewos.ostip.cache;

import com.interviewos.ostip.entity.InterviewTemplate;
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
@CacheConfig(cacheNames = CacheNames.INTERVIEW_TEMPLATES)
public class InterviewTemplateCacheProvider {

    @Cacheable(key = "#templateId.toString()")
    public InterviewTemplate get(final UUID templateId) {
        return null;
    }

    @CachePut(key = "#templateId.toString()")
    public InterviewTemplate put(final UUID templateId, final InterviewTemplate dto) {
        return dto;
    }

    @CacheEvict(key = "#templateId.toString()")
    public void refresh(final UUID templateId) {
    }

    @CacheEvict(allEntries = true)
    public void refresh() {
    }

}
