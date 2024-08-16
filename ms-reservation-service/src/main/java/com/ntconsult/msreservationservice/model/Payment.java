package com.ntconsult.msreservationservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate paymentData;

    private Double amount;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name= "reservation_id")
    private Reservation reservation;

}
