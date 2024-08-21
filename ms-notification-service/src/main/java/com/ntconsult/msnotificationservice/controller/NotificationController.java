package com.ntconsult.msnotificationservice.controller;

import com.ntconsult.msnotificationservice.model.Reservation;
import com.ntconsult.msnotificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/reservations")
    public List<Reservation> getAllNotifications() {
        return notificationService.getAllReservations();
    }
}
