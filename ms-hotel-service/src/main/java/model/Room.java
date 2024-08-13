package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
