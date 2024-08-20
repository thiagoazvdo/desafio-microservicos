package com.ntconsult.msreservationservice.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ReservationRequestDTO {

    @NotNull(message = "{notnull.reservationrequestdto.hotelid}")
    private Long hotelId;

    @Future(message = "{future.reservationrequestdto.checkindate}")
    @NotNull(message = "{notnull.reservationrequestdto.checkindate}")
    private LocalDate checkInDate;

    @Future(message = "{future.reservationrequestdto.checkoutdate}")
    @NotNull(message = "{notnull.reservationrequestdto.checkoutdate}")
    private LocalDate checkOutDate;

    @Future(message = "{future.reservationrequestdto.reservationdate}")
    @NotNull(message = "{notnull.reservationrequestdto.reservationdate}")
    private LocalDate reservationDate;

    @NotNull(message = "{notnull.reservationrequestdto.customer}")
    private CustomerRequestDTO customer;

    @Min(value = 1, message = "{min.reservationrequestdto.numberofrooms}")
    @NotNull(message = "{notnull.reservationrequestdto.numberofrooms}")
    private int numberOfRooms;

    @NotNull(message = "{notnull.reservationrequestdto.payment}")
    private PaymentRequestDTO payment;
}
