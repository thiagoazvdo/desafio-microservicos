package com.ntconsult.msreservationservice.service;

import com.ntconsult.msreservationservice.DTO.CustomerRequestDTO;
import com.ntconsult.msreservationservice.DTO.HotelResponseDTO;
import com.ntconsult.msreservationservice.DTO.ReservationRequestDTO;
import com.ntconsult.msreservationservice.DTO.ReservationResponseDTO;
import com.ntconsult.msreservationservice.exception.CustomerNotFoundException;
import com.ntconsult.msreservationservice.exception.ReservationNotFoundException;
import com.ntconsult.msreservationservice.exception.rabbitmq.ErrorSendReservationQueueException;
import com.ntconsult.msreservationservice.model.rabbitmq.DataReservation;
import com.ntconsult.msreservationservice.model.Hotel;
import com.ntconsult.msreservationservice.model.Reservation;
import com.ntconsult.msreservationservice.model.rabbitmq.ProtocolSendReservation;
import com.ntconsult.msreservationservice.service.mqueue.ReservationPublisher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntconsult.msreservationservice.repository.ReservationRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationPublisher reservationPublisher;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationDTO) {
        // Creating the Reservation from the DTO
        Reservation reservation = new Reservation();
        reservation.setCheckInDate(reservationDTO.getCheckInDate());
        reservation.setCheckOutDate(reservationDTO.getCheckOutDate());
        reservation.setNumberOfRooms(reservationDTO.getNumberOfRooms());

        // Verifying if the CustomerDTO isn`t null
        CustomerRequestDTO customerRequestDTO = reservationDTO.getCustomer();
        if (customerRequestDTO == null) throw new CustomerNotFoundException();

        // Searching the hotel
        Hotel hotel = new Hotel();
        hotel.setId(reservationDTO.getHotelId());
        reservation.setHotel(hotel);

        // Saving the reservation
        Reservation savedReservation = saveReservation(reservationDTO);

        // Converting the reservation saved to DTO
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        responseDTO.setId(savedReservation.getId());
        responseDTO.setReservationDate(savedReservation.getReservationDate());
        responseDTO.setCheckInDate(savedReservation.getCheckInDate());
        responseDTO.setCheckOutDate(savedReservation.getCheckOutDate());
        responseDTO.setNumberOfRooms(savedReservation.getNumberOfRooms());

        // Adding hotel information
        HotelResponseDTO hotelDTO = new HotelResponseDTO();
        hotelDTO.setId(reservationDTO.getHotelId());
        responseDTO.setHotel(hotelDTO);

        return responseDTO;
    }

    public Reservation saveReservation(ReservationRequestDTO reservationDTO){
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDTO, reservation);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(ReservationNotFoundException::new);
        reservationRepository.delete(reservation);
    }

    public ProtocolSendReservation sendReservation(DataReservation dataReservation) {
        try {
            reservationPublisher.publishReservation(dataReservation);
            var protocol = UUID.randomUUID().toString();
            return new ProtocolSendReservation(protocol);
        }catch (Exception e){
            throw new ErrorSendReservationQueueException(e.getMessage());
        }
    }


}
