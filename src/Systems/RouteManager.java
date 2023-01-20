package Systems;

import Peaces.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteManager {
    // ToDo: Varsha -> Route Manager

    // The route manager should include an array list to store Route objects (see UserRegistration)

    // The route manager has three functionalities (3 methods):
    // 1. List available routes
    // 2. Add routes (source, destination, optional unique ID)
    // 3. Remove routes

    public ArrayList<Route> RouteList = new ArrayList<>();

    public Route addRoute() {
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

    public Route removeRoute() {
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
            RouteList.remove(rmvRoute);
            return rmvRoute;

        } else {
            return null;
        }


    }
}
