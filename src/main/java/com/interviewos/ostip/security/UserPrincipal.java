package com.interviewos.ostip.security;

import com.interviewos.ostip.entity.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {


    private final AppUser user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return user.getRoles()
                .stream()
                .map(role ->
                        new SimpleGrantedAuthority(
                                "ROLE_" + role.getName().name()
                        )
                )
                .toList();
    }


    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }


    @Override
    public String getUsername() {
        return user.getEmail();
    }


    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}