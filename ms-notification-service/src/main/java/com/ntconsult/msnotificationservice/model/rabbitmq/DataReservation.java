package com.ntconsult.msnotificationservice.model.rabbitmq;

import com.ntconsult.msnotificationservice.model.Payment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DataReservation {

    private Long id;

    private Long hotelId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private LocalDate reservationDate;

    private Long customerId;

    private int numberOfRooms;

    private Payment payment;
}
