package Menus.Customer;
import Components.Bus;
import Components.User;
import Menus.Menu;

public class TicketHistoryMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 1;
    }
    public static void printMenu(User currentUser) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|              Customer Platform              |");
        System.out.println("===============================================");
        System.out.println("| Ticket history:                             |");
        System.out.println("|–--------------------------------------------|");

        for (Bus bus : currentUser.getTicketList()) {
            // get current status of the bus
            String status;
            if (bus.getStatus()) {
                status = "confirmed";
            } else {
                status = "cancelled";
            }

            // print bus (ticket) details
            System.out.printf("|  ID:                    %-12s|\n", bus.getId());
            System.out.printf("|  Route:                 %-12s|\n", bus.getRoute().getId());
            System.out.printf("|  Date:                  %-12s|\n", bus.getDate());
            System.out.printf("|  Time:                  %-12s|\n", bus.getTime());
            System.out.printf("|  Price (EUR):           %-12.2f|\n", bus.getPrice());
            System.out.printf("|  Status:                %-12s|\n", status);
            System.out.println("|–----------------------------------------|");
        }

        System.out.println("| Options:                                    |");
        System.out.println("|            1. Back to Menu                  |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
