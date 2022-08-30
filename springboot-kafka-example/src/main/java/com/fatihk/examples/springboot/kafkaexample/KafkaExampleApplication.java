package com.fatihk.examples.springboot.kafkaexample;

import com.fatihk.examples.springboot.kafkaexample.model.ServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class KafkaExampleApplication implements CommandLineRunner {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic}")
    private String topicName;

    public static void main(String[] args) {
        SpringApplication.run(KafkaExampleApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        for(int i=0; i<100; i++) {
            ServiceLog serviceLog = ServiceLog.builder()
                    .logId(UUID.randomUUID().toString())
                    .serviceName("SERVICE" + (i+1))
                    .beginDate(LocalDateTime.now())
                    .endDate(LocalDateTime.now().plusSeconds(i%4))
                    .duration(i%4)
                    .iMap(Map.of("name", "John" + i, "surname", "Doe"+i))
                    .build();

            kafkaTemplate.send(topicName, serviceLog);
        }
    }
}
