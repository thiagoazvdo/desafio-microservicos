package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class AlreadyRegisteredException extends HotelException {

    public AlreadyRegisteredException() {
        super("A hotel with the provided CNPJ is already registered! Please check the provided CNPJ.");
        this.httpStatus = HttpStatus.CONFLICT;
    }
}
