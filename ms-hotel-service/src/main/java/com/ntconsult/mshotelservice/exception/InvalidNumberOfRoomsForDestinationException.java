package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidNumberOfRoomsForDestinationException extends HotelException {
    public InvalidNumberOfRoomsForDestinationException() {
        super("No hotels are registered with the specified number of rooms at the provided destination! Please provide a different location or adjust the number of rooms.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
