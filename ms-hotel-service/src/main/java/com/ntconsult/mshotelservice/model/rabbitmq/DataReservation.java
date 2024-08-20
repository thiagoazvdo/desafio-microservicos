package com.ntconsult.mshotelservice.model.rabbitmq;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DataReservation {

    private Long id;

    private LocalDate reservationDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Long hotelId;

    private Long customerId;


}
