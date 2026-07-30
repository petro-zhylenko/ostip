package com.interviewos.ostip.repository;

import com.interviewos.ostip.entity.Role;
import com.interviewos.ostip.security.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(RoleName roleName);
}
