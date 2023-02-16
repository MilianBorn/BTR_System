package Menus.Customer;
import Components.Bus;
import Components.Route;

public abstract class AvailableBussesMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Route searchedRoute) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|              Customer Platform              |");
        System.out.println("===============================================");
        System.out.println("|  Available busses:                          |");
        System.out.println("|–--------------------------------------------|");

        for (Bus bus : searchedRoute.getAssignedBusses()) {
            System.out.printf("|  ID:            %-24s|\n", bus.getId());
            System.out.printf("|  Route:         %-24s|\n", bus.getRoute().getId());
            System.out.printf("|  Date:          %-24s|\n", bus.getDate());
            System.out.printf("|  Time:          %-24s|\n", bus.getTime());
            System.out.printf("|  Free seats:    %-24d|\n", bus.freeSeats());
            System.out.printf("|  Price (EUR):   %-24.2f|\n", bus.getPrice());
            System.out.println("|–----------------------------------------|");
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|        1. Select Bus                        |");
        System.out.println("|        2. Back to Menu                      |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
