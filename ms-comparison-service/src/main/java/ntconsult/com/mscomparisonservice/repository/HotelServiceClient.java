package ntconsult.com.mscomparisonservice.repository;

import ntconsult.com.mscomparisonservice.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-hotel-service")
public interface HotelServiceClient {

    @GetMapping("/hotels")
    List<Hotel> getHotels(@RequestParam Double maxPrice, @RequestParam String location, @RequestParam Double minRating);
}
