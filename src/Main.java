import menus.*;
import menus.vendor.*;
import menus.vendor.bus.BusManagementMenu;
import menus.vendor.bus.BusOverviewMenu;
import menus.vendor.bus.DeletedBusMenu;
import menus.vendor.bus.NewBusMenu;
import menus.customer.*;
import menus.vendor.route.*;
import systems.*;
import systems.dataInjection.BusInjector;
import systems.dataInjection.RouteInjector;
import systems.dataInjection.UserInjector;
import systems.loginSystem.LoginManager;
import systems.loginSystem.LoginResult;
import components.User;
import components.Bus;
import components.Route;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // global variables
        int menuNr = 0; // used to navigate between menus and systems in the main switch case statement
        int option; // reflects the selected option by the user in each menu
        User currentUser = null; // this is the current user profile (will be set by customer login)
        User newUser = null;
        Bus newBus = null;
        Bus rmvBus = null;
        Bus searchedBus = null;
        Route newRoute = null;
        Route rmvRoute = null;
        Route searchedRoute = null;


        // data injection option
        Scanner getInput = new Scanner(System.in);

        System.out.print("Inject test data? [y/n] ");
        String select = getInput.nextLine();
        System.out.println();

        if (select.equalsIgnoreCase("y")) {
            // inject initial test data
            RouteInjector.injectRoute();
            BusInjector.injectBus();
            UserInjector.injectUser();
        }


        // main program
        boolean run = true; // while run = true the program keeps running, otherwise while loop will be exited
        while (run) {

            // the switch case statement is used to navigation between program menus and systems
            switch (menuNr) { // menuNr determines the selected menu or system
                // case 0  = Start Menu
                // case 1  = Customer Login Menu
                // case 2  = New Customer Profile Menu
                // case 3  = Vendor Login Menu
                // case 4  = Vendor Main Menu
                // case 5  = Bus Management Menu
                // case 6  = Bus Overview Menu
                // case 7  = New Bus Menu
                // case 8  = Deleted Bus Menu
                // case 9  = Route Management Menu
                // case 10 = Route Overview Menu
                // case 11 = New Route Menu
                // case 12 = Deleted Route Menu
                // case 13 = Customer Main Menu
                // case 14 = Available Routes Menu
                // case 15 = Available Busses Menu
                // case 16 = Booking Confirmation Menu
                // case 17 = Ticket History Menu
                // case 18 = All Routes Busses Menu
                // case 19 = Customer Overview Menu
                // case 20 = Transaction Overview Menu

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
                        newUser = CustomerManager.registerUser(); // gets profile details from user and saves new user in the user list
                        menuNr = 2; // go to New User Profile Menu
                    } else if (option == 2) {
                        LoginResult result = LoginManager.login(false);
                        if (result.getUser() != null && result.validation()) {
                            currentUser = result.getUser();
                            menuNr = 13; // Go to customer Main Menu
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
                        currentUser = newUser;
                        menuNr = 13; // go to Customer Main Menu
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
                        LoginResult result = LoginManager.login(true);
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
                        menuNr = 9; // Go to Route Management Menu
                    } else if (option == 2){
                        menuNr = 5; // go to Bus Management Menu
                    } else if (option == 3){
                        if (RouteManager.RouteList.size() < 1) {
                            System.out.println("No routes or busses available");
                            System.out.println();
                        } else {
                            menuNr = 18; // Go to All Routes Busses Menu
                        }
                    } else if (option == 4){
                        if (CustomerManager.TransactionList.size() < 1) {
                            System.out.println("There are currently no recorded transactions");
                            System.out.println();
                        } else {
                            menuNr = 20; // Go to Transaction Overview Menu
                        }
                    } else if (option == 5){
                        if (CustomerManager.UserList.size() < 1) {
                            System.out.println("There are currently no customer registered");
                            System.out.println();
                        } else {
                            menuNr = 19; // Go to Customer Overview Menu
                        }
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
                        if (BusManager.BusList.size() > 0) {
                            menuNr = 6; // Go to Bus Overview Menu
                        } else {
                            System.out.println("No busses found!");
                            System.out.println();
                        }
                    } else if (option == 2){
                        newBus = BusManager.addBus();
                        if (newBus != null) {
                            menuNr = 7; // Go to New Bus Menu
                        }
                    } else if (option == 3){
                        if (BusManager.BusList.size() > 0) {
                            rmvBus = BusManager.removeBus();
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
                    BusOverviewMenu.printMenu(); // prints the menu
                    option = MenuManager.getOption(BusOverviewMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newBus = BusManager.addBus();
                        if (newBus != null) {
                            menuNr = 7; // Go to New Bus Menu
                        } else {
                            menuNr = 5; // Go to Bus Management Menu
                        }
                    } else if (option == 2){
                        rmvBus = BusManager.removeBus();
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
                        newBus = BusManager.addBus();
                        if (newBus == null) {
                            menuNr = 5; // Go to Bus Management Menu
                        }
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
                        if (BusManager.BusList.size() > 0) {
                            rmvBus = BusManager.removeBus();
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
                // Route Management Menu
                case 9 -> {
                    RouteManagementMenu.printMenu(); // prints the menu
                    option = MenuManager.getOption(RouteManagementMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (RouteManager.RouteList.size() > 0) {
                            menuNr = 10; // Go to Route Overview Menu
                        } else {
                            System.out.println("No routes found!");
                            System.out.println();
                        }
                    } else if (option == 2){
                        newRoute = RouteManager.addRoute();
                        if (newRoute != null) {
                            menuNr = 11; // Go to New Route Menu
                        }
                    } else if (option == 3){
                        if (RouteManager.RouteList.size() > 0) {
                            rmvRoute = RouteManager.removeRoute();
                            if (rmvRoute != null) {
                                menuNr = 12; // Deleted Route Menu
                            }
                        } else {
                            System.out.println("No routes found!");
                            System.out.println();
                        }
                    } else {
                        menuNr = 4; // Go to Vendor Main Menu
                    }
                }
                // Route Overview Menu
                case 10 -> {
                    RouteOverviewMenu.printMenu(); // prints the menu
                    option = MenuManager.getOption(RouteOverviewMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newRoute = RouteManager.addRoute();
                        if (newRoute != null) {
                            menuNr = 11; // Go to New Route Menu
                        } else {
                            menuNr = 9; // Go to Route Management Menu
                        }
                    } else if (option == 2){
                        rmvRoute = RouteManager.removeRoute();
                        if (rmvRoute != null) {
                            menuNr = 12; // Go to Deleted Route Menu
                        } else {
                            menuNr = 9; // Go to Route Management Menu
                        }
                    } else {
                        menuNr = 4; // Go to Vendor Main Menu
                    }
                }
                // New Route Menu
                case 11 -> {
                    NewRouteMenu.printMenu(newRoute); // prints the menu
                    option = MenuManager.getOption(NewRouteMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        newRoute = RouteManager.addRoute();
                        if (newRoute == null) {
                            menuNr = 9; // Go to Route Management Menu
                        }
                    } else {
                        menuNr = 9; // Go to Route Management Menu
                    }
                }
                // Deleted Route Menu
                case 12 -> {
                    DeletedRouteMenu.printMenu(rmvRoute); // prints the menu
                    option = MenuManager.getOption(DeletedRouteMenu.getLength());

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (RouteManager.RouteList.size() > 0) {
                            rmvRoute = RouteManager.removeRoute();
                            if (rmvRoute == null) {
                                menuNr = 9; // Go to Route Management Menu
                            }
                        } else {
                            System.out.println("No routes found!");
                            System.out.println();
                            menuNr = 9; // Go to Route Management Menu
                        }
                    } else {
                        menuNr = 9; // Go to Route Management Menu
                    }
                }
                // Customer Main Menu
                case 13 -> {
                    CustomerMainMenu.printMenu(currentUser); // prints Customer Main Menu
                    option = MenuManager.getOption(CustomerMainMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (RouteManager.RouteList.size() < 1) {
                            System.out.println("There are no routes currently available");
                            System.out.println();
                        } else {
                            menuNr = 14; // Go to Available Routes Menu
                        }
                    } else if (option == 2) {
                        if (currentUser.getTicketList().size() < 1) {
                            System.out.println("No tickets in ticket history");
                            System.out.println();
                        } else {
                            menuNr = 17; // Go to Ticket History Menu
                        }
                    } else {
                        currentUser = null; // logout user
                        menuNr = 1; // Go to customer login menu
                    }
                }
                // Available Routes Menu
                case 14 -> {
                    AvailableRoutesMenu.printMenu(); // prints the Available Routes Menu
                    option = MenuManager.getOption(AvailableRoutesMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        if (BusManager.BusList.size() < 1) {
                            System.out.println("There are currently no busses available");
                            System.out.println();
                            menuNr = 13; // Go to Customer Main Menu
                        } else {
                            searchedRoute = CustomerManager.searchRoute();
                            if (searchedRoute != null) {
                                menuNr = 15; // Go to Available Busses Menu
                            } else {
                                menuNr = 13; // Go to Customer Main Menu
                            }
                        }
                    }
                }
                // Available Busses Menu
                case 15 -> {
                    AvailableBussesMenu.printMenu(searchedRoute); // prints the Available Busses Menu
                    option = MenuManager.getOption(AvailableBussesMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // book bus via UserManager
                        searchedBus = CustomerManager.searchBus(searchedRoute);
                        if (searchedBus != null) {
                            menuNr = 16; // Go to Booking Confirmation Menu
                        } else {
                            menuNr = 13; // Go to Customer Main Menu
                        }
                    } else {
                        menuNr = 13; // Go to Customer Main menu
                    }
                }
                // Booking Confirmation Menu
                case 16 -> {
                    BookingConfirmationMenu.printMenu(searchedBus); // prints the Booking Confirmation Menu
                    option = MenuManager.getOption(BookingConfirmationMenu.getLength()); // gets option from user and sets option variable accordingly

                    // navigate to next menu or system according to selected option
                    if (option == 1) {
                        // book new ticket
                        CustomerManager.bookTicket(currentUser, searchedBus);
                        System.out.println("Booking confirmed");
                        System.out.println();
                    }
                    menuNr = 13; // Go to Customer Main Menu
                }
                // Ticket History Menu
                case 17 -> {
                    if (currentUser.getTicketList().size() > 1) {
                        Collections.sort(currentUser.getTicketList()); // sort user ticket list by departure date
                    }
                    TicketHistoryMenu.printMenu(currentUser); // prints the Ticket History
                    MenuManager.getOption(TicketHistoryMenu.getLength()); // prompts user for option in order to continue

                    // Go to Customer Main menu
                    menuNr = 13; // Go to Customer Main Menu
                }
                // All Routes Busses Menu
                case 18 -> {
                    AllRoutesBussesMenu.printMenu(); // prints menu
                    MenuManager.getOption(AllRoutesBussesMenu.getLength()); // prompts user for option in order to continue

                    // Go to Customer Main menu
                    menuNr = 4; // Go to Vendor Main Menu
                }
                // Customer Overview Menu
                case 19 -> {
                    CustomerOverviewMenu.printMenu(); // prints menu
                    MenuManager.getOption(CustomerOverviewMenu.getLength()); // prompts user for option in order to continue

                    // Go to Customer Main menu
                    menuNr = 4; // Go to Vendor Main Menu
                }
                // Customer Overview Menu
                case 20 -> {
                    if (CustomerManager.TransactionList.size() > 1) {
                        Collections.sort(CustomerManager.TransactionList); // sort transaction list by date
                    }
                    TransactionOverviewMenu.printMenu(); // prints menu
                    MenuManager.getOption(TransactionOverviewMenu.getLength()); // prompts user for option in order to continue

                    // Go to Customer Main menu
                    menuNr = 4; // Go to Vendor Main Menu
                }
            }
        }
        System.out.println("Shutdown, goodbye!"); // message when program gets terminated
    }
}
