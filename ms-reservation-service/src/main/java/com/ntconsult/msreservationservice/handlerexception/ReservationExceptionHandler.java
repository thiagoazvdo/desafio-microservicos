package com.ntconsult.msreservationservice.handlerexception;

import com.ntconsult.msreservationservice.exception.ReservationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Trata o MicroServico para quando, de qualquer parte da codigo,
 * uma Exception do tipo HotelException for lancada.
 * param hotelException
 * return ResponseEntity
 */
@ControllerAdvice
public class ReservationExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<Problem> handleHotelException(ReservationException reservationException) {
        Problem problem = new Problem(reservationException);
        return ResponseEntity.status(reservationException.getHttpStatus()).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();

        List<String> problems = bindingResult.getFieldErrors().stream()
                .map(fieldError -> {
                    String fieldName = fieldError.getField();
                    String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    return String.format("Field '%s': %s",fieldName,message);
                })
                .collect(Collectors.toList());

        Problem problem = new Problem("Validation problems found", problems);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Problem> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        List<String> problems = List.of(String.format("Missing request parameter: %s", e.getParameterName()));

        Problem problem = new Problem("Missing request parameter", problems);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(CannotCreateTransactionException.class)
    public ResponseEntity<?> dataBaseConnectionFailedException(CannotCreateTransactionException e) {
        Problem problem = new Problem("Database connection failure. Please try again later.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(problem);
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<?> dataBaseConnectionFailedException(DataAccessResourceFailureException ex) {
        Problem problem = new Problem("Database connection failure. Please try again later.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(problem);

    }

}
