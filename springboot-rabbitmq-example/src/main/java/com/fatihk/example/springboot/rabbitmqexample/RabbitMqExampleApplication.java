package com.fatihk.example.springboot.rabbitmqexample;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableRabbit
public class RabbitMqExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqExampleApplication.class, args);
    }
}
