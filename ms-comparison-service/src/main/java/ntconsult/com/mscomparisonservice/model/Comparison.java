package ntconsult.com.mscomparisonservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Comparisons")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String criteria;

    private String result;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
