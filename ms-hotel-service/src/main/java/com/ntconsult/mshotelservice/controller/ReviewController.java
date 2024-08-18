package com.ntconsult.mshotelservice.controller;

import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.DTO.HotelRequestDTO;
import com.ntconsult.mshotelservice.model.Review;
import com.ntconsult.mshotelservice.DTO.ReviewRequestDTO;
import com.ntconsult.mshotelservice.service.HotelService;
import com.ntconsult.mshotelservice.service.ReviewService;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/by-hotel/{hotelId}")
    public ResponseEntity<List<Review>> getReviewsByHotel(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.searchHotel(hotelId);
        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();
        BeanUtils.copyProperties(hotel, hotelRequestDTO);
        List<Review> reviews = reviewService.findReviewsByHotel(hotelRequestDTO);
        return ResponseEntity.ok(reviews);
    }

    //implementar pelo nome do hotel
    //mais bem avaliados

    @PostMapping
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewRequestDTO reviewDTO) {
        Review newReview = reviewService.createReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
    }

}
