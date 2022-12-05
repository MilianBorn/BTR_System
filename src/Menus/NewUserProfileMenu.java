package Menus;
import Peaces.User;

public class NewUserProfileMenu {
    public static int length = 3;
    public static void printMenu(User newCustomer) {
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|         Customer Platform         |");
        System.out.println("=====================================");
        System.out.println("| Your user profile:                |");
        System.out.println("|–----------------------------------|");
        System.out.printf("   First name:    %s\n", newCustomer.fname);
        System.out.printf("   Last name:     %s\n", newCustomer.lname);
        System.out.printf("   Date of birth: %s\n", newCustomer.dob);
        System.out.printf("   Email:         %s\n", newCustomer.email);
        System.out.println();
        System.out.printf("   Username:      %s\n", newCustomer.username);
        System.out.printf("   Password:      %s\n", newCustomer.password);
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Login with this account  |");
        System.out.println("|       2. Register another user    |");
        System.out.println("|       3. Back to menu             |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
