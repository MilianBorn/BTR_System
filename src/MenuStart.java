import java.util.Scanner;

public class MenuStart {

    public static int printMenu() {
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
            if (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println("You selected option: " + option);
                isSet = true;
            } else {
                System.out.println("Invalid selection");
            }
        }
        return option;
    }
}
