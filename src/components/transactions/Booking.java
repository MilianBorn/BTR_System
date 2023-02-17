package components.transactions;

import components.Bus;
import components.User;

public class Booking extends Transaction {

    public Booking(User user, Bus bus) {
        super(user, bus);
    }

    @ Override
    public String toString() {
        return "\u001B[32m" + "New booking" + "\u001B[0m"; // print in green
    }
}
