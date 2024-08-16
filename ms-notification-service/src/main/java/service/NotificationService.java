package service;

import model.Notification;
import model.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NotificationRepository;

import static model.NotificationType.EMAIL;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void notifyReservation(ReservationDTO reservation){
        Notification notification = new Notification();
        notification.setRecipient(reservation.getUserContact());
        notification.setMessage("Your reservation was confirmed at the hotel " +
                reservation.getHotelName() +
                " from " + reservation.getCheckInDate() +
                " to " + reservation.getCheckoutDate());
        notification.setType(EMAIL);

        sendNotification(notification);
    }
}
