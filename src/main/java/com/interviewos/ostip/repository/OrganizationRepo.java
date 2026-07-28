package com.interviewos.ostip.repository;

import com.interviewos.ostip.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, UUID> {
}
