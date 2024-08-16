package com.ntconsult.mshotelservice.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class HotelRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String cnpj;

    @NotNull
    private BigDecimal pricePerNight;

    @NotBlank
    private String destination;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    @NotNull
    private int numberOfRooms;

    @NotNull
    private int numberOfGuests;

}
