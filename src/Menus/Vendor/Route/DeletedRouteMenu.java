package Menus.Vendor.Route;
import Components.Bus;
import Components.Route;

public abstract class DeletedRouteMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu(Route rmvRoute) { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| Route removed:                              |");
        System.out.println("|–--------------------------------------------|");
        System.out.printf("|  ID:           %-29s|\n", rmvRoute.getId());
        System.out.println("|                                             |");
        System.out.printf("|  Origin:       %-29s|\n", rmvRoute.getOrigin());
        System.out.printf("|  Destination:  %-29s|\n", rmvRoute.getDestination());
        System.out.println("|                                             |");

        // print list of cancelled busses
        System.out.println("| Cancellations:                              |");
        if (rmvRoute.getAssignedBusses().size() == 0) {
            System.out.println("|    none                                     |");
        } else {
            for (Bus bus : rmvRoute.getAssignedBusses()) {
                System.out.printf("|    Bus:  %-35s|\n", bus.getId());
            }
        }

        System.out.println("|–--------------------------------------------|");
        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Remove another route          |");
        System.out.println("|            2. Back to route management      |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
