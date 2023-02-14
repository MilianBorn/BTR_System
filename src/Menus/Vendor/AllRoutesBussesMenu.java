package Menus.Vendor;
import Components.Bus;
import Components.Route;
import Menus.Menu;
import Systems.RouteManager;

public class AllRoutesBussesMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 1;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| Route and busses:                           |");
        System.out.println("|–--------------------------------------------|");

        for (Route route : RouteManager.RouteList) {
            System.out.println("|–--------------------------------------------|");
            System.out.println("|  Route                                      |");
            System.out.printf("|  ID:                    %-10s|\n", route.getId());
            System.out.println("|                                             |");
            System.out.printf("|  Origin:                %-10s|\n", route.getOrigin());
            System.out.printf("|  Destination:           %-10s|\n", route.getDestination());
            System.out.printf("|  # of busses:           %-10d|\n", route.getAssignedBusses().size());
            System.out.println("|–--------------------------------------------|");
            System.out.println("|–--------------------------------------------|");

            if (route.getAssignedBusses().size() > 0) {
                for (Bus bus : route.getAssignedBusses()) {
                    System.out.println("|  Bus                                        |");
                    System.out.printf("|  ID:                    %-8s|\n", bus.getId());
                    System.out.printf("|  Route:                 %-8s|\n", bus.getRoute().getId());
                    System.out.printf("|  Date:                  %-8s|\n", bus.getDate());
                    System.out.printf("|  Time:                  %-8s|\n", bus.getTime());
                    System.out.printf("|  Capacity:              %-8s|\n", bus.getCapacity());
                    System.out.printf("|  Free seats:            %-8d|\n", bus.freeSeats());
                    System.out.printf("|  Price (EUR):           %-8.2f|\n", bus.getPrice());
                    System.out.println("|–--------------------------------------------|");
                }
            }
        }

        System.out.println("|      Options:                               |");
        System.out.println("|            1. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
