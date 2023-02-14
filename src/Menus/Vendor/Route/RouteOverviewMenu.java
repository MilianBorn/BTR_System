package Menus.Vendor.Route;
import Components.Route;
import Menus.Menu;
import Systems.RouteManager;

public class RouteOverviewMenu implements Menu {
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
        System.out.println("| Route overview:                             |");
        System.out.println("|–--------------------------------------------|");

        for (Route route : RouteManager.RouteList) {
            System.out.printf("|  ID:                    %-12s|\n", route.getId());
            System.out.println("|                                             |");
            System.out.printf("|  Origin:                %-12s|\n", route.getOrigin());
            System.out.printf("|  Destination:           %-12s|\n", route.getDestination());
            System.out.printf("|  # of busses:           %-12d|\n", route.getAssignedBusses().size());
            System.out.println("|–--------------------------------------------|");
        }

        System.out.println("|      Options:                               |");
        System.out.println("|            1. Add Route                     |");
        System.out.println("|            2. Remove Route                  |");
        System.out.println("|            3. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
