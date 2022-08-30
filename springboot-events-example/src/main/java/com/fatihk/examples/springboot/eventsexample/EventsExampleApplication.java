package com.fatihk.examples.springboot.eventsexample;

import com.fatihk.examples.springboot.eventsexample.model.User;
import com.fatihk.examples.springboot.eventsexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventsExampleApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(EventsExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(new User("user1", "pwd1"));
        userService.createUser(new User("user2", "pwd2"));
    }
}
