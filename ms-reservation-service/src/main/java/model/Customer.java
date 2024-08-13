package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
}
