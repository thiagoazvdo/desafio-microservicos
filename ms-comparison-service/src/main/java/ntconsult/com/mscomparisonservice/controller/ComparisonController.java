package ntconsult.com.mscomparisonservice.controller;

import ntconsult.com.mscomparisonservice.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ntconsult.com.mscomparisonservice.service.ComparisonService;

import java.util.List;

@RestController
@RequestMapping("comparisons")
public class ComparisonController {

    @Autowired
    private ComparisonService comparisonService;

    @PostMapping
    public List<Hotel> compareHotels(@RequestBody List<Long> hotelIds){
        return comparisonService.compareHotels(hotelIds);
    }

}
