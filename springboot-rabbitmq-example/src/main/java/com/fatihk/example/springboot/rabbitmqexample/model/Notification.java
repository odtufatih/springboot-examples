package com.fatihk.example.springboot.rabbitmqexample.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private long notificationId;
    private Date createdAt;
    private Boolean isSeen;
    private String message;

}
