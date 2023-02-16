package menus.vendor.route;

public class RouteManagementMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 4;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|         Bus Ticket Reservation System       |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Route Management              |");
        System.out.println("===============================================");
        System.out.println("|  Options:                                   |");
        System.out.println("|             1. List Routes                  |");
        System.out.println("|             2. Add Route                    |");
        System.out.println("|             3. Remove Route                 |");
        System.out.println("|             4. Vendor Menu                  |");
        System.out.println("===============================================");
    }
}