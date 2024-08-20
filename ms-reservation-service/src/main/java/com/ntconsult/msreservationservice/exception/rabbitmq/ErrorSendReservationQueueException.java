package com.ntconsult.msreservationservice.exception.rabbitmq;

public class ErrorSendReservationQueueException extends RuntimeException {
    public ErrorSendReservationQueueException(String message) {
        super(message);
    }
}
