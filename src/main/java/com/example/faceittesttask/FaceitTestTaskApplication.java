package com.example.faceittesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FaceitTestTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(FaceitTestTaskApplication.class, args);
    }
}
