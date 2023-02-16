package menus.customer;
import components.Bus;
import components.User;

public class TicketHistoryMenu {
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

        // get current status of the busses in ticket list
        for (Bus bus : currentUser.getTicketList()) {
            String status;
            if (bus.getStatus()) {
                status = "\u001B[32m" + "confirmed" + "\u001B[0m";
            } else {
                status = "\u001B[31m"+ "cancelled" + "\u001B[0m";
            }

            // print bus (ticket) details
            System.out.printf("|  ID:            %-28s|\n", bus.getId());
            System.out.printf("|  Route:         %-28s|\n", bus.getRoute().getId());
            System.out.printf("|  Date:          %-28s|\n", bus.getDate());
            System.out.printf("|  Time:          %-28s|\n", bus.getTime());
            System.out.printf("|  Price (EUR):   %-28.2f|\n", bus.getPrice());
            System.out.printf("|  Status:        %-37s|\n", status);
            System.out.println("|–--------------------------------------------|");
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Back to Menu                  |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}