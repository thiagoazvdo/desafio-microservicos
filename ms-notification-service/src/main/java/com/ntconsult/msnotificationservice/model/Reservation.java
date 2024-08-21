package com.ntconsult.msnotificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    private Long id;

    private Long hotelId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private LocalDate reservationDate;

    private Long customerId;

    private int numberOfRooms;

//    private Payment payment;

}