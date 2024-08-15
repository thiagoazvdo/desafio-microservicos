package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidLDestinationException extends HotelException {

    public InvalidLDestinationException() {
        super("Nao existem hoteis cadastrados com o destino informado! Por favor informe uma outra localizacao.");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
