package Peaces;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bus {

    public String id;                                       // unique bus ID
    public String route;                                    // route of the bus
    public LocalDate date;                                  // date of departure
    public LocalTime time;                                  // time of departure
    public int capacity;                                    // capacity of the bus
    public float price;                                     // price of the bus
    public List<User> PassengerList = new ArrayList<>();    // list of passengers

    public int freeSeats() {
        return capacity - PassengerList.size();
    }
}

