package Components;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bus implements Comparable<Bus> {

    private String id;                                       // unique bus ID
    private Route route;                                    // route of the bus
    private LocalDate date;                                  // date of departure
    private LocalTime time;                                  // time of departure
    private int capacity;                                    // capacity of the bus
    private float price;                                     // price of the bus
    private boolean isConfirmed;                             //
    private ArrayList<User> PassengerList;                    // list of passengers

    public Bus() {
        PassengerList = new ArrayList<>();
        isConfirmed = true;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setRoute(Route route) {
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
    public void setStatus(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getId() {
        return this.id;
    }
    public Route getRoute() {
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
    public boolean getStatus() {
        return this.isConfirmed;
    }

    public ArrayList<User> getPassengerList() {
        return this.PassengerList;
    }
    public void addPassenger(User passenger) {
        this.PassengerList.add(passenger);
    }
    public void removePassenger(User passenger) {
        this.PassengerList.remove(passenger);
    }

    public int freeSeats() {
        return capacity - PassengerList.size();
    }
    @Override // allows bus objects to be compared and sorted by departure date
    public int compareTo(Bus bus) {
        return getDate().compareTo(bus.getDate());
    }
}

