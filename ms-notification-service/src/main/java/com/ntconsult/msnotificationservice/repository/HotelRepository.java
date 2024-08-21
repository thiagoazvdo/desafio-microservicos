package com.ntconsult.msnotificationservice.repository;

import com.ntconsult.msnotificationservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

//    List<Hotel> findByDestinationContainingIgnoreCase(String destination);
//
//    List<Hotel> findByNameLikeIgnoreCase(String name);
//
//    List<Hotel> findByOccupiedCheckInDateLessThanEqualAndOccupiedCheckOutDateGreaterThanEqualAndDestination(
//            LocalDate occupiedCheckInDate, LocalDate occupiedCheckOutDate, String destination);
//
//    List<Hotel> findByNumberOfRoomsGreaterThanEqualAndDestination(int numberOfRooms, String destination);
//
//    List<Hotel> findByNumberOfGuestsGreaterThanEqualAndDestination(int numberOfGuests, String destination);
//
//    boolean existsByCnpj(String cnpj);
//
//    Hotel findByCnpj(String cnpj);
}
