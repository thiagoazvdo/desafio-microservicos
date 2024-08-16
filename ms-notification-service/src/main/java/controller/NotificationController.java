package controller;

import model.Notification;
import model.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationService.sendNotification(notification);
    }

    @PostMapping("/reservation")
    public ResponseEntity<String> notifyReservation(@RequestBody ReservationDTO reservation) {
        notificationService.notifyReservation(reservation);
        return ResponseEntity.ok("Notification sent successfully.");
    }


}
