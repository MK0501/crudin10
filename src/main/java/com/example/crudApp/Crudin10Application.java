package com.example.crudApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Crudin10Application {

    public static void main(String[] args) {
        SpringApplication.run(Crudin10Application.class, args);
    }


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }





}
