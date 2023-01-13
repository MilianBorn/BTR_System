package Menus.Customer;
import Peaces.User;

public class NewUserProfileMenu {
    public static int length = 3; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu(User newUser) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|         Customer Platform         |");
        System.out.println("=====================================");
        System.out.println("| New user profile:                 |");
        System.out.println("|–----------------------------------|");
        System.out.printf("| First name:    %-19s|\n", newUser.fname);
        System.out.printf("| Last name:     %-19s|\n", newUser.lname);
        System.out.printf("| Date of birth: %-19s|\n", newUser.dob);
        System.out.printf("| Email:         %-19s|\n", newUser.email);
        System.out.println("|                                   |");
        System.out.printf("| Username:      %-19s|\n", newUser.username);
        System.out.printf("| Password:      %-19s|\n", newUser.password);
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Login with this account  |");
        System.out.println("|       2. Register another user    |");
        System.out.println("|       3. Back to menu             |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
