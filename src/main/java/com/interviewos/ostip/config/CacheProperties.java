package com.interviewos.ostip.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(
        prefix = "interviewos.cache"
)
@Getter
@Setter
public class CacheProperties {

    private Map<String, Duration> ttl = new HashMap<>();

}