package com.ntconsult.msreservationservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.recieve-reservation}")
    private String recieveReservation;

    @Bean
    public Queue queueReservationPublisher(){
        return new Queue(recieveReservation, true);
    }
}
