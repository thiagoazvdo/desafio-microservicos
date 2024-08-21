package ntconsult.com.mscomparisonservice.service;

import ntconsult.com.mscomparisonservice.model.ComparisonCriteria;
import ntconsult.com.mscomparisonservice.model.ComparisonResult;
import ntconsult.com.mscomparisonservice.model.Hotel;
import ntconsult.com.mscomparisonservice.repository.HotelServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelComparisonService {

    @Autowired
    private HotelServiceClient hotelServiceClient;

    public List<ComparisonResult> compareHotels(Double maxPrice, String location, Double minRating) {
        // Fetch hotels from ms-hotel-service
        List<Hotel> hotels = hotelServiceClient.getHotels(maxPrice, location, minRating);

        // Compare hotels based on criteria
        List<ComparisonResult> results = new ArrayList<>();
        for (Hotel hotel : hotels) {
            ComparisonResult result = new ComparisonResult();
            result.setHotelId(hotel.getId());
            // Implement comparison logic here
            results.add(result);
        }
        return results;
    }

    public void processComparison(ComparisonCriteria criteria) {
        List<Hotel> hotels = hotelServiceClient.getHotels(
                criteria.getMaxPrice(),
                criteria.getLocation(),
                criteria.getMinRating()
        );

        List<ComparisonResult> comparisonResults = new ArrayList<>();
        for (Hotel hotel : hotels) {
            ComparisonResult result = new ComparisonResult();
            result.setHotelId(hotel.getId());
            result.setPriceComparison(calculatePriceComparison(hotel, criteria.getMaxPrice()));
            result.setRatingComparison(calculateRatingComparison(hotel, criteria.getMinRating()));

            comparisonResults.add(result);
        }

    }

    private Double calculatePriceComparison(Hotel hotel, Double maxPrice) {
        return maxPrice != null ? hotel.getPrice() / maxPrice : 0.0;
    }

    private Double calculateRatingComparison(Hotel hotel, Double minRating) {
        return minRating != null ? hotel.getRating() / minRating : 0.0;
    }
}
