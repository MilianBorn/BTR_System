package Peaces;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class User { // this class represents a user and is used to initialise user instances
    private String fname;
    private String lname;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    private List<Bus> TicketList = new ArrayList<>();    // list of booked tickets

    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setDate(LocalDate dob) {
        this.dob = dob;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void addBus(Bus ticket) {
        this.TicketList.add(ticket);
    }

    public String getFname(String fname) {
        return this.fname;
    }
    public String getLname(String lname) {
        return this.lname;
    }
    public LocalDate getDate(LocalDate dob) {
        return this.dob;
    }
    public String getEmail(String email) {
        return this.email;
    }
    public String getUsername(String username) {
        return this.username;
    }
    public String getPassword(String password) {
        return this.password;
    }
}
