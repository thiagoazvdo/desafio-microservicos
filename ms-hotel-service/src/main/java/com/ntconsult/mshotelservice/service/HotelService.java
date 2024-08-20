package com.ntconsult.mshotelservice.service;

import com.ntconsult.mshotelservice.DTO.HotelRequestDTO;
import com.ntconsult.mshotelservice.exception.*;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.repository.HotelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findHotels(){
        return hotelRepository.findAll();
    }

    public List<Hotel> findHotelsByName(String name) { return hotelRepository.findByNameLikeIgnoreCase(name); }

    public List<Hotel> findHotelsByDestination(String destination) {
        List<Hotel> hotels = hotelRepository.findByDestinationContainingIgnoreCase(destination);
        if (hotels.isEmpty()) throw new InvalidDestinationException();
        return hotels;
    }

    public List<Hotel> findHotelsByDatesAndDestination(LocalDate checkInDate, LocalDate checkOutDate, String destination) {
        List<Hotel> hotels = hotelRepository.findByOccupiedCheckInDateLessThanEqualAndOccupiedCheckOutDateGreaterThanEqualAndDestination(checkInDate, checkOutDate, destination);
        if (hotels.isEmpty()) throw new UnavaliableHotelsException();
        return hotels;
    }

    public List<Hotel> findHotelsByNumberOfRoomsAndDestination(int numberOfRooms, String destination) {
        List<Hotel> hotels = hotelRepository.findByNumberOfRoomsGreaterThanEqualAndDestination(numberOfRooms, destination);
        if (hotels.isEmpty()) throw new InvalidNumberOfRoomsForDestinationException();
        return hotels;
    }

    public List<Hotel> findHotelsByNumberOfGuestsAndDestination(int numberOfGuests, String destination) {
        List<Hotel> hotels = hotelRepository.findByNumberOfGuestsGreaterThanEqualAndDestination(numberOfGuests, destination);
        if(hotels.isEmpty()) throw new InvalidNumberOfGuestsForDestinationException();
        return hotels;
    }

    public Hotel createHotel(HotelRequestDTO hotelDTO){
        hotelAlreadyExists(hotelDTO.getCnpj());
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDTO,hotel);
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long hotelId, HotelRequestDTO hotelDTO){
        Hotel hotel = searchHotel(hotelId);
        BeanUtils.copyProperties(hotelDTO,hotel);
        return hotelRepository.save(hotel);
    }

    public Hotel searchHotel(Long hotelId) {
            return hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
    }

    public void hotelAlreadyExists(String cnpj) {
        if(hotelRepository.existsByCnpj(cnpj)) throw new AlreadyRegisteredException();
    }

    public void deleteHotel(Long hotelId) {
        hotelRepository.delete(searchHotel(hotelId));
    }

}

