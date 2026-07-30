package com.interviewos.ostip.cache;

import com.interviewos.ostip.entity.AppUser;
import com.interviewos.ostip.util.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CacheConfig(cacheNames = CacheNames.PASSWORD_RESET)
public class ResetPasswordCacheProvider {

    @Cacheable(key = "#token")
    public AppUser get(final String token) {
        return null;
    }

    @CachePut(key = "#token")
    public AppUser put(final String token, final AppUser dto) {
        return dto;
    }

    @CacheEvict(key = "#token")
    public void refresh(final String token) {
    }

    @CacheEvict(allEntries = true)
    public void refresh() {
    }

}
