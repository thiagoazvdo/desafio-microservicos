package service;

import model.Hotel;
import model.HotelSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> searchHotels(HotelSearchCriteria criteria) {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
}
