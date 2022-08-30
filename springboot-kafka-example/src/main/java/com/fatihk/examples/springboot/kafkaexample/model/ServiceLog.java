package com.fatihk.examples.springboot.kafkaexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceLog {

    private String logId = UUID.randomUUID().toString();

    private Map<String, Object> iMap;

    private String serviceName;

    private int duration;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

}
