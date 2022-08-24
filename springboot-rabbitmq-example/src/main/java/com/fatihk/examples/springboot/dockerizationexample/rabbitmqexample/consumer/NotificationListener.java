package com.fatihk.examples.springboot.dockerizationexample.rabbitmqexample.consumer;

import com.fatihk.examples.springboot.dockerizationexample.rabbitmqexample.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "${queue.name}")
    public void handleMessage(Notification notification){
        System.out.println("Notification received: " + notification);
    }

}
