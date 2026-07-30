package com.interviewos.ostip.service;

import com.interviewos.ostip.entity.Organization;
import com.interviewos.ostip.repository.OrganizationRepo;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepo organizationRepo;

    @Override
    public Organization getOrCreateAndGetOrganization(String name) {
        return organizationRepo.findByNameIgnoreCase(name).orElseGet(() -> createNewOrganization(name));
    }

    private Organization createNewOrganization(@NotBlank String name) {
        Organization org = new Organization();
        org.setName(name);
        return organizationRepo.save(org);
    }
}
