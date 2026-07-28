package com.interviewos.ostip.dto;

public record ApiError(
        String code,
        String message
) {}
