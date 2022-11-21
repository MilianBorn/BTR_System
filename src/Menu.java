import java.util.Scanner;

public class Menu {

    public static int MainMenu() {
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. Customer login      |");
        System.out.println("|            2. Vendor login        |");
        System.out.println("|            3. Print session       |");
        System.out.println("|            4. Exit                |");
        System.out.println("|                                   |");
        System.out.println("=====================================");

        int option;
        do {
            Scanner getInput = new Scanner(System.in);
            System.out.print("Select option: ");
            boolean isSet = false;
            while (!isSet) {
                try {
                    option = Integer.parseInt(getInput.nextLine());
                } catch (NumberFormatException) {
                    System.out.println("Invalid option selected");
                }
            }
            try {
                option = Integer.parseInt(getInput.nextLine());
            } catch (NumberFormatException) {
                System.out.println("Invalid option selected");
            }
                option = Integer.parseInt(getInput.nextLine());
            if (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println("Invalid option selected");
            }
        } while (option != 1 && option != 2 && option != 3 && option != 4);
        System.out.println("You selected option: " + option);
        return option;
    }
}
