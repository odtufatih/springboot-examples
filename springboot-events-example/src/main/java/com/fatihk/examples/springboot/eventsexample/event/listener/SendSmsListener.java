package com.fatihk.examples.springboot.eventsexample.event.listener;

import com.fatihk.examples.springboot.eventsexample.event.UserCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendSmsListener {

    Logger logger = LoggerFactory.getLogger(SendSmsListener.class);

    @EventListener
    @Async
    public void sendSms(UserCreatedEvent userCreatedEvent){
        logger.info("sendSms is working as async");
        logger.info("Sending sms to user:" + userCreatedEvent.getUser());
    }

}
