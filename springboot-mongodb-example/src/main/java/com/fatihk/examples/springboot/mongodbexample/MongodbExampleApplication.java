package com.fatihk.examples.springboot.mongodbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.TimeZone;

@SpringBootApplication
@EnableMongoAuditing //for CreatedDate annotation to work
public class MongodbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbExampleApplication.class, args);
	}

}
