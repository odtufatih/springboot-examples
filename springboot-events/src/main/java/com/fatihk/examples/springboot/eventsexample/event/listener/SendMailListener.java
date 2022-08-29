package com.fatihk.examples.springboot.eventsexample.event.listener;

import com.fatihk.examples.springboot.eventsexample.event.UserCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendMailListener {

    Logger logger = LoggerFactory.getLogger(SendMailListener.class);

    @EventListener
    public void sendMail(UserCreatedEvent userCreatedEvent){
        logger.info("sendMail is working synchronously");
        logger.info("Sending mail to user:" + userCreatedEvent.getUser());
    }

}
