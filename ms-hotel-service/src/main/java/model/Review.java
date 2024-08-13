package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String reviewerName;

    private String comment;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
