package com.fatihk.examples.springboot.eventsexample.service;

import com.fatihk.examples.springboot.eventsexample.event.UserCreatedEvent;
import com.fatihk.examples.springboot.eventsexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private List<User> users = new ArrayList<>();

    public void createUser(User user){
        users.add(user);

        eventPublisher.publishEvent(new UserCreatedEvent(user));
    }

}
