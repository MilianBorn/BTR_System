import java.util.Scanner;

public class LoginSystem {

    public static void printStartMenu() {
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. Customer login      |");
        System.out.println("|            2. Vendor login        |");
        System.out.println("|            3. Exit                |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }

    public static void printCustomerLogin() {
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Customer Portal          |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. Login               |");
        System.out.println("|            2. Sign up             |");
        System.out.println("|            3. Main menu           |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }

    public static int getOption() {
        int option = -1;
        boolean isSet = false;
        Scanner getInput = new Scanner(System.in);

        while (!isSet) {
            System.out.print("Select option: ");
            try {
                option = Integer.parseInt(getInput.nextLine());
            } catch (NumberFormatException nfEx) {
                System.out.println("Invalid selection");
                continue;
            }
            if (option == 1 || option == 2 || option == 3) {
                System.out.println("Option " + option + " selected");
                isSet = true;
            } else {
                System.out.println("Invalid selection");
            }
        }
        return option;
    }
}
