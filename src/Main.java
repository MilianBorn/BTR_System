import Menus.*;
import Menus.Bus.BusManagementMenu;
import Menus.Bus.BusOverviewMenu;
import Menus.Bus.DeletedBusMenu;
import Menus.Bus.NewBusMenu;
import Menus.Customer.CustomerLoginMenu;
import Menus.Customer.NewUserProfileMenu;
import Menus.Vendor.VendorLoginMenu;
import Menus.Vendor.VendorMainMenu;
import Systems.*;
import Systems.DataInjection.BusInjector;
import Systems.DataInjection.UserInjector;
import Systems.LoginSystem.LoginManager;
import Systems.LoginSystem.LoginResult;
import Peaces.User;
import Peaces.Bus;

public class Main {

    public static void main(String[] args) {
        // global variables
        int menuNr = 0; // used to navigate between menus and systems in the main switch case statement
        int option; // reflects the selected option by the user in each menu
        User currentUser = null; // this is the current user profile (will be set by customer login)
        User newUser = null;
        Bus newBus = null;
        Bus rmvBus = null;

        // initiate the array lists
        UserRegistration userRegistration = new UserRegistration(); // create an instance of the class UserRegistration (contains the user array list)
        BusManager busManager = new BusManager(); // create an instance of the class BusManager (contains the bus array list)

        // inject initial data
        UserInjector userInjector = new UserInjector();
        userRegistration.UserList = userInjector.injectUser();
        BusInjector busInjector = new BusInjector();
        busManager.BusList = busInjector.injectBus();

        // main program
        boolean run = true; // while run = true the program keeps running, otherwise while loop will be exited
        while (run) {

            // the switch case statement is used to navigation between program menus and systems
            switch (menuNr) { // menuNr determines the selected menu or system
                // case 0 = Start Menu
                // case 1 = Customer Login Menu
                // case 2 = New Customer Profile Menu
                // case 3 = Vendor Login Menu
                // case 4 = Vendor Main Menu
                // case 5 = Bus Management Menu
                // case 6 = Bus Overview Menu
                // case 7 = New Bus Menu
                // case 8 = Deleted Bus Menu

                // Start Menu
                case 0 -> {
                    StartMenu.printMenu(); // prints the Start Menu
                    option = MenuManager.getOption(StartMenu.getLength()); // gets option from user and sets option variable accordingly

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
                    option = MenuManager.getOption(CustomerLoginMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newUser = userRegistration.register(); // gets profile details from user and saves new user in the user list
                        menuNr = 2; // go to New User Profile Menu
                    } else if (option == 2) {
                        LoginResult result = LoginManager.login(userRegistration.UserList, false);
                        if (result.getUser() != null && result.validation()) {
                            currentUser = result.getUser();
                            // Todo: Varsha -> Customer Main Menu
                        }
                    } else {
                        menuNr = 0; // go to Start Menu
                    }
                }

                // New User Profile Menu
                case 2 -> {
                    NewUserProfileMenu.printMenu(newUser); // print New User Profile Menu
                    option = MenuManager.getOption(NewUserProfileMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // Todo: Varsha -> Customer Main Menu
                    } else if (option == 2) {
                        newUser = userRegistration.register(); //1 gets profile details from user and saves new user in the user list // menuNr does not need to be changed
                    } else {
                        menuNr = 1; // go to Customer Login Menu
                    }
                }

                // Vendor Login Menu
                case 3 -> {
                    VendorLoginMenu.printMenu(); // prints the Vendor Login Menu
                    option = MenuManager.getOption(VendorLoginMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        LoginResult result = LoginManager.login(userRegistration.UserList, true);
                        if (result.validation()) {
                            menuNr = 4;
                        }
                    } else {
                        menuNr = 0; // go to Start Menu
                    }
                }
                // Vendor Main Menu
                case 4 -> {
                    VendorMainMenu.printMenu(); // prints the menu
                    option = MenuManager.getOption(VendorMainMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // ToDo: Route Management Menu
                    } else if (option == 2){
                        menuNr = 5; // go to Bus Management Menu
                    } else if (option == 3){
                        // ToDo: Print busses and routes
                    } else if (option == 4){
                        // ToDo: Print Transaction history
                    } else if (option == 5){
                        // ToDo: Print registered customers
                    } else {
                        menuNr = 0; // Go to start menu
                    }
                }
                // Bus Management Menu
                case 5 -> {
                    BusManagementMenu.printMenu(); // prints the menu
                    option = MenuManager.getOption(BusManagementMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (busManager.BusList.size() > 0) {
                            menuNr = 6; // Go to Bus Overview Menu
                        } else {
                            System.out.println("No busses found!");
                            System.out.println();
                        }
                    } else if (option == 2){
                        newBus = busManager.addBus();
                        menuNr = 7; // Go to New Bus Menu
                    } else if (option == 3){
                        if (busManager.BusList.size() > 0) {
                            rmvBus = busManager.removeBus();
                            if (rmvBus != null) {
                                menuNr = 8; // Deleted Bus Menu
                            }
                        } else {
                            System.out.println("No busses found!");
                            System.out.println();
                        }
                    } else {
                        menuNr = 4; // Go to Vendor Main Menu
                    }
                }
                // Bus Overview Menu
                case 6 -> {
                    BusOverviewMenu.printMenu(busManager.BusList); // prints the menu
                    option = MenuManager.getOption(BusOverviewMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newBus = busManager.addBus();
                        menuNr = 7; // Go to New Bus Menu
                    } else if (option == 2){
                        rmvBus = busManager.removeBus();
                        if (rmvBus != null) {
                            menuNr = 8; // Go to Deleted Bus Menu
                        } else {
                            menuNr = 5; // Go to Bus Management Menu
                        }
                    } else {
                        menuNr = 4; // Go to Vendor Main Menu
                    }
                }
                // New Bus Menu
                case 7 -> {
                    NewBusMenu.printMenu(newBus); // prints the menu
                    option = MenuManager.getOption(NewBusMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newBus = busManager.addBus();
                    } else {
                        menuNr = 5; // Go to Bus Management Menu
                    }
                }
                // Deleted Bus Menu
                case 8 -> {
                    DeletedBusMenu.printMenu(rmvBus); // prints the menu
                    option = MenuManager.getOption(DeletedBusMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (busManager.BusList.size() > 0) {
                            rmvBus = busManager.removeBus();
                            if (rmvBus == null) {
                                menuNr = 5; // Go to Bus Management Menu
                            }
                        } else {
                            System.out.println("No busses found!");
                            System.out.println();
                            menuNr = 5; // Go to Bus Management Menu
                        }
                    } else {
                        menuNr = 5; // Go to Bus Management Menu
                    }
                }
            }
        }
        System.out.println("Shutdown, goodbye!"); // message when program gets terminated
    }
}
