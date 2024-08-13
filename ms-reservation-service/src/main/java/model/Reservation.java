package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reservationDate;

    private String checkInDate;

    private String checkoutDate;

    @ManyToOne
    @JoinColumn(name= "hotel_id")
    private Hotel hotel;

}
