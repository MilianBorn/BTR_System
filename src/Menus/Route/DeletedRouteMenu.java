package Menus.Route;
import Peaces.Bus;
import Peaces.Route;

public class DeletedRouteMenu {
    public static int length = 2; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu(Route rmvRoute) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Vendor Platform          |");
        System.out.println("=====================================");
        System.out.println("| Route removed:                    |");
        System.out.println("|–----------------------------------|");
        System.out.printf("|  ID:          %-20s|\n", rmvRoute.getId());
        System.out.println("|                                   |");
        System.out.printf("|  Origin:      %-20s|\n", rmvRoute.getOrigin());
        System.out.printf("|  Destination: %-20s|\n", rmvRoute.getDestination());
        System.out.println("|                                   |");
        // ToDo: implement feature to delete busses if route is deleted
        // print list of cancelled busses
        System.out.println("| Cancellations:                    |");
        if (rmvRoute.getAssignedBusses().size() == 0) {
            System.out.println("|    none                           |");
        } else {
            for (Bus bus : rmvRoute.getAssignedBusses()) {
                System.out.printf("|      Bus:     %-20s|\n", bus.id);
            }
        }
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Remove another route     |");
        System.out.println("|       2. Back to route management |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
