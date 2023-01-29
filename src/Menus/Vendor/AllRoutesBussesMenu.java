package Menus.Vendor;
import Components.Bus;
import Components.Route;
import Systems.RouteManager;

public class AllRoutesBussesMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 1;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Vendor Platform          |");
        System.out.println("=====================================");
        System.out.println("| Route and busses:                 |");
        System.out.println("|–----------------------------------|");

        for (Route route : RouteManager.RouteList) {
            System.out.println("|–----------------------------------|");
            System.out.println("|  Route                            |");
            System.out.printf("|  ID:          %-20s|\n", route.getId());
            System.out.println("|                                   |");
            System.out.printf("|  Origin:      %-20s|\n", route.getOrigin());
            System.out.printf("|  Destination: %-20s|\n", route.getDestination());
            System.out.printf("|  # of busses: %-20d|\n", route.getAssignedBusses().size());
            System.out.println("|–----------------------------------|");
            System.out.println("|–----------------------------------|");

            if (route.getAssignedBusses().size() > 0) {
                for (Bus bus : route.getAssignedBusses()) {
                    System.out.println("|  Bus                              |");
                    System.out.printf("|  ID:          %-20s|\n", bus.getId());
                    System.out.printf("|  Route:       %-20s|\n", bus.getRoute().getId());
                    System.out.printf("|  Date:        %-20s|\n", bus.getDate());
                    System.out.printf("|  Time:        %-20s|\n", bus.getTime());
                    System.out.printf("|  Capacity:    %-20s|\n", bus.getCapacity());
                    System.out.printf("|  Free seats:  %-20d|\n", bus.freeSeats());
                    System.out.printf("|  Price (EUR): %-20.2f|\n", bus.getPrice());
                    System.out.println("|–----------------------------------|");
                }
            }
        }

        System.out.println("| Options:                          |");
        System.out.println("|       1. Vendor Menu              |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
