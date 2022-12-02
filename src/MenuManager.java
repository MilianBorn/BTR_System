import java.util.Scanner;

public class MenuManager {
    public static int getOption(int x) {
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
            for (int i = 0; i < x; i++) {
                if (option == i + 1) {
                    System.out.println("Option " + option + " selected");
                    System.out.println();
                    System.out.println();
                    isSet = true;
                }
            }
            if (!isSet) {
                System.out.println("Invalid selection");
            }
        }
        return option;
    }
}
