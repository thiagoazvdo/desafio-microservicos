package com.ntconsult.mshotelservice.service;

import com.ntconsult.mshotelservice.model.Review;
import com.ntconsult.mshotelservice.model.ReviewRequestDTO;
import com.ntconsult.mshotelservice.repository.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> reviewsByHotelId(Long hotelId){
        List<Review> reviews = reviewRepository.findAllById(hotelId);
        return reviews;
    }

    public Review createReview(ReviewRequestDTO reviewDTO){
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review);
        return reviewRepository.save(review);
    }
}
