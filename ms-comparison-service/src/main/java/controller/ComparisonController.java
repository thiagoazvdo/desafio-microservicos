package controller;

import model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ComparisonService;

import java.util.List;

@RestController
@RequestMapping("comparisons")
public class ComparisonController {

    @Autowired
    private ComparisonService comparisonService;

    @PostMapping
    public List<ComparisonService> compareHotels(@RequestBody List<Long> hotelIds){
        return comparisonService.compareHotels(hotelIds);
    }

}
