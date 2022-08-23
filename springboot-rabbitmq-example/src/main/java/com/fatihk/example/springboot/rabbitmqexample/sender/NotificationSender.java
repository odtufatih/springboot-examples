package com.fatihk.example.springboot.rabbitmqexample.sender;

import com.fatihk.example.springboot.rabbitmqexample.model.Notification;
import com.fatihk.example.springboot.rabbitmqexample.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@DependsOn({"directExchange","binding"})
public class NotificationSender {

    private final NotificationProducer notificationProducer;

    @Autowired
    public NotificationSender(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @PostConstruct
    public void init(){
        for(int i=0; i<100; i++){
            Notification notification = new Notification();
            notification.setNotificationId(i+1);
            notification.setCreatedAt(new Date());
            notification.setIsSeen(false);
            notification.setMessage("Notification message " + (i+1) );
            notificationProducer.sendMessage(notification);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
