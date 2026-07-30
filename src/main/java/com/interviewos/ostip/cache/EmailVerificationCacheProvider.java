package com.interviewos.ostip.cache;

import com.interviewos.ostip.dto.EmailVerificationToken;
import com.interviewos.ostip.util.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CacheConfig(cacheNames = CacheNames.EMAIL_VERIFICATION)
public class EmailVerificationCacheProvider {

    @Cacheable(key = "#token")
    public EmailVerificationToken get(final String token) {
        return null;
    }

    @CachePut(key = "#token")
    public EmailVerificationToken put(final String token, final EmailVerificationToken dto) {
        return dto;
    }

    @CacheEvict(key = "#token")
    public void refresh(final String token) {
    }

    @CacheEvict(allEntries = true)
    public void refresh() {
    }

}
