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

    @NotBlank(message = "{notBlank.hotelRequestDTO.name}")
    private String name;

    @NotBlank(message = "{notBlank.hotelRequestDTO.cnpj}")
    private String cnpj;

    @NotNull(message = "{notNull.hotelRequestDTO.pricePerNight}")
    private BigDecimal pricePerNight;

    @NotBlank(message = "{notBlank.hotelRequestDTO.destination}")
    private String destination;

    @NotNull(message = "{notNull.hotelRequestDTO.checkInDate}")
    private LocalDate checkInDate;

    @NotNull(message = "{notNull.hotelRequestDTO.checkOutDate}")
    private LocalDate checkOutDate;

    @NotNull(message = "{notNull.hotelRequestDTO.numberOfRooms}")
    private int numberOfRooms;

    @NotNull(message = "{notNull.hotelRequestDTO.numberOfGuests}")
    private int numberOfGuests;

}
