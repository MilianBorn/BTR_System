package systems;

import components.Bus;
import components.Route;
import components.Transaction;
import components.User;

import java.util.ArrayList;
import java.util.Scanner;

public class RouteManager { // this class is used to handle any tasks related to routes
    public final static ArrayList<Route> RouteList = new ArrayList<>();

    public static Route addRoute() { // add a new route
        Scanner getInput = new Scanner(System.in);
        Route newRoute = new Route();

        System.out.print("Origin: ");
        newRoute.setOrigin(getInput.nextLine());

        System.out.print("Destination: ");
        newRoute.setDestination(getInput.nextLine());

        for (Route route : RouteList) {
            if (route.getOrigin().equalsIgnoreCase(newRoute.getOrigin()) && route.getDestination().equalsIgnoreCase(newRoute.getDestination())) {
                System.out.println();
                System.out.println("Route already exists");
                System.out.println();
                return null;
            }
        }

        String newId = newRoute.getOrigin() + " -> " + newRoute.getDestination();
        newRoute.setId(newId);

        RouteList.add(newRoute);
        return newRoute;
    }

    public static Route removeRoute() { // remove an existing route
        Scanner getInput = new Scanner(System.in);
        Route rmvRoute = null;

        boolean isFound = false;
        while (!isFound) {
            System.out.print("Origin: "); // get origin
            String origin = getInput.nextLine();
            System.out.print("Destination: "); // get destination
            String destination = getInput.nextLine();

            // search for route
            for (Route route : RouteList) {
                if (route.getOrigin().equalsIgnoreCase(origin) && route.getDestination().equalsIgnoreCase(destination)) {
                    rmvRoute = route;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Route ID not found");
                System.out.print("Try again? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave search if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
        if (isFound) {
            for (Bus bus : rmvRoute.getAssignedBusses()) {
                BusManager.BusList.remove(bus); // remove busses that are assigned to route
                bus.setStatus(false); // indicate that the bus was cancelled

                // create transactions of type cancellations for all affected user tickets
                for (User user : bus.getPassengerList()) {
                    Transaction cancellation = new Transaction(user, bus, false);
                    CustomerManager.TransactionList.add(cancellation);
                }
            }
            RouteList.remove(rmvRoute); // remove route
            return rmvRoute;

        } else {
            return null;
        }
    }
}
