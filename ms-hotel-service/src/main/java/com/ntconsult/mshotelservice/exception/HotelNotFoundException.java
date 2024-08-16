package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class HotelNotFoundException extends HotelException {

    public HotelNotFoundException() {
        super("We could not find a hotel with the provided information!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
