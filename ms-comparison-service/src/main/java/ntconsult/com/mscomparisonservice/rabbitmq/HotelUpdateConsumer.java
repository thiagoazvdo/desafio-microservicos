package ntconsult.com.mscomparisonservice.rabbitmq;

import ntconsult.com.mscomparisonservice.model.Hotel;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelUpdateConsumer {

    @RabbitListener(queues = RabbitMQConfig.HOTEL_UPDATE_QUEUE)
    public void recieveHotelUpdate(Hotel hotel){
        System.out.println("Hotel Updated" + hotel);
    }

}
