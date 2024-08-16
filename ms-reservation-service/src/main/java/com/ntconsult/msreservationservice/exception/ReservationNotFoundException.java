package com.ntconsult.msreservationservice.exception;

public class ReservationNotFoundException extends RuntimeException {
  public ReservationNotFoundException(String message) {
    super(message);
  }
}
