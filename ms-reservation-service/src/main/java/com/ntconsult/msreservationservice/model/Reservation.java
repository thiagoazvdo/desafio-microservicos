package com.ntconsult.msreservationservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDate reservationDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int numberOfRooms;

    @ManyToOne
    @JoinColumn(name= "hotel_id")
    private Hotel hotel;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name= "customer_id", nullable = false)
    private Customer customer;

}
