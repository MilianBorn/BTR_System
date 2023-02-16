package menus.customer;
import components.Route;
import systems.RouteManager;

public class AvailableRoutesMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|              Customer Platform              |");
        System.out.println("===============================================");
        System.out.println("| Available routes:                           |");
        System.out.println("|–--------------------------------------------|");

        // print all routes
        for (Route route : RouteManager.RouteList) {
            System.out.printf("|  ID:            %-28s|\n", route.getId());
            System.out.printf("|  # of busses:   %-28d|\n", route.getAssignedBusses().size());
            System.out.println("|–--------------------------------------------|");
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|       1. Select Route                       |");
        System.out.println("|       2. Back to Menu                       |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}