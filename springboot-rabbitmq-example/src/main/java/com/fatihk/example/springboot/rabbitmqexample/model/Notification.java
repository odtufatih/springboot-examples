package com.fatihk.example.springboot.rabbitmqexample.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private Boolean seen;
    private String message;

}
