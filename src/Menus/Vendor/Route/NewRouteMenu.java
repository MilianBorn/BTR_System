package Menus.Vendor.Route;
import Components.Route;
import Menus.Menu;

public class NewRouteMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Route newRoute) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| New route added:                            |");
        System.out.println("|–--------------------------------------------|");
        System.out.printf("|  ID:                    %-16s|\n", newRoute.getId());
        System.out.println("|                                             |");
        System.out.printf("|  Origin:                %-16s|\n", newRoute.getOrigin());
        System.out.printf("|  Destination:           %-16s|\n", newRoute.getDestination());
        System.out.println("|–--------------------------------------------|");
        System.out.println("|      Options:                               |");
        System.out.println("|            1. Add another route             |");
        System.out.println("|            2. Back to route management      |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
