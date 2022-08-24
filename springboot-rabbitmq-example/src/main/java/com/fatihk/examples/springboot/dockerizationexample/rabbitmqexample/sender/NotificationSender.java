package com.fatihk.examples.springboot.dockerizationexample.rabbitmqexample.sender;

import com.fatihk.examples.springboot.dockerizationexample.rabbitmqexample.model.Notification;
import com.fatihk.examples.springboot.dockerizationexample.rabbitmqexample.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
@DependsOn({"directExchange","binding"})
public class NotificationSender {

    @Autowired
    private NotificationProducer producer;

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification = new Notification();
                String id = UUID.randomUUID().toString();
                notification.setNotificationId(id);
                notification.setCreatedAt(new Date());
                notification.setMessage("Mesaj (id)=" + id);
                notification.setSeen(false);
                producer.sendToQueue(notification);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }
}

