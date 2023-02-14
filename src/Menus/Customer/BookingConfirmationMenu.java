package Menus.Customer;
import Components.Bus;
import Menus.Menu;

public class BookingConfirmationMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Bus searchedBus) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|              Customer Platform              |");
        System.out.println("===============================================");
        System.out.println("| Booking confirmation:                       |");
        System.out.println("|–--------------------------------------------|");
        System.out.printf("|  ID:                    %-16s|\n", searchedBus.getId());
        System.out.printf("|  Route:                 %-16s|\n", searchedBus.getRoute().getId());
        System.out.printf("|  Date:                  %-16s|\n", searchedBus.getDate());
        System.out.printf("|  Time:                  %-16s|\n", searchedBus.getTime());
        System.out.printf("|  Price (EUR):           %-16.2f|\n", searchedBus.getPrice());
        System.out.println("|–--------------------------------------------|");
        System.out.println("| Options:                                    |");
        System.out.println("|            1. Confirm Booking               |");
        System.out.println("|            2. Back to Menu                  |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
