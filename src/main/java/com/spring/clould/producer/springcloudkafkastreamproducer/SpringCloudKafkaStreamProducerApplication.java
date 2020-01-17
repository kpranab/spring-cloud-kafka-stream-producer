package com.spring.clould.producer.springcloudkafkastreamproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.spring.clould.producer"})
public class SpringCloudKafkaStreamProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKafkaStreamProducerApplication.class, args);
	}

}
