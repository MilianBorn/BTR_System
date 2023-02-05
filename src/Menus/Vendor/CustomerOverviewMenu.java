package Menus.Vendor;
import Components.User;
import Systems.CustomerManager;

public class CustomerOverviewMenu {
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
        System.out.println("| Customer overview:                |");
        System.out.println("|–----------------------------------|");

        for (User user : CustomerManager.UserList) {
            System.out.printf("| First name:    %-19s|\n", user.getFname());
            System.out.printf("| Last name:     %-19s|\n", user.getLname());
            System.out.printf("| Date of birth: %-19s|\n", user.getDob());
            System.out.printf("| Email:         %-19s|\n", user.getEmail());
            System.out.println("|                                   |");
            System.out.printf("| Username:      %-19s|\n", user.getUsername());
            System.out.printf("| Password:      %-19s|\n", user.getPassword());
            System.out.println("|–----------------------------------|");
        }

        System.out.println("| Options:                          |");
        System.out.println("|       1. Vendor Menu              |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}