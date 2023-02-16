package Menus.Customer;

import Components.User;

public abstract class CustomerMainMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 3;
    }
    public static void printMenu(User currentUser) { // method to print the menu
        // ToDo: Print current customer's name in the menu
        System.out.println("===============================================");
        System.out.println("|         Bus Ticket Reservation System       |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Customer Platform             |");
        System.out.println("===============================================");
        System.out.println("|                                             |");
        System.out.printf("| Welcome %-36s|\n", currentUser.getFname() + " " + currentUser.getLname());
        System.out.println("|                                             |");
        System.out.println("| Options:                                    |");
        System.out.println("|                 1. Search Routes            |");
        System.out.println("|                 2. Ticket History           |");
        System.out.println("|                 3. Logout                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
