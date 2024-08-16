package com.ntconsult.msreservationservice.repository;

import com.ntconsult.msreservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
