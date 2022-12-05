import Menus.NewUserProfileMenu;
import Systems.MenuManager;
import Systems.UserManager;
import Menus.CustomerLoginMenu;
import Menus.StartMenu;
import Menus.VendorLoginMenu;
import Peaces.User;

public class Main {

    public static void main(String[] args) {
        // global variables
        int menuNr = 0;
        int option;
        // set up user management (user list in particular)
        UserManager UserMgmt = new UserManager();
        // make program continue as long run is set to true
        boolean run = true;
        while (run) {
            // navigation between program modules / menus
            switch (menuNr) {
                // Start Menu
                case 0 -> {
                    StartMenu.printMenu();
                    option = MenuManager.getOption(StartMenu.length);
                    if (option == 1) {
                        menuNr = 1; // Customer Login Menu
                    } else if (option == 2) {
                        menuNr = 3; // Vendor Login Menu
                    } else {
                        run = false; // Exit
                    }
                }
                // Customer Login Menu
                case 1 -> {
                    CustomerLoginMenu.printMenu();
                    option = MenuManager.getOption(CustomerLoginMenu.length);
                    if (option == 1) {
                        UserMgmt.register(); // User Registration System -> registers new user
                        menuNr = 2; // New User Profile Menu
                    } else if (option == 2) {
                        // ToDo: User Login System
                    } else {
                        menuNr = 0; // Start Menu
                    }
                }
                // New User Profile Menu
                case 2 -> {
                    if (!UserMgmt.UserList.isEmpty()) {
                        User newUser = UserMgmt.UserList.get(UserMgmt.UserList.size() - 1); // access last element in user list
                        NewUserProfileMenu.printMenu(newUser); // print menu
                        option = MenuManager.getOption(NewUserProfileMenu.length);
                    } else {
                        System.out.println("User list is empty");
                        option = 3; // Customer Login Menu
                    }
                    if (option == 1) {
                        // Todo: Customer Main Menu;
                    } else if (option == 2) {
                        UserMgmt.register(); // User Registration System -> registers new user
                    } else {
                        menuNr = 1; // Customer Login Menu
                    }
                }
                // Vendor Login Menu
                case 3 -> {
                    VendorLoginMenu.printMenu();
                    option = MenuManager.getOption(VendorLoginMenu.length);
                    if (option == 1) {
                        // ToDo: User Login System;
                    } else {
                        menuNr = 0; // Start Menu
                    }
                }
            }
        }
        System.out.println("Shutdown, goodbye!");
    }
}
