package com.ntconsult.mshotelservice.exception;

import org.springframework.http.HttpStatus;

public class ReviewsWerentFoundedException extends HotelException {

    public ReviewsWerentFoundedException() {
        super("I`m Sorry! There is no review for this hotel at the moment!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
}
