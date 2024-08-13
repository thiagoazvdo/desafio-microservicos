package service;

import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;


@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private NotificationService notificationService;

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation createReservation(Reservation reservation){
        Reservation savedReservation = reservationRepository.save(reservation);
        notificationService.notifyReservation(savedReservation);
        return savedReservation;
    }

}
