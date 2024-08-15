package com.ntconsult.mshotelservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HotelException extends RuntimeException {

    protected HttpStatus httpStatus;

    public HotelException(String message) {super(message);}
}
