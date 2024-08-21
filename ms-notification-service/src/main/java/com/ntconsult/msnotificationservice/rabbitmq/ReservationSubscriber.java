package com.ntconsult.msnotificationservice.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntconsult.msnotificationservice.model.Hotel;
import com.ntconsult.msnotificationservice.model.Reservation;
import com.ntconsult.msnotificationservice.model.rabbitmq.DataReservation;
import com.ntconsult.msnotificationservice.repository.HotelRepository;
import com.ntconsult.msnotificationservice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ReservationSubscriber {

    private final HotelRepository hotelRepository;

    private final ReservationRepository reservationRepository;

    @RabbitListener(queues = "${mq.queue.receive-reservation}")
    public void receiveReservation(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DataReservation dataReservation = mapper.readValue(payload, DataReservation.class);
            Hotel hotel = hotelRepository.findById(dataReservation.getId()).orElseThrow();
            Reservation reservation = new Reservation();
            reservation.setHotelId(hotel.getHotelId());
            reservation.setReservationDate(dataReservation.getReservationDate());
            reservation.setCheckInDate(dataReservation.getCheckInDate());
            reservation.setCheckOutDate(dataReservation.getCheckOutDate());
            reservation.setCustomerId(dataReservation.getCustomerId());

            reservationRepository.save(reservation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
