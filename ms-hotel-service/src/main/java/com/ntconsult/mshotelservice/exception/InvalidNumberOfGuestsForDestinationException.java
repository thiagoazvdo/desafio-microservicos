package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidNumberOfGuestsForDestinationException extends HotelException {
    public InvalidNumberOfGuestsForDestinationException() {
        super("No hotels are registered that can accommodate the number of guests at the provided destination! Please provide a different location or adjust the number of guests.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
