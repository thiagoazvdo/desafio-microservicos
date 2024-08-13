package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentData;

    private Double amount;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name= "reservation_id")
    private Reservation reservation;

}
