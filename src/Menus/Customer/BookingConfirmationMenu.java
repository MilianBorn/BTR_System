package Menus.Customer;
import Components.Bus;

public abstract class BookingConfirmationMenu {
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
        System.out.printf("|  ID:            %-28s|\n", searchedBus.getId());
        System.out.printf("|  Route:         %-28s|\n", searchedBus.getRoute().getId());
        System.out.printf("|  Date:          %-28s|\n", searchedBus.getDate());
        System.out.printf("|  Time:          %-28s|\n", searchedBus.getTime());
        System.out.printf("|  Price (EUR):   %-28.2f|\n", searchedBus.getPrice());
        System.out.println("|–--------------------------------------------|");
        System.out.println("| Options:                                    |");
        System.out.println("|            1. Confirm Booking               |");
        System.out.println("|            2. Back to Menu                  |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
