package com.interviewos.ostip.service;

import com.interviewos.ostip.entity.Organization;

public interface OrganizationService {
    Organization getOrCreateAndGetOrganization(String name);
}
