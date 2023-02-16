package Menus.Vendor.Bus;
import Components.Bus;

public abstract class NewBusMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Bus newBus) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| New bus added:                              |");
        System.out.println("|–--------------------------------------------|");
        System.out.printf("|  ID:         %-17s|\n", newBus.getId());
        System.out.printf("|  Route:      %-17s|\n", newBus.getRoute().getId());
        System.out.printf("|  Date:       %-17s|\n", newBus.getDate());
        System.out.printf("|  Time:       %-17s|\n", newBus.getTime());
        System.out.printf("|  Capacity:   %-17s|\n", newBus.getCapacity());
        System.out.printf("|  Price:      %-17.2f|\n", newBus.getPrice());
        System.out.println("|–--------------------------------------------|");
        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Add another bus               |");
        System.out.println("|            2. Back to bus management        |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
