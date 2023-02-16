package Menus.Vendor;
import Components.Bus;
import Components.Route;
import Systems.RouteManager;

public abstract class AllRoutesBussesMenu {
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
            System.out.printf("|  ID:           %-29s|\n", route.getId());
            System.out.println("|                                             |");
            System.out.printf("|  Origin:       %-29s|\n", route.getOrigin());
            System.out.printf("|  Destination:  %-29s|\n", route.getDestination());
            System.out.printf("|  # of busses:  %-29d|\n", route.getAssignedBusses().size());
            System.out.println("|–--------------------------------------------|");
            System.out.println("|–--------------------------------------------|");

            if (route.getAssignedBusses().size() > 0) {
                for (Bus bus : route.getAssignedBusses()) {
                    System.out.println("|  Bus                                        |");
                    System.out.printf("|  ID:           %-29s|\n", bus.getId());
                    System.out.printf("|  Route:        %-29s|\n", bus.getRoute().getId());
                    System.out.printf("|  Date:         %-29s|\n", bus.getDate());
                    System.out.printf("|  Time:         %-29s|\n", bus.getTime());
                    System.out.printf("|  Capacity:     %-29s|\n", bus.getCapacity());
                    System.out.printf("|  Free seats:   %-29d|\n", bus.freeSeats());
                    System.out.printf("|  Price (EUR):  %-29.2f|\n", bus.getPrice());
                    System.out.println("|–--------------------------------------------|");
                }
            }
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
