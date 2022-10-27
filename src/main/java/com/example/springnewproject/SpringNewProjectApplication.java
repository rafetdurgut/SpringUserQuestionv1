package com.example.springnewproject;

import com.example.springnewproject.model.User;
import com.example.springnewproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringNewProjectApplication {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringNewProjectApplication.class, args);
    }



}
