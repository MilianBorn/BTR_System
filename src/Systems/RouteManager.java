package Systems;

import Peaces.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RouteManager {
    // ToDo: Varsha -> Route Manager

    // The route manager should include an array list to store Route objects (see UserRegistration)

    // The route manager has three functionalities (3 methods):
    // 1. List available routes
    // 2. Add routes (source, destination, optional unique ID)
    // 3. Remove routes
    /* HashMap<String, ArrayList<Route>> Routemap = new HashMap<String, ArrayList<Route>>();
    public ArrayList<Route> destinationList = new ArrayList<>();

    public HashMap<String, ArrayList<Route>> addnewroute (){
        Scanner getInput = new Scanner(System.in);

        Route newRoute = new Route();

        System.out.print("Enter Source:");
        newRoute.source= getInput.nextLine();
        System.out.print("Enter destination");
        newRoute.destination=getInput.nextLine();

        destinationList.add(newRoute);
        Routemap.put(newRoute.source,destinationList);

        return Routemap;
*/
    //toDO: check for unique values


    public List<Route> RouteList = new ArrayList<Route>();

    public Route addRoute() {
        Scanner getInput = new Scanner(System.in);
        Route newRoute = new Route();

        String newId = UUID.randomUUID().toString();
        newRoute.id = newId.substring(0, 8);
        System.out.println("Enter Source:");
        newRoute.source = getInput.nextLine();

        System.out.println("Enter destination");
        newRoute.Destination = getInput.nextLine();

        RouteList.add(newRoute);
        return newRoute;


    }

    public Route deleteRoute() {
        Scanner getInput = new Scanner(System.in);
        Route removeRoute = null;
        boolean isFound = false;
        while (!isFound) {
            System.out.println("Enter Route ID:"); // get id
            String id = getInput.nextLine();

            // search for route
            for (Route route : RouteList) {
                if (route.id.equals(id)) {
                    removeRoute = route;
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
            Route rmvRoute = removeRoute;
            RouteList.removeIf(route -> route.id.equals(rmvRoute.id));
            return rmvRoute;

        } else {
            return null;
        }


    }
}
