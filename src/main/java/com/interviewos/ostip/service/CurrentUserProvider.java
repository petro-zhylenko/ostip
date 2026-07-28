package com.interviewos.ostip.service;

import com.interviewos.ostip.entity.AppUser;

import java.util.Optional;

public interface CurrentUserProvider {
    Optional<AppUser> getCurrentUser();
}
