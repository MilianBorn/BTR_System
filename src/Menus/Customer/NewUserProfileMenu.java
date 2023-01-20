package Menus.Customer;
import Components.User;

public class NewUserProfileMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 3;
    }
    public static void printMenu(User newUser) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|         Customer Platform         |");
        System.out.println("=====================================");
        System.out.println("| New user profile:                 |");
        System.out.println("|–----------------------------------|");
        System.out.printf("| First name:    %-19s|\n", newUser.getFname());
        System.out.printf("| Last name:     %-19s|\n", newUser.getLname());
        System.out.printf("| Date of birth: %-19s|\n", newUser.getDob());
        System.out.printf("| Email:         %-19s|\n", newUser.getEmail());
        System.out.println("|                                   |");
        System.out.printf("| Username:      %-19s|\n", newUser.getUsername());
        System.out.printf("| Password:      %-19s|\n", newUser.getPassword());
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Login with this account  |");
        System.out.println("|       2. Register another user    |");
        System.out.println("|       3. Back to menu             |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
