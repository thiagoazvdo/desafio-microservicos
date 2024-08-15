package com.ntconsult.mshotelservice.repository;

import com.ntconsult.mshotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h WHERE h.destination LIKE %:destination%")
    List<Hotel> findByDestination(@Param("destination") String destination);

    @Query("SELECT h FROM Hotel h WHERE h.checkInDate <= :checkInDate AND h.checkOutDate >= :checkOutDate AND h.destination = :destination")
    List<Hotel> findByCheckInDateAndCheckOutDateAndDestination(@Param("checkInDate") LocalDate checkInDate,
                                                 @Param("checkOutDate") LocalDate checkOutDate, @Param("destination") String destination);

    @Query("SELECT h FROM Hotel h WHERE h.numberOfRooms >= :numberOfRooms AND h.destination = :destination")
    List<Hotel> findByNumberOfRoomsAndDestination(@Param("numberOfRooms") int numberOfRooms, @Param("destination") String destination);

    @Query("SELECT h FROM Hotel h WHERE h.numberOfGuests >= :numberOfGuests AND h.destination = :destination")
    List<Hotel> findByNumberOfGuestsAndDestination(@Param("numberOfGuests") int numberOfGuests, @Param("destination") String destination);

    boolean existsByCnpj(String cnpj);
}
