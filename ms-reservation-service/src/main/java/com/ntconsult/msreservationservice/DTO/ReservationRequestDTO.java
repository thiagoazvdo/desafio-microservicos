package com.ntconsult.msreservationservice.DTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationRequestDTO {

    @NotNull(message = "Hotel ID is required to complete your reservation.")
    private Long hotelId;

    @Future
    private LocalDate checkInDate;

    @Future
    private LocalDate checkOutDate;

    @CreationTimestamp
    private String reservationDate;

    @NotBlank(message = "Customer name is required to complete your reservation")
    private String customerName;

    @Email
    @NotBlank(message = "Customer email is required to complete your reservation")
    private String customerContact;

    @NotNull
    private PaymentRequestDTO payment;
}
