package com.ntconsult.msreservationservice.service;

import com.ntconsult.msreservationservice.DTO.HotelResponseDTO;
import com.ntconsult.msreservationservice.DTO.ReservationRequestDTO;
import com.ntconsult.msreservationservice.DTO.ReservationResponseDTO;
import com.ntconsult.msreservationservice.exception.ReservationNotFoundException;
import com.ntconsult.msreservationservice.model.Hotel;
import com.ntconsult.msreservationservice.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ntconsult.msreservationservice.repository.ReservationRepository;

import javax.management.Notification;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationDTO){
        // Creating the Reservation from the DTO
        Reservation reservation = new Reservation();
        reservation.setCheckInDate(reservationDTO.getCheckInDate().toString());
        reservation.setCheckOutDate(reservationDTO.getCheckOutDate().toString());
        reservation.setReservationDate(reservationDTO.getReservationDate());

        // Searching the hotel
        Hotel hotel = new Hotel();
        hotel.setId(reservationDTO.getHotelId());
        reservation.setHotel(hotel);

        // Saving the reservation
        Reservation savedReservation = reservationRepository.save(reservation);

        // Sending the notification
//        String notificationServiceUrl = "http://ms-notification-service/notifications";
        String notificationServiceUrl = "http://ms-notification-service";
        Notification notification = new Notification("Your reservation was confirmed", Reservation.class, savedReservation.getId());
        restTemplate.postForEntity(notificationServiceUrl, notification, Notification.class);

        // Converting the reservation saved to DTO
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        responseDTO.setId(savedReservation.getId());
        responseDTO.setReservationDate(savedReservation.getReservationDate());
        responseDTO.setCheckInDate(savedReservation.getCheckInDate());
        responseDTO.setCheckoutDate(savedReservation.getCheckOutDate());

        // Adding hotel information
        HotelResponseDTO hotelDTO = new HotelResponseDTO();
        hotelDTO.setId(savedReservation.getHotel().getId());
        responseDTO.setHotel(hotelDTO);

        return responseDTO;
    }


    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(ReservationNotFoundException::new);
        reservationRepository.delete(reservation);
    }
}
