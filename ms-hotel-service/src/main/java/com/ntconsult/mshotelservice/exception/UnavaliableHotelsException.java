package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class UnavaliableHotelsException extends HotelException {

    public UnavaliableHotelsException() {
        super("Nao encontramos hoteis disponiveis nessa localizacao com as datas informadas!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
