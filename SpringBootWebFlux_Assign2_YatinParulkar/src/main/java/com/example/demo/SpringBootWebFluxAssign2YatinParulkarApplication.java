package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller", "service", "repository", "model"})
public class SpringBootWebFluxAssign2YatinParulkarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebFluxAssign2YatinParulkarApplication.class, args);
    }
}
