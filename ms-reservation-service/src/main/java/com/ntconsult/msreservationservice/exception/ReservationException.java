package com.ntconsult.msreservationservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReservationException extends RuntimeException {

    protected HttpStatus httpStatus;

    public ReservationException(String message) {super(message);}
}
