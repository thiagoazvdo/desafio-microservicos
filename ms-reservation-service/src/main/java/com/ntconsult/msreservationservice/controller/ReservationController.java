package com.ntconsult.msreservationservice.controller;

import com.ntconsult.msreservationservice.DTO.ReservationRequestDTO;
import com.ntconsult.msreservationservice.DTO.ReservationResponseDTO;
import com.ntconsult.msreservationservice.exception.rabbitmq.ErrorSendReservationQueueException;
import com.ntconsult.msreservationservice.model.Reservation;
import com.ntconsult.msreservationservice.model.rabbitmq.DataReservation;
import com.ntconsult.msreservationservice.model.rabbitmq.ProtocolSendReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ntconsult.msreservationservice.service.ReservationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> listReservations = reservationService.getAllReservations();
        return ResponseEntity.ok(listReservations);
    }

//    @PostMapping
//    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Valid ReservationRequestDTO reservationDTO) {
//        ReservationResponseDTO responseDTO = reservationService.createReservation(reservationDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
//    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/send-reservation")
//    public ResponseEntity sendReservation(@RequestBody DataReservation dataReservation) {
//        try{
//            ProtocolSendReservation protocolSendReservation = reservationService.sendReservation(dataReservation);
//            return ResponseEntity.ok(protocolSendReservation);
//        } catch (ErrorSendReservationQueueException e){
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Valid ReservationRequestDTO reservationDTO) {
        try {
            // Creating the reservation
            ReservationResponseDTO responseDTO = reservationService.createReservation(reservationDTO);

            // Preparing the data to be sent
            DataReservation dataReservation = new DataReservation();
            dataReservation.setId(responseDTO.getId());
            dataReservation.setReservationDate(responseDTO.getReservationDate());
            dataReservation.setCheckInDate(responseDTO.getCheckInDate());
            dataReservation.setCheckOutDate(responseDTO.getCheckOutDate());
            dataReservation.setHotelId(responseDTO.getHotel().getId());
            dataReservation.setCustomerId(reservationDTO.getCustomer().getId());

            // Send the message
            ProtocolSendReservation protocolSendReservation = reservationService.sendReservation(dataReservation);

            // Return the answer with the sending protocol
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } catch (ErrorSendReservationQueueException e) {
            // If the message fail, the reservation will be created successfully, but it will not be notificated
//            return ResponseEntity.internalServerError().body("Reserva criada com sucesso, mas falha ao enviar notificação: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
