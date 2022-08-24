package com.fatihk.examples.springboot.dockerizationexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping
    public String sayWelcome(){
        return "Welcome to Dockerized Spring Boot Application";
    }

}
