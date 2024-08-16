package com.ntconsult.msreservationservice.exception;

import org.springframework.http.HttpStatus;

public class ReservationNotFoundException extends ReservationException {

  public ReservationNotFoundException() {
    super("We could not find a reservation with the provided information!");
    this.httpStatus = HttpStatus.NOT_FOUND;
  }
}
