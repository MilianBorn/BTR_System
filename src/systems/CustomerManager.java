package systems;

import components.Bus;
import components.Route;
import components.Transaction;
import components.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class CustomerManager { // this class is used to for any logic needed to handle user tasks
    public final static ArrayList<User> UserList = new ArrayList<>(); // this is the user list
    public final static ArrayList<Transaction> TransactionList = new ArrayList<>(); // this is the global transaction list from customers

    public static User registerUser() { // method to register a new user and add them to the user list
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);
        // create user object
        User newUser = new User();

        // prompt the user for input and saves information in customer (User object)
        System.out.print("First name: ");
        newUser.setFname(getInput.nextLine());
        System.out.print("Last name: ");
        newUser.setLname(getInput.nextLine());

        // set date of birth
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate newDate;
        boolean isSet = false;
        while (!isSet) {
            System.out.print("Date of birth (dd.mm.yy): ");
            String dateString = getInput.nextLine();
            try {
                newDate = LocalDate.parse(dateString, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format");
                continue;
            }
            newUser.setDob(newDate);
            isSet = true;
        }

        // set email
        System.out.print("Email: ");
        newUser.setEmail(getInput.nextLine());

        // set username and check for duplicates in UserList (username must be unique)
        while (true) { // while loop is always true and is exited by break statement

            boolean isUnique = true; // used to track if the username is unique (assumption = true)

            // set up username
            System.out.print("Username: "); // prompt for username
            newUser.setUsername(getInput.nextLine()); // set username

            // check if username is unique
            for (User user : UserList) { // repeat for each User in UserList
                if (newUser.getUsername().equals(user.getUsername())) { // check if new username equals username from UserList
                    System.out.println("Username already exists"); // inform user that username is not unique
                    System.out.println(); // empty line for formatting
                    isUnique = false; // assumption = false, username is not unique
                }
            }
            if (isUnique) { // only exit the while loop when username is unique
                break;
            }
        }

        // set up password
        System.out.print("Password: "); // prompt for password
        newUser.setPassword(getInput.nextLine()); // read user input
        System.out.println(); // empty lines for formatting
        System.out.println();

        // append newUser to user list
        UserList.add(newUser);
        return newUser;
    }
    public static Route searchRoute() { // search routes as user

        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);

        // search routes
        Route searchedRoute = null;
        boolean isFound = false;
        while(!isFound) {
            System.out.println();
            System.out.print("Origin: ");
            String origin = getInput.nextLine();
            System.out.print("Destination: ");
            String destination = getInput.nextLine();

            for (Route route : RouteManager.RouteList) {
                if (origin.equalsIgnoreCase(route.getOrigin()) && destination.equalsIgnoreCase(route.getDestination())) {
                    searchedRoute = route;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Route does not exist");
                System.out.print("Try again? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave system if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    return null;
                }
            } else if (searchedRoute.getAssignedBusses().size() < 1) {
                isFound = false;
                System.out.println("Route has currently no busses available");
                System.out.print("Select another route? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave system if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    return null;
                }
            }
        }
        return searchedRoute;
    }

    public static Bus searchBus(Route searchedRoute) { // search busses uas user

        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);

        // search busses in buss list
        Bus searchedBus = null;
        boolean isFound = false;
        while(!isFound) {
            System.out.println();
            System.out.print("Bus ID: ");
            String id = getInput.nextLine();

            for (Bus bus : searchedRoute.getAssignedBusses()) {
                if (id.equalsIgnoreCase(bus.getId())) {
                    searchedBus = bus;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Bus does not exist");
                System.out.print("Try again? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave system if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    return null;
                }
            } else if (searchedBus.freeSeats() < 1) {
                isFound = false;
                System.out.println("Bus has no free seats available");
                System.out.print("Select another route? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave system if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    return null;
                }
            }
        }
        return searchedBus;
    }
    public static void bookTicket(User user, Bus bus) {
        user.addTicket(bus); // add bus to user ticket list
        bus.addPassenger(user); // add passenger to bus
        Transaction newTransaction = new Transaction(user, bus, true); // create new transaction
        CustomerManager.TransactionList.add(newTransaction); // add transaction to transaction list
    }
}
