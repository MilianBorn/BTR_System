package menus.vendor.bus;
import components.Bus;

public class DeletedBusMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Bus rmvBus) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| Bus removed:                                |");
        System.out.println("|–--------------------------------------------|");
        System.out.printf("|  UID:        %-31s|\n", rmvBus.getId());
        System.out.printf("|  Route:      %-31s|\n", rmvBus.getRoute().getId());
        System.out.printf("|  Date:       %-31s|\n", rmvBus.getDate());
        System.out.printf("|  Time:       %-31s|\n", rmvBus.getTime());
        System.out.printf("|  Capacity:   %-31s|\n", rmvBus.getCapacity());
        System.out.printf("|  Cancelled:  %-31s|\n", rmvBus.getCapacity() - rmvBus.freeSeats());
        System.out.printf("|  Price:      %-31.2f|\n", rmvBus.getPrice());
        System.out.println("|–--------------------------------------------|");
        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Remove another bus            |");
        System.out.println("|            2. Back to bus management        |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}