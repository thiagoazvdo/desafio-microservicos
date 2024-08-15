package com.ntconsult.mshotelservice.controller;

import com.ntconsult.mshotelservice.model.Review;
import com.ntconsult.mshotelservice.model.ReviewRequestDTO;
import com.ntconsult.mshotelservice.service.ReviewService;
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

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Review>> reviewsByHotelName(@PathVariable Long hotelId){
        List<Review> listOfReviews = reviewService.reviewsByHotelId(hotelId);
        return ResponseEntity.ok(listOfReviews);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequestDTO reviewDTO){
        Review newReview = reviewService.createReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
    }

}
