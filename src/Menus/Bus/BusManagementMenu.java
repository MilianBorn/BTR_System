package Menus.Bus;

public class BusManagementMenu {
    public static int length = 4;  // reflects the number of available options
    public static void printMenu() { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|        Bus Management Menu        |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|          1. List Busses           |");
        System.out.println("|          2. Add Busses            |");
        System.out.println("|          3. Remove Busses         |");
        System.out.println("|          4. Vendor Menu           |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
