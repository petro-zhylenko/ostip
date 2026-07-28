package com.interviewos.ostip;

import org.springframework.boot.SpringApplication;

public class TestOstipApplication {

    public static void main(String[] args) {
        SpringApplication.from(OstipApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
