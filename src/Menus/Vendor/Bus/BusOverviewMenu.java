package Menus.Vendor.Bus;
import Components.Bus;
import Systems.BusManager;

public abstract class BusOverviewMenu {

    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 3;
    }

    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| Bus overview:                               |");
        System.out.println("|–--------------------------------------------|");

        for (Bus bus : BusManager.BusList) {
            System.out.printf("|  ID:            %-24s|\n", bus.getId());
            System.out.printf("|  Route:         %-24s|\n", bus.getRoute().getId());
            System.out.printf("|  Date:          %-24s|\n", bus.getDate());
            System.out.printf("|  Time:          %-24s|\n", bus.getTime());
            System.out.printf("|  Capacity:      %-24s|\n", bus.getCapacity());
            System.out.printf("|  Free seats:    %-24d|\n", bus.freeSeats());
            System.out.printf("|  Price (EUR):   %-24.2f|\n", bus.getPrice());
            System.out.println("|–----------------------------------------|");
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Add Bus                       |");
        System.out.println("|            2. Remove Bus                    |");
        System.out.println("|            3. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
