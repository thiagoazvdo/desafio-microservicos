package com.ntconsult.mshotelservice.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ntconsult.mshotelservice.exception.*;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.DTO.HotelRequestDTO;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HotelServiceTest {

    @InjectMocks
    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindHotels_Success() {
        // Arrange
        Hotel hotel = new Hotel();
        when(hotelRepository.findAll()).thenReturn(Collections.singletonList(hotel));

        // Act
        List<Hotel> hotels = hotelService.findHotels();

        // Assert
        assertEquals(1, hotels.size());
    }

    @Test
    void testFindHotelsByDestination_Success() {
        // Arrange
        String destination = "Paris";
        Hotel hotel = new Hotel();
        hotel.setDestination(destination);
        when(hotelRepository.findByDestinationContainingIgnoreCase(destination)).thenReturn(Collections.singletonList(hotel));

        // Act
        List<Hotel> hotels = hotelService.findHotelsByDestination(destination);

        // Assert
        assertEquals(1, hotels.size());
        assertEquals(destination, hotels.get(0).getDestination());
    }

    @Test
    void testFindHotelsByDestination_EmptyList() {
        // Arrange
        String destination = "Paris";
        when(hotelRepository.findByDestinationContainingIgnoreCase(destination)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(InvalidLDestinationException.class, () -> hotelService.findHotelsByDestination(destination));
    }

    @Test
    void testFindHotelsByDatesAndDestination_Success() {
        // Arrange
        LocalDate checkInDate = LocalDate.of(2024, 8, 1);
        LocalDate checkOutDate = LocalDate.of(2024, 8, 7);
        String destination = "Paris";
        Hotel hotel = new Hotel();
        hotel.setDestination(destination);
        when(hotelRepository.findByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqualAndDestination(checkInDate, checkOutDate, destination))
                .thenReturn(Collections.singletonList(hotel));

        // Act
        List<Hotel> hotels = hotelService.findHotelsByDatesAndDestination(checkInDate, checkOutDate, destination);

        // Assert
        assertEquals(1, hotels.size());
    }

    @Test
    void testFindHotelsByDatesAndDestination_EmptyList() {
        // Arrange
        LocalDate checkInDate = LocalDate.of(2024, 8, 1);
        LocalDate checkOutDate = LocalDate.of(2024, 8, 7);
        String destination = "Paris";
        when(hotelRepository.findByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqualAndDestination(checkInDate, checkOutDate, destination))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(UnavaliableHotelsException.class, () -> hotelService.findHotelsByDatesAndDestination(checkInDate, checkOutDate, destination));
    }

    @Test
    void testFindHotelsByNumberOfRoomsAndDestination_Success() {
        // Arrange
        int numberOfRooms = 3;
        String destination = "Paris";
        Hotel hotel = new Hotel();
        hotel.setDestination(destination);
        when(hotelRepository.findByNumberOfRoomsGreaterThanEqualAndDestination(numberOfRooms, destination))
                .thenReturn(Collections.singletonList(hotel));

        // Act
        List<Hotel> hotels = hotelService.findHotelsByNumberOfRoomsAndDestination(numberOfRooms, destination);

        // Assert
        assertEquals(1, hotels.size());
    }

    @Test
    void testFindHotelsByNumberOfRoomsAndDestination_EmptyList() {
        // Arrange
        int numberOfRooms = 3;
        String destination = "Paris";
        when(hotelRepository.findByNumberOfRoomsGreaterThanEqualAndDestination(numberOfRooms, destination))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(InvalidLNumberOfRoomsForDestinationException.class, () -> hotelService.findHotelsByNumberOfRoomsAndDestination(numberOfRooms, destination));
    }

    @Test
    void testFindHotelsByNumberOfGuestsAndDestination_Success() {
        // Arrange
        int numberOfGuests = 4;
        String destination = "Paris";
        Hotel hotel = new Hotel();
        hotel.setDestination(destination);
        when(hotelRepository.findByNumberOfGuestsGreaterThanEqualAndDestination(numberOfGuests, destination))
                .thenReturn(Collections.singletonList(hotel));

        // Act
        List<Hotel> hotels = hotelService.findHotelsByNumberOfGuestsAndDestination(numberOfGuests, destination);

        // Assert
        assertEquals(1, hotels.size());
    }

    @Test
    void testFindHotelsByNumberOfGuestsAndDestination_EmptyList() {
        // Arrange
        int numberOfGuests = 4;
        String destination = "Paris";
        when(hotelRepository.findByNumberOfGuestsGreaterThanEqualAndDestination(numberOfGuests, destination))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(InvalidLNumberOfGuestsForDestinationException.class, () -> hotelService.findHotelsByNumberOfGuestsAndDestination(numberOfGuests, destination));
    }

    @Test
    void testCreateHotel_Success() {
        // Arrange
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        hotelDTO.setCnpj("123456789");
        Hotel hotel = new Hotel();
        when(hotelRepository.existsByCnpj(hotelDTO.getCnpj())).thenReturn(false);
        when(hotelRepository.save(any(Hotel.class))).thenReturn(hotel);

        // Act
        Hotel createdHotel = hotelService.createHotel(hotelDTO);

        // Assert
        assertNotNull(createdHotel);
        verify(hotelRepository).save(any(Hotel.class));
    }

    @Test
    void testCreateHotel_AlreadyExists() {
        // Arrange
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        hotelDTO.setCnpj("123456789");
        when(hotelRepository.existsByCnpj(hotelDTO.getCnpj())).thenReturn(true);

        // Act & Assert
        assertThrows(AlreadyRegisteredException.class, () -> hotelService.createHotel(hotelDTO));
    }

    @Test
    void testUpdateHotel_Success() {
        // Arrange
        Long hotelId = 1L;
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        Hotel existingHotel = new Hotel();
        Hotel updatedHotel = new Hotel();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(existingHotel));
        when(hotelRepository.save(any(Hotel.class))).thenReturn(updatedHotel);

        // Act
        Hotel result = hotelService.updateHotel(hotelId, hotelDTO);

        // Assert
        assertEquals(updatedHotel, result);
    }

    @Test
    void testUpdateHotel_NotFound() {
        // Arrange
        Long hotelId = 1L;
        HotelRequestDTO hotelDTO = new HotelRequestDTO();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(HotelNotFoundException.class, () -> hotelService.updateHotel(hotelId, hotelDTO));
    }

    @Test
    void testSearchHotel_Success() {
        // Arrange
        Long hotelId = 1L;
        Hotel hotel = new Hotel();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));

        // Act
        Hotel result = hotelService.searchHotel(hotelId);

        // Assert
        assertEquals(hotel, result);
    }

    @Test
    void testSearchHotel_NotFound() {
        // Arrange
        Long hotelId = 1L;
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(HotelNotFoundException.class, () -> hotelService.searchHotel(hotelId));
    }

    @Test
    void testDeleteHotel_Success() {
        // Arrange
        Long hotelId = 1L;
        Hotel hotel = new Hotel();
        when(hotelRepository.findById(hotelId)).thenReturn(Optional.of(hotel));
    }
}
