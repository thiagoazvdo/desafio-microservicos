package com.ntconsult.mshotelservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntconsult.mshotelservice.service.HotelService;
import com.ntconsult.mshotelservice.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ReviewService reviewService;

    @Mock
    private HotelService hotelService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new ReviewController())
                .setValidator(new LocalValidatorFactoryBean())
                .build();

    }

//    @Test
//    void testGetReviewsByHotel_Success() throws Exception {
//        // Arrange
//        Long hotelId = 1L;
//        Hotel hotel = new Hotel();
//        hotel.setId(hotelId);
//        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();
//        Review review = new Review();
//        review.setHotel(hotel);
//        List<Review> reviews = Collections.singletonList(review);
//
//        when(hotelService.searchHotel(hotelId)).thenReturn(hotel);
//        when(reviewService.findReviewsByHotel(hotelRequestDTO)).thenReturn(reviews);
//
//        // Act & Assert
//        mockMvc.perform(get("/by-hotel/{hotelId}", hotelId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].hotel.id").value(hotelId));
//    }

//    @Test
//    void testGetReviewsByHotel_HotelNotFound() throws Exception {
//        // Arrange
//        Long hotelId = 1L;
//
//        when(hotelService.searchHotel(hotelId)).thenThrow(new HotelNotFoundException());
//
//        // Act & Assert
//        mockMvc.perform(get("/by-hotel/{hotelId}", hotelId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }

//    @Test
//    void testCreateReview_Success() throws Exception {
//        // Arrange
//        ReviewRequestDTO reviewDTO = new ReviewRequestDTO();
//        reviewDTO.setReviewerName("John Doe");
//        reviewDTO.setComment("Great stay!");
//        reviewDTO.setRating(5.0);
//        reviewDTO.setHotelId(1L);
//
//        Review newReview = new Review();
//        newReview.setReviewerName("John Doe");
//        newReview.setComment("Great stay!");
//        newReview.setRating(5.0);
//        reviewDTO.setHotelId(1L);
//
//        when(reviewService.createReview(reviewDTO)).thenReturn(newReview);
//
//        // Act & Assert
//        mockMvc.perform(post("/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(reviewDTO)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.reviewerName").value("John Doe"))
//                .andExpect(jsonPath("$.comment").value("Great stay!"))
//                .andExpect(jsonPath("$.rating").value(5.0))
//                .andExpect(jsonPath("$.hotelId").value(1L));
//
//    }
}
