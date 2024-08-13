package service;

import model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ComparisonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparisonService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> compareHotels(List<Long> hotelIds){
        return hotelRepository.findAllById(hotelIds);
    }

}
