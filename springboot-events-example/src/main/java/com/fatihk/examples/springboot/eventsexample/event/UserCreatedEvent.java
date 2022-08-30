package com.fatihk.examples.springboot.eventsexample.event;

import com.fatihk.examples.springboot.eventsexample.model.User;

public class UserCreatedEvent {

    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
