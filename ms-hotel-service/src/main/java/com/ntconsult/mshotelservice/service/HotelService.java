package com.ntconsult.mshotelservice.service;

import com.ntconsult.mshotelservice.exception.*;
import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.model.HotelRequestDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntconsult.mshotelservice.repository.HotelRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findHotels(){
        return hotelRepository.findAll();
    }

    public List<Hotel> findHotelsByDestination(String destination) {
        List<Hotel> hotels = hotelRepository.findByDestination(destination);
        if (hotels.isEmpty()) throw new InvalidLDestinationException();
        return hotels;
    }

    public List<Hotel> findHotelsByDatesAndDestination(LocalDate checkInDate, LocalDate checkOutDate, String destination) {
        List<Hotel> hotels = hotelRepository.findByCheckInDateAndCheckOutDateAndDestination(checkInDate, checkOutDate, destination);
        if (hotels.isEmpty()) throw new UnavaliableHotelsException();
        return hotels;
    }

    public List<Hotel> findHotelsByNumberOfRoomsAndDestination(int numberOfRooms, String destination) {
        List<Hotel> hotels = hotelRepository.findByNumberOfRoomsAndDestination(numberOfRooms, destination);
        if (hotels.isEmpty()) throw new InvalidLNumberOfRoomsForDestinationException();
        return hotels;
    }

    public List<Hotel> findHotelsByNumberOfGuestsAndDestination(int numberOfGuests, String destination) {
        List<Hotel> hotels = hotelRepository.findByNumberOfGuestsAndDestination(numberOfGuests, destination);
        if(hotels.isEmpty()) throw new InvalidLNumberOfGuestsForDestinationException();
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
