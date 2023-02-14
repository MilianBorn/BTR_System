package Menus.Customer;
import Components.Bus;
import Components.Route;
import Menus.Menu;

public class AvailableBussesMenu implements Menu {
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
        System.out.println("|      Available busses:                      |");
        System.out.println("|–--------------------------------------------|");

        for (Bus bus : searchedRoute.getAssignedBusses()) {
            System.out.printf("|  ID:                    %-12s|\n", bus.getId());
            System.out.printf("|  Route:                 %-12s|\n", bus.getRoute().getId());
            System.out.printf("|  Date:                  %-12s|\n", bus.getDate());
            System.out.printf("|  Time:                  %-12s|\n", bus.getTime());
            System.out.printf("|  Free seats:            %-12d|\n", bus.freeSeats());
            System.out.printf("|  Price (EUR):           %-12.2f|\n", bus.getPrice());
            System.out.println("|–----------------------------------------|");
        }

        System.out.println("|      Options:                               |");
        System.out.println("|            1. Select Bus                    |");
        System.out.println("|            2. Back to Menu                  |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
