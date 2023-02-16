package components;

import java.util.ArrayList;

public class Route {
    private String id;
    private String origin;
    private String destination;
    private final ArrayList<Bus> AssignedBusses;
    public Route() {
        AssignedBusses = new ArrayList<>();
    }

    // setters
    public void setId(String id) {
        this.id = id;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    // getters
    public String getId() {
        return this.id;
    }
    public String getOrigin() {
        return this.origin;
    }
    public String getDestination() {
        return this.destination;
    }
    public ArrayList<Bus> getAssignedBusses() {
        return AssignedBusses;
    }

    // assign and remove busses to the route
    public void assignBus(Bus bus) {
        this.AssignedBusses.add(bus);
    }
    public void removeBus(Bus bus) {
        this.AssignedBusses.remove(bus);
    }
}
