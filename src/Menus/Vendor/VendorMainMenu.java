package Menus.Vendor;

import Menus.Menu;

public class VendorMainMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 6;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("================================================");
        System.out.println("|        Bus Ticket Reservation System         |");
        System.out.println("|   ----------------------------------------   |");
        System.out.println("|             Vendor Main  Menu                |");
        System.out.println("================================================");
        System.out.println("|      Options:                                |");
        System.out.println("|            1. Manage Routes                  |");
        System.out.println("|            2. Manage Busses                  |");
        System.out.println("|            3. Overview Busses & Routes       |");
        System.out.println("|            4. Transaction History            |");
        System.out.println("|            5. Registered Customers           |");
        System.out.println("|            6. Log Out (Main Menu)            |");
        System.out.println("|                                              |");
        System.out.println("================================================");
    }
}
