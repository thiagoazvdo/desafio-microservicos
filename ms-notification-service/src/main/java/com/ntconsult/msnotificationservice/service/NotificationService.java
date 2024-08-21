package com.ntconsult.msnotificationservice.service;

import com.ntconsult.msnotificationservice.model.Reservation;
import com.ntconsult.msnotificationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }


}
