package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelSearchCriteria {

    private String destination;

    private String checkInDate;

    private String checkOutDate;

    private int numberOfRooms;

    private int numberOfGuests;

}
