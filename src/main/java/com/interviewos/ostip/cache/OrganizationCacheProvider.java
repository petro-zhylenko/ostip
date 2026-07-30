package com.interviewos.ostip.cache;

import com.interviewos.ostip.entity.Organization;
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
@CacheConfig(cacheNames = CacheNames.ORGANIZATIONS)
public class OrganizationCacheProvider {
    @Cacheable(key = "#organizationId.toString()")
    public Organization get(final UUID organizationId) {
        return null;
    }

    @CachePut(key = "#organizationId.toString()")
    public Organization put(final UUID organizationId, final Organization dto) {
        return dto;
    }

    @CacheEvict(key = "#organizationId.toString()")
    public void refresh(final UUID organizationId) {
    }

    @CacheEvict(allEntries = true)
    public void refresh() {
    }
}
