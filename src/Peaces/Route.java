package Peaces;

import java.util.ArrayList;

public class Route {
    // ToDo: Varsha -> create class for routes

    // source, destination, optional ID
    // should we keep track of assigned busses? -> ArrayList for Bus objects

    private String id;
    private String origin;
    private String destination;
    private ArrayList<Bus> AssignedBusses;

    public Route() {
        AssignedBusses = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
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
    public void assignBus(Bus bus) {
        this.AssignedBusses.add(bus);
    }
}
