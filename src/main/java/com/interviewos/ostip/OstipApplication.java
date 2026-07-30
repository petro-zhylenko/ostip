package com.interviewos.ostip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OstipApplication {

    public static void main(String[] args) {
        SpringApplication.run(OstipApplication.class, args);
    }

}
