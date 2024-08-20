package com.ntconsult.msreservationservice.exception.rabbitmq;

public class ErrorSendReservationQueue extends RuntimeException {
    public ErrorSendReservationQueue(String message) {
        super(message);
    }
}
