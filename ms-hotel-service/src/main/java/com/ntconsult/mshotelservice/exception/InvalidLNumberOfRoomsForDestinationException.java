package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidLNumberOfRoomsForDestinationException extends HotelException {
    public InvalidLNumberOfRoomsForDestinationException() {
        super("Nao existem hoteis com a quantidade de quartos no destino informado! Por favor informe uma outra localizacao ou altere o numero de quartos.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
