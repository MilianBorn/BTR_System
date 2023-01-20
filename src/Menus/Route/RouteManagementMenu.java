package Menus.Route;

public class RouteManagementMenu {
    // ToDo: RouteManagementMenu -> Varsha
    public static int length = 4; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu() { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|    Bus Ticket Reservation System  |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Route Management         |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. List Routes         |");
        System.out.println("|            2. Add Route           |");
        System.out.println("|            3. Remove Route        |");
        System.out.println("|            4. Vendor Menu         |");
        System.out.println("=====================================");
    }
}
