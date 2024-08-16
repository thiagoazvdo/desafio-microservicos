package com.ntconsult.mshotelservice.service;

import com.ntconsult.mshotelservice.exception.HotelNotFoundException;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.model.HotelRequestDTO;
import com.ntconsult.mshotelservice.model.Review;
import com.ntconsult.mshotelservice.model.ReviewRequestDTO;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import com.ntconsult.mshotelservice.repository.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Review> findReviewsByHotel(HotelRequestDTO hotelDTO) {
        Hotel hotel = hotelRepository.findByCnpj(hotelDTO.getCnpj());
        if (hotel == null) throw new HotelNotFoundException();

        return reviewRepository.findByHotel(hotel);
    }

    public Review createReview(ReviewRequestDTO reviewDTO) {
        Hotel hotel = hotelRepository.findById(reviewDTO.getHotelId())
                .orElseThrow(() -> new HotelNotFoundException());

        Review review = new Review();
        review.setReviewerName(reviewDTO.getReviewerName());
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setHotel(hotel);

        return reviewRepository.save(review);
    }
}
