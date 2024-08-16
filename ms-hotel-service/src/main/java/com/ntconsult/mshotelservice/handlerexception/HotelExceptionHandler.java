package com.ntconsult.mshotelservice.handlerexception;

import com.ntconsult.mshotelservice.exception.HotelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessResourceFailureException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
public class HotelExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<Problem> handleHotelException(HotelException hotelException) {
        Problem problem = new Problem(hotelException);
        return ResponseEntity.status(hotelException.getHttpStatus()).body(problem);
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
