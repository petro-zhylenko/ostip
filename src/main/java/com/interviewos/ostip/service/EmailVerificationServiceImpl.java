package com.interviewos.ostip.service;

import com.interviewos.ostip.cache.EmailVerificationCacheProvider;
import com.interviewos.ostip.dto.EmailVerificationToken;
import com.interviewos.ostip.entity.AppUser;
import com.interviewos.ostip.exception.ResourceNotFoundException;
import com.interviewos.ostip.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailVerificationServiceImpl implements EmailVerificationService {
    private final EmailVerificationCacheProvider cacheProvider;
    private final AppUserRepo appUserRepo;
    @Override
    public String createToken(AppUser user) {
        String token = UUID.randomUUID().toString();
        cacheProvider.put(token, new EmailVerificationToken(
                user.getId(),
                user.getEmail(),
                Instant.now()
        ));
        return token;
    }

    @Override
    public void verify(String token) {
        if(null == token){
            return;
        }
        Optional<EmailVerificationToken> emailVerificationToken = Optional.ofNullable(cacheProvider.get(token));
        EmailVerificationToken emailVerification = emailVerificationToken.orElseThrow(() -> new ResourceNotFoundException("Token is not valid"));
        AppUser user = appUserRepo.findById(emailVerification.userId()).orElseThrow(() -> {
            cacheProvider.refresh(token);
            return new ResourceNotFoundException("User not found");
        });
        user.setEnabled(true);
        appUserRepo.save(user);
        cacheProvider.refresh(token);
    }
}
