package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class AlreadyRegisteredException extends HotelException {

    public AlreadyRegisteredException() {
        super("Ja existe um hotel cadastrado com o Cnpj informado! Por favor verifique o cnpj informado");
        this.httpStatus = HttpStatus.CONFLICT;
    }
}
