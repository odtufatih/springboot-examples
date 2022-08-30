package com.fatihk.examples.springboot.kafkaexample.service;

import com.fatihk.examples.springboot.kafkaexample.model.ServiceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @KafkaListener(topics = "${kafka.topic}",
                    groupId = "${kafka.group.id}")
    public void processServiceLog(@Payload ServiceLog serviceLog){

        log.info("ServiceLog received for service: {} ", serviceLog.getServiceName());
        log.info(serviceLog.toString());
    }


}
