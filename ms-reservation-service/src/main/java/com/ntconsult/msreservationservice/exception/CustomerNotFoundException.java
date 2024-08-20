package com.ntconsult.msreservationservice.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends ReservationException {

  public CustomerNotFoundException() {
    super("We could not find a customer with the provided information!");
    this.httpStatus = HttpStatus.NOT_FOUND;
  }
}
