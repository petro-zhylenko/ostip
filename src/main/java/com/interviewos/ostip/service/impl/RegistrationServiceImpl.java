package com.interviewos.ostip.service.impl;

import com.interviewos.ostip.dto.RegistrationRequest;
import com.interviewos.ostip.dto.RegistrationResponse;
import com.interviewos.ostip.entity.AppUser;
import com.interviewos.ostip.entity.Organization;
import com.interviewos.ostip.entity.Role;
import com.interviewos.ostip.repository.AppUserRepo;
import com.interviewos.ostip.repository.RoleRepository;
import com.interviewos.ostip.security.RoleName;
import com.interviewos.ostip.service.EmailSender;
import com.interviewos.ostip.service.EmailVerificationService;
import com.interviewos.ostip.service.OrganizationService;
import com.interviewos.ostip.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final OrganizationService organizationService;
    private final AppUserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final EmailVerificationService emailVerificationService;
    private final EmailSender emailSender;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {


            Organization organization =
                    organizationService.getOrCreateAndGetOrganization(request.organizationName());


            AppUser user = AppUser.builder()
                    .organization(organization)
                    .email(request.email())
                    .passwordHash(
                            passwordEncoder.encode(
                                    request.password()
                            )
                    )
                    .nickname(
                            request.nickname()
                    )
                    .firstName(
                            request.firstName()
                    )
                    .lastName(
                            request.lastName()
                    )
                    .enabled(false)
                    .build();


            Role adminRole =
                    roleRepository.findByName(RoleName.ADMIN)
                            .orElseThrow();


            user.addRole(adminRole);


            userRepository.save(user);


        final String token = emailVerificationService.createToken(user);

        emailSender.sendVerificationEmail(user.getEmail(), token);

            return new RegistrationResponse(
                    user.getId(),
                    "Please verify your email"
            );
        }

    @Override
    public void verify(String token) {
        emailVerificationService.verify(token);
    }
}
