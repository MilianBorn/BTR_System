package Peaces;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bus {

    private String id;                                       // unique bus ID
    private String route;                                    // route of the bus
    private LocalDate date;                                  // date of departure
    private LocalTime time;                                  // time of departure
    private int capacity;                                    // capacity of the bus
    private float price;                                     // price of the bus
    private List<User> PassengerList;                        // list of passengers

    public Bus() {
        PassengerList = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void addPassenger(User passenger) {
        this.PassengerList.add(passenger);
    }

    public String getId() {
        return this.id;
    }
    public String getRoute() {
        return this.route;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public LocalTime getTime() {
        return this.time;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public float getPrice() {
        return this.price;
    }

    public int freeSeats() {
        return capacity - PassengerList.size();
    }
}

