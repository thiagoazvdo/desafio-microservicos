package com.ntconsult.mshotelservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;

    private BigDecimal pricePerNight;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Room> rooms;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Review> reviews;

    private String destination;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int numberOfRooms;

    private int numberOfGuests;

}
