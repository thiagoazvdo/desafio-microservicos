package com.ntconsult.msreservationservice.service.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ntconsult.msreservationservice.model.rabbitmq.DataReservation;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationPublisher {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    @Qualifier("queueReservationPublisher")
    private final Queue queueReservation;

    public void publishReservation(DataReservation dataReservation) throws JsonProcessingException {
        var json = convertIntoJson(dataReservation);
        rabbitTemplate.convertAndSend(queueReservation.getName(), json);
    }

    public String convertIntoJson(DataReservation dataReservation) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(dataReservation);
        return json;
    }
}
