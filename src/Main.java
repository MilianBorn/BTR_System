import Menus.CustomerLoginMenu;
import Menus.StartMenu;
import Menus.VendorLoginMenu;

public class Main {

    public static void main(String[] args) {
        // global variables
        int menuNr = 0;
        int option;
        // set up user management
        UserManager UserMgmt = new UserManager();
        // make program continue as long run is set to true
        boolean run = true;
        while (run) {
            // navigation between program modules / menus
            switch (menuNr) {
                // Start Menu
                case 0:
                    StartMenu.printMenu();
                    option = MenuManager.getOption(StartMenu.length);
                    if (option == 1) {
                        menuNr = 1; // Customer Login System
                    } else if (option == 2) {
                        menuNr = 2; // Vendor Login System
                    } else {
                        run = false; // Exit
                    }
                    break;
                // Customer Login Menu
                case 1:
                    CustomerLoginMenu.printMenu();
                    option = MenuManager.getOption(CustomerLoginMenu.length);
                    if (option == 1) {
                        UserMgmt.register();
                    } else if (option == 2) {
                        // User Login System
                    } else {
                        menuNr = 0; // Start Menu
                    }
                    break;
                // Vendor Login Menu
                case 2:
                    VendorLoginMenu.printMenu();
                    option = MenuManager.getOption(VendorLoginMenu.length);
                    if (option == 1) {
                        // User Login System;
                    } else {
                        menuNr = 0; // Start Menu
                    }
                    break;
            }
        }
    }
}
