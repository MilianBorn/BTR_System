import Menus.NewUserProfileMenu;
import Systems.MenuManager;
import Systems.UserRegistration;
import Menus.CustomerLoginMenu;
import Menus.StartMenu;
import Menus.VendorLoginMenu;
import Peaces.User;

public class Main {

    public static void main(String[] args) {
        // global variables
        int menuNr = 0; // used to navigate between menus and systems in the main switch case statement
        int option; // reflects the selected option by the user in each menu

        // initiate user list (ArrayList)
        UserRegistration UserMgmt = new UserRegistration(); // create an instance of the class UserManager (contains the user array list)

        // main program
        boolean run = true; // while run = true the program keeps running, otherwise while loop will be exited
        while (run) {

            // the switch case statement is used to navigation between program menus and systems
            switch (menuNr) { // menuNr determines the selected menu or system
                // case 0 = Start Menu
                // case 1 = Customer Login Menu
                // case 2 = New Customer Profile Menu
                // case 3 = Vendor Login Menu
                // ToDo: determine all required menus and assign them a menuNr (use meaningful system)

                // Start Menu
                case 0 -> {
                    StartMenu.printMenu(); // prints the Start Menu
                    option = MenuManager.getOption(StartMenu.length); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        menuNr = 1; // go to Customer Login Menu
                    } else if (option == 2) {
                        menuNr = 3; // go to Vendor Login Menu
                    } else {
                        run = false; // exit the program
                    }
                }

                // Customer Login Menu
                case 1 -> {
                    CustomerLoginMenu.printMenu(); // prints Customer Login Menu
                    option = MenuManager.getOption(CustomerLoginMenu.length); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        UserMgmt.register(); // gets profile details from user and saves new user in the user list
                        menuNr = 2; // go to New User Profile Menu
                    } else if (option == 2) {
                        // ToDo: User Login System
                    } else {
                        menuNr = 0; // go to Start Menu
                    }
                }

                // New User Profile Menu
                case 2 -> {
                    // user list can't be empty when trying to access the last element because index will be -1 (causes an exception)
                    if (!UserMgmt.UserList.isEmpty()) { // checks the user list is not empty
                        User newUser = UserMgmt.UserList.get(UserMgmt.UserList.size() - 1); // access last element in user list and save it as newUser
                        NewUserProfileMenu.printMenu(newUser); // print New User Profile Menu
                        option = MenuManager.getOption(NewUserProfileMenu.length); // gets option from user and sets option variable accordingly
                    } else { // when user list is empty
                        System.out.println("User list is empty"); // print error
                        option = 3; // set hardcoded option in case that user list is empty
                    }

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // Todo: Customer Main Menu;
                    } else if (option == 2) {
                        UserMgmt.register(); // gets profile details from user and saves new user in the user list // menuNr does not need to be changed
                    } else {
                        menuNr = 1; // go to Customer Login Menu
                    }
                }

                // Vendor Login Menu
                case 3 -> {
                    VendorLoginMenu.printMenu(); // prints the Vendor Login Menu
                    option = MenuManager.getOption(VendorLoginMenu.length); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // ToDo: User Login System;
                    } else {
                        menuNr = 0; // go to Start Menu
                    }
                }
            }
        }
        System.out.println("Shutdown, goodbye!"); // message when program gets terminated
    }
}
