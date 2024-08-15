package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class HotelNotFoundException extends HotelException {

    public HotelNotFoundException() {
        super("Nao encontramos hotel com o campo informado!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
