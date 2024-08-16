package service;

import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.ReservationRepository;

import javax.management.Notification;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation createReservation(Reservation reservation){
        Reservation savedReservation = reservationRepository.save(reservation);

        String notificationServiceUrl = "http://ms-notification-service/notifications";
        Notification notification = new Notification("Sua reserva foi confirmada", null, savedReservation.getId());
        restTemplate.postForObject(notificationServiceUrl, notification, Notification.class);

        return savedReservation;
    }

}
