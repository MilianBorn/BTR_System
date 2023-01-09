package Peaces;

import java.util.ArrayList;
import java.util.List;

public class User { // this class represents a user and is used to initialise user instances
    public String fname;
    public String lname;
    public String dob;
    public String email;
    public String username;
    public String password;
    public List<Bus> TicketList = new ArrayList<>();    // list of booked tickets
}
