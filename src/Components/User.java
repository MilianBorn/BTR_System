package Components;

import java.util.ArrayList;
import java.time.LocalDate;
public abstract class User { // this class represents a user and is used to initialise user instances
    private String fname;
    private String lname;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    protected ArrayList<Bus> TicketList;    // list of booked tickets
    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public User() {
        TicketList = new ArrayList<>();
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public abstract boolean isAdmin();

    public ArrayList<Bus> getTicketList() {
        return this.TicketList;
    }

    public void addTicket(Bus ticket) {
        this.TicketList.add(ticket);
    }
    public void removeTicket(Bus ticket) {
        this.TicketList.remove(ticket);
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
}
