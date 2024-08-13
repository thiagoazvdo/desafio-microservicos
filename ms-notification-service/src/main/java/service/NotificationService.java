package service;

import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void notifyReservation(Reservation reservation){
        Notification notification = new Notification();
        notification.setRecipient(reservation.getUserContact());
        notification.setMessage("Sua reserva foi confirmada para o hotel" +
                reservation.getHotel().getName()
        + " de " + reservation.getCheckInDate()
        + " até " + reservation.getCheckOutDate());
        sendNotification(notification);
    }
}
