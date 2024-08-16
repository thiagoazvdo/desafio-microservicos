package com.ntconsult.mshotelservice.service;

import com.ntconsult.mshotelservice.exception.HotelNotFoundException;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.DTO.HotelRequestDTO;
import com.ntconsult.mshotelservice.model.Review;
import com.ntconsult.mshotelservice.DTO.ReviewRequestDTO;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import com.ntconsult.mshotelservice.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateReview() {
        Long hotelId = 1L;
        Hotel hotel = new Hotel(); // configure hotel
        ReviewRequestDTO reviewDTO = new ReviewRequestDTO();
        reviewDTO.setReviewerName("John Doe");
        reviewDTO.setComment("Great hotel!");
        reviewDTO.setRating(4.5);
        reviewDTO.setHotelId(hotelId);

        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(new Review());

        Review createdReview = reviewService.createReview(reviewDTO);

        Assert.assertNotNull(createdReview);
        verify(hotelRepository).findById(hotelId);
        verify(reviewRepository).save(Mockito.any(Review.class));
    }

    @Test
    void testFindReviewsByHotel_HotelFound() {
        // Arrange
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        hotelDTO.setCnpj("123456789");
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        Review review = new Review();
        review.setHotel(hotel);
        List<Review> reviews = Collections.singletonList(review);

        when(hotelRepository.findByCnpj(hotelDTO.getCnpj())).thenReturn(hotel);
        when(reviewRepository.findByHotel(hotel)).thenReturn(reviews);

        // Act
        List<Review> result = reviewService.findReviewsByHotel(hotelDTO);

        // Assert
        assertEquals(1, result.size());
        assertEquals(hotel, result.get(0).getHotel());
        verify(hotelRepository).findByCnpj(hotelDTO.getCnpj());
        verify(reviewRepository).findByHotel(hotel);
    }

    @Test
    void testFindReviewsByHotel_HotelNotFound() {
        // Arrange
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        hotelDTO.setCnpj("123456789");

        when(hotelRepository.findByCnpj(hotelDTO.getCnpj())).thenReturn(null);

        // Act & Assert
        assertThrows(HotelNotFoundException.class, () -> reviewService.findReviewsByHotel(hotelDTO));
        verify(hotelRepository).findByCnpj(hotelDTO.getCnpj());
        verifyNoInteractions(reviewRepository);
    }
}
