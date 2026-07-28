package com.interviewos.ostip.service.impl;

import com.interviewos.ostip.entity.AppUser;
import com.interviewos.ostip.security.UserPrincipal;
import com.interviewos.ostip.service.CurrentUserProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CurrentUserProviderImpl implements CurrentUserProvider {
    @Override
    public Optional<AppUser> getCurrentUser() {
        Authentication auth =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if(Objects.isNull(auth))
            return Optional.empty();

        UserPrincipal principal =
                (UserPrincipal) auth.getPrincipal();

        return Optional.ofNullable(Objects.nonNull(principal) ? principal.getUser() : null);
    }
}
