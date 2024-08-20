package com.ntconsult.mshotelservice.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.model.Reservation;
import com.ntconsult.mshotelservice.model.rabbitmq.DataReservation;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class ReservationSubscriber {

    private final HotelRepository hotelRepository;

    @RabbitListener(queues = "${mq.queue.recieve-reservation}")
    public void recieveReservation(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DataReservation dataReservation = mapper.readValue(payload, DataReservation.class);
            Hotel hotel = hotelRepository.findById(dataReservation.getId()).orElseThrow();
            Reservation reservation = new Reservation();
            reservation.setHotel(hotel);
            reservation.setReservationDate(dataReservation.getReservationDate());
            reservation.setCheckInDate(dataReservation.getCheckInDate());
            reservation.setCheckOutDate(dataReservation.getCheckOutDate());
            reservation.setCustomerId(dataReservation.getCustomerId());

            updateAvailableDates(hotel, dataReservation.getCheckInDate(), dataReservation.getCheckOutDate());
            hotelRepository.save(hotel);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void updateAvailableDates(Hotel hotel, LocalDate checkInDate, LocalDate checkOutDate) {
        hotel.setOccupiedCheckInDate(checkInDate);
        hotel.setOccupiedCheckOutDate(checkOutDate);
        hotelRepository.save(hotel);
        }

    }
