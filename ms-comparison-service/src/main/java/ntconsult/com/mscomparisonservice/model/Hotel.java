package ntconsult.com.mscomparisonservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Hotel {

    private Long id;

    private String name;

    private String location;

    private Double price;

    private Double rating;

    private List<String> reviews;
}
