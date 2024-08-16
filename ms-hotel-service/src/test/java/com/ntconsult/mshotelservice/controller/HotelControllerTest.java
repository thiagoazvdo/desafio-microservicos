package com.ntconsult.mshotelservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntconsult.mshotelservice.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@WebMvcTest(HotelController.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HotelService hotelService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new HotelController())
                .setValidator(new LocalValidatorFactoryBean())
                .build();
    }

//    @Test
//    void testSearchByDestination_Success() throws Exception {
//        // Arrange
//        String destination = "Paris";
//        Hotel hotel = new Hotel();
//        hotel.setDestination(destination);
//        List<Hotel> hotels = Collections.singletonList(hotel);
//
//        when(hotelService.findHotelsByDestination(destination)).thenReturn(hotels);
//
//        // Act & Assert
//        mockMvc.perform(get("/hotels/search/destination")
//                        .param("destination", destination)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].destination").value(destination));
//    }

//    @Test
//    void testSearchByDates_Success() throws Exception {
//        // Arrange
//        LocalDate checkInDate = LocalDate.of(2024, 8, 1);
//        LocalDate checkOutDate = LocalDate.of(2024, 8, 7);
//        String destination = "Paris";
//        Hotel hotel = new Hotel();
//        hotel.setDestination(destination);
//        List<Hotel> hotels = Collections.singletonList(hotel);
//
//        when(hotelService.findHotelsByDatesAndDestination(checkInDate, checkOutDate, destination)).thenReturn(hotels);
//
//        // Act & Assert
//        mockMvc.perform(get("/hotels/search/checkin-checkout-and-destination")
//                        .param("checkInDate", checkInDate.toString())
//                        .param("checkOutDate", checkOutDate.toString())
//                        .param("destination", destination)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].destination").value(destination));
//    }

//    @Test
//    void testSearchByNumberOfRoomsAndDestination_Success() throws Exception {
//        // Arrange
//        int numberOfRooms = 3;
//        String destination = "Paris";
//        Hotel hotel = new Hotel();
//        hotel.setDestination(destination);
//        List<Hotel> hotels = Collections.singletonList(hotel);
//
//        when(hotelService.findHotelsByNumberOfRoomsAndDestination(numberOfRooms, destination)).thenReturn(hotels);
//
//        // Act & Assert
//        mockMvc.perform(get("/hotels/search/rooms-and-destination")
//                        .param("numberOfRooms", String.valueOf(numberOfRooms))
//                        .param("destination", destination)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].destination").value(destination));
//    }

//    @Test
//    void testSearchByNumberOfGuestsAndDestination_Success() throws Exception {
//        // Arrange
//        int numberOfGuests = 4;
//        String destination = "Paris";
//        Hotel hotel = new Hotel();
//        hotel.setDestination(destination);
//        List<Hotel> hotels = Collections.singletonList(hotel);
//
//        when(hotelService.findHotelsByNumberOfGuestsAndDestination(numberOfGuests, destination)).thenReturn(hotels);
//
//        // Act & Assert
//        mockMvc.perform(get("/hotels/search/numberofguests-and-destination")
//                        .param("numberOfGuests", String.valueOf(numberOfGuests))
//                        .param("destination", destination)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].destination").value(destination));
//    }

//    @Test
//    void testSearchHotels_Success() throws Exception {
//        // Arrange
//        Hotel hotel = new Hotel();
//        List<Hotel> hotels = Collections.singletonList(hotel);
//
//        when(hotelService.findHotels()).thenReturn(hotels);
//
//        // Act & Assert
//        mockMvc.perform(get("/hotels/search")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

//    @Test
//    void testAddHotel_Success() throws Exception {
//        // Arrange
//        HotelRequestDTO hotelDTO = new HotelRequestDTO();
//        hotelDTO.setName("Hotel Paris");
//        Hotel hotel = new Hotel();
//        hotel.setName("Hotel Paris");
//
//        when(hotelService.createHotel(hotelDTO)).thenReturn(hotel);
//
//        // Act & Assert
//        mockMvc.perform(post("/hotels")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(hotelDTO)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("Hotel Paris"));
//    }

//    @Test
//    void testUpdateHotel_Success() throws Exception {
//        // Arrange
//        Long hotelId = 1L;
//        HotelRequestDTO hotelDTO = new HotelRequestDTO();
//        hotelDTO.setName("Updated Hotel Paris");
//        Hotel updatedHotel = new Hotel();
//        updatedHotel.setName("Updated Hotel Paris");
//
//        when(hotelService.updateHotel(hotelId, hotelDTO)).thenReturn(updatedHotel);
//
//        // Act & Assert
//        mockMvc.perform(put("/hotels/{hotelId}", hotelId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(hotelDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Updated Hotel Paris"));
//    }

//    @Test
//    void testDeleteHotel_Success() throws Exception {
//        // Arrange
//        Long hotelId = 1L;
//
//        // Act & Assert
//        mockMvc.perform(delete("/hotels/{hotelId}", hotelId))
//                .andExpect(status().isNoContent());
//    }
}
