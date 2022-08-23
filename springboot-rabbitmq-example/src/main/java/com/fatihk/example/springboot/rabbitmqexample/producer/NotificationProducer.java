package com.fatihk.example.springboot.rabbitmqexample.producer;

import com.fatihk.example.springboot.rabbitmqexample.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NotificationProducer {

    @Value("${routing.name}")
    private String routingName;

    @Value("${exchange.name}")
    private String exchangeName;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }

}
