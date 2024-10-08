package com.ntconsult.mshotelservice.repository;

import com.ntconsult.mshotelservice.model.Hotel;
import com.ntconsult.mshotelservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHotel(Hotel hotel);
}
