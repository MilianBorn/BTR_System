package Menus.Customer;

import Menus.Menu;

public class CustomerLoginMenu implements Menu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 3;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|              Customer Platform              |");
        System.out.println("===============================================");
        System.out.println("| Options:                                    |");
        System.out.println("|                 1. Sign up                  |");
        System.out.println("|                 2. Login                    |");
        System.out.println("|                 3. Back                     |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
