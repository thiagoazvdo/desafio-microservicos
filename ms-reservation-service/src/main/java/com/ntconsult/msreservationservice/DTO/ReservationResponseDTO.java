package com.ntconsult.msreservationservice.DTO;

import lombok.Data;

@Data
public class ReservationResponseDTO {
    private Long id;
    private String reservationDate;
    private String checkInDate;
    private String checkoutDate;
    private HotelResponseDTO hotel;
}