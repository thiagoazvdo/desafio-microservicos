package com.ntconsult.msnotificationservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNotificationServiceApplication.class, args);
	}

}
