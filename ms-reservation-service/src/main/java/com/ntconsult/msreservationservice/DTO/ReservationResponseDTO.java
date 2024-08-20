package com.ntconsult.msreservationservice.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {
    private Long id;
    private LocalDate reservationDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private HotelResponseDTO hotel;
}