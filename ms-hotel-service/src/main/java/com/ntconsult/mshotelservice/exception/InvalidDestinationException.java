package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidDestinationException extends HotelException {

    public InvalidDestinationException() {
        super("No hotels are registered with the provided destination! Please provide a different location.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
