package Systems;

import java.util.Scanner;

public class MenuManager { // this class is used to handle any logic needed to handle the menus
    public static int getOption(int x) { // get an option from the user and return it (takes the length of the menu as an input)

        Scanner getInput = new Scanner(System.in); // creates an instance of class scanner used to get input from user
        int option = -1; // default value for option
        boolean isSet = false; // isSet indicates if an option was selected or not

        while (!isSet) { // keep asking the user for a valid option till valid option is set
            System.out.print("Select option: "); // prompt user for option

            // first step: make sure that the user entered an integer
            try { // try code without braking the program in case an exception is thrown
                option = Integer.parseInt(getInput.nextLine()); // get input, convert to integer,save in option
            } catch (NumberFormatException nfEx) { // if input was no integer, catch specific exception and react accordingly
                System.out.println("Invalid selection"); // print error message
                continue; // skip the rest of iteration (while loop starts from the beginning)
            }

            // second step: make sure that the integer is within the length of the menu
            for (int i = 0; i < x; i++) { // iterate by the number of valid options and increment i by +1
                if (option == i + 1) { // check if selected option matches a valid option
                    System.out.println(); // empty lines for formatting
                    System.out.println();
                    isSet = true; // isSet is true when selected option matches a valid option
                }
            }
            if (!isSet) {
                System.out.println("Invalid selection"); // if selected option does not match a valid option isSet is false and while loop continues
            }
        }
        return option; // return the selected option
    }
}
