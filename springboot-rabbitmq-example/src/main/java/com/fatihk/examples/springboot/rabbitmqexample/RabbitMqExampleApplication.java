package com.fatihk.examples.springboot.rabbitmqexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableRabbit
public class RabbitMqExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqExampleApplication.class, args);
    }
}