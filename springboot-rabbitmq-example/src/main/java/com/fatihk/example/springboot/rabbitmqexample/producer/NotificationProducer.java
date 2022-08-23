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

    @Value("${exchange.name}")
    private String exchangeName;

    @Value("${routing.name}")
    private String routingName;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Notification notification){
        System.out.println("Notification sent, id: : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }

}
