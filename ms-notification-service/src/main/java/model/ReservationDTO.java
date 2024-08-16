package model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO {

    @NotBlank
    private String userContact;

    @NotBlank
    private String hotelName;

    @Future
    private LocalDate checkInDate;

    @Future
    private LocalDate checkoutDate;
}
