package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidLNumberOfGuestsForDestinationException extends HotelException {
    public InvalidLNumberOfGuestsForDestinationException() {
        super("Nao existem hoteis cadastrados que suportem essa quantidade de hospedes no destino informado! Por favor informe uma outra localizacao ou altere o numero de hospedes.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
