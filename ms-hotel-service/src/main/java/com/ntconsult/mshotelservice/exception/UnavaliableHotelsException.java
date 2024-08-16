package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class UnavaliableHotelsException extends HotelException {

    public UnavaliableHotelsException() {
        super("No hotels are available at the provided location for the specified dates!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
