package com.ntconsult.mshotelservice.controller;

import com.ntconsult.mshotelservice.DTO.HotelRequestDTO;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import com.ntconsult.mshotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/management-hotels")
public class ManagmentHotelController {

        @Autowired
        private HotelService hotelService;

        @Autowired
        private HotelRepository hotelRepository;

        @PostMapping
        public ResponseEntity<Hotel> addHotel(@Valid @RequestBody HotelRequestDTO hotelDTO){
            Hotel hotel = hotelService.createHotel(hotelDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
        }

        @PutMapping("/{hotelId}")
        public ResponseEntity<Hotel> updateHotel(@PathVariable Long hotelId, @Valid @RequestBody HotelRequestDTO hotelDTO){
            Hotel hotel = hotelService.updateHotel(hotelId,hotelDTO);
            return ResponseEntity.ok(hotel);
        }

        @DeleteMapping("/{hotelId}")
        public ResponseEntity<Hotel> deleteHotel(@PathVariable Long hotelId){
            hotelService.deleteHotel(hotelId);
            return ResponseEntity.noContent().build();
        }


}
