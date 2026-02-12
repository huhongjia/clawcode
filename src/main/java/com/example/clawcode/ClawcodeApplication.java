package com.example.clawcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.clawcode.repository")
public class ClawcodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClawcodeApplication.class, args);
    }
}