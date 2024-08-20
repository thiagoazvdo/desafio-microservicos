package com.ntconsult.msreservationservice.model.rabbitmq;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class DataReservation {

    private Long id;

    private LocalDate reservationDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Long hotelId;

    private Long customerId;


}
