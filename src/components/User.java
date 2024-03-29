package components;

import java.util.ArrayList;
import java.time.LocalDate;

public class User {
    private String fname;
    private String lname;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    private ArrayList<Bus> TicketList;    // list of booked tickets

    public User() {
        TicketList = new ArrayList<>();
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setDob(LocalDate dob) {
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
    public void setTicketList(ArrayList<Bus> ticketList) {
        this.TicketList = ticketList;
    }

    public String getFname() {
        return this.fname;
    }
    public String getLname() {
        return this.lname;
    }
    public LocalDate getDob() {
        return this.dob;
    }
    public String getEmail() {
        return this.email;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    public ArrayList<Bus> getTicketList() {
        return this.TicketList;
    }
    public void addTicket(Bus ticket) {
        this.TicketList.add(ticket);
    }
}
