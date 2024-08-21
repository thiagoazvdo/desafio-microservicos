package ntconsult.com.mscomparisonservice.service;

import ntconsult.com.mscomparisonservice.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ComparisonService {

    @Autowired
    RestTemplate restTemplate;

    public List<Hotel> compareHotels(List<Long> hotelIds){

        String hotelServiceUrl = "http://ms-hotel-service/hotels/ids";

        ResponseEntity<List<Hotel>> response = restTemplate.exchange(
                hotelServiceUrl,
                HttpMethod.POST,
                new HttpEntity<>(hotelIds),
                new ParameterizedTypeReference<List<Hotel>>() {}
        );
        return response.getBody();
    }

}
