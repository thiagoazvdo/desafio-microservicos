package controller;

import model.Hotel;
import model.HotelSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/search")
    public List<Hotel> searchHotels(HotelSearchCriteria criteria){
        return hotelService.searchHotels(criteria);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }

}
