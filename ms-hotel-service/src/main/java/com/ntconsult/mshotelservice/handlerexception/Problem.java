package com.ntconsult.mshotelservice.handlerexception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ntconsult.mshotelservice.exception.HotelException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Getter
public class Problem {

    private String message;

    private List<String> problems;

    public Problem(String message) { this.message = message; }

    public Problem(HotelException hotelException) { this(hotelException.getMessage()); }
}
