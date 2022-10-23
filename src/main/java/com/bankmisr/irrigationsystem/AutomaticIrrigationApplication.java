package com.bankmisr.irrigationsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRetry
@EnableScheduling
public class AutomaticIrrigationApplication {
	private static final Logger log = LoggerFactory.getLogger(AutomaticIrrigationApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AutomaticIrrigationApplication.class, args);
	}

}
