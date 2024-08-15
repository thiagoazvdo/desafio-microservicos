package com.ntconsult.mshotelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@ComponentScan({"com.ntconsult.mshotelservice.controller","com.ntconsult.mshotelservice.model","com.ntconsult.mshotelservice.repository","com.ntconsult.mshotelservice.service"})
@SpringBootApplication
public class MsHotelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHotelServiceApplication.class, args);
    }

}
