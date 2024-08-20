package com.ntconsult.mshotelservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private Long customerId;

    private LocalDate reservationDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Hotel hotel;

    private Customer customer;

}