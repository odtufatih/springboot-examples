package com.fatihk.example.springboot.rabbitmqexample.consumer;

import com.fatihk.example.springboot.rabbitmqexample.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    //there is a problem, rabbit listener does not work somehow.
    @RabbitListener(queues = "test-queue")
    public void handleMessage(Notification notification){
        System.out.println("Notification received: " + notification);
    }

}
