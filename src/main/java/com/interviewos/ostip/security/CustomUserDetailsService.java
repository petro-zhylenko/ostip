package com.interviewos.ostip.security;

import com.interviewos.ostip.entity.AppUser;
import com.interviewos.ostip.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {


    private final AppUserRepo repository;


    @Override
    public UserDetails loadUserByUsername(String email) {

        AppUser user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(email)
                );


        return new UserPrincipal(user);
    }
}
