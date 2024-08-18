package com.ntconsult.mshotelservice.controller;

import com.ntconsult.mshotelservice.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import com.ntconsult.mshotelservice.service.HotelService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/search/destination")
    public ResponseEntity<List<Hotel>> searchByDestination(@RequestParam String destination) {
        List<Hotel> hotels = hotelService.findHotelsByDestination(destination);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/search/checkin-checkout-and-destination")
    public ResponseEntity<List<Hotel>> searchByDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate,
            @RequestParam String destination) {
        List<Hotel> hotels = hotelService.findHotelsByDatesAndDestination(checkInDate, checkOutDate, destination);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/search/numberofrooms-and-destination")
    public ResponseEntity<List<Hotel>> searchByNumberOfRoomsAndDestination(@RequestParam int numberOfRooms, @RequestParam String destination) {
        List<Hotel> hotels = hotelService.findHotelsByNumberOfRoomsAndDestination(numberOfRooms, destination);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/search/numberofguests-and-destination")
    public ResponseEntity<List<Hotel>> searchByNumberOfGuestsAndDestination(@RequestParam int numberOfGuests, String destination) {
        List<Hotel> hotels = hotelService.findHotelsByNumberOfGuestsAndDestination(numberOfGuests, destination);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(){
        List<Hotel> listaHoteis = hotelService.findHotels();
        return ResponseEntity.ok(listaHoteis);
    }

}
