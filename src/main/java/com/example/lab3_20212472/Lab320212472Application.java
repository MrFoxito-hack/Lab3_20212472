package com.example.lab3_20212472;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.lab3_20212472.entity")
@EnableJpaRepositories("com.example.lab3_20212472.repository")
public class Lab320212472Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab320212472Application.class, args);
    }

}
