package com.ntconsult.mshotelservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableRabbit
public class MsHotelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHotelServiceApplication.class, args);
    }

}
