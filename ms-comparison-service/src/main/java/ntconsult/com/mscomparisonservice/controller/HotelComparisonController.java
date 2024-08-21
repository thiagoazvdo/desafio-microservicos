package ntconsult.com.mscomparisonservice.controller;

import ntconsult.com.mscomparisonservice.model.ComparisonCriteria;
import ntconsult.com.mscomparisonservice.model.ComparisonResult;
import ntconsult.com.mscomparisonservice.service.HotelComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels/comparison")
public class HotelComparisonController {

    @Autowired
    private HotelComparisonService hotelComparisonService;

    @GetMapping
    public ResponseEntity<List<ComparisonResult>> getComparison(
            @RequestParam Double maxPrice,
            @RequestParam String location,
            @RequestParam Double minRating
    ) {
        List<ComparisonResult> results = hotelComparisonService.compareHotels(maxPrice, location, minRating);
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<Void> postComparison(@RequestBody ComparisonCriteria criteria) {
        hotelComparisonService.processComparison(criteria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}