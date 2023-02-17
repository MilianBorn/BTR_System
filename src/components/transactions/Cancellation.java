package components.transactions;

import components.Bus;
import components.User;

public class Cancellation extends Transaction {

    public Cancellation(User user, Bus bus) {
        super(user, bus);
    }

    @ Override
    public String toString() {
        return "\u001B[31m" + "Cancellation" + "\u001B[0m"; // print in red
    }
}
