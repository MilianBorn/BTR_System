package systems.dataInjection;

import components.Route;
import systems.RouteManager;

// this class is used to inject a number of routes into the program when its started
public class RouteInjector {
    private static final String[] route_origin = setRoute_origin();
    private static final String[] route_destination = setRoute_destination();
    private static final String[] route_id = setRoute_id();

    // setters
    private static String[] setRoute_origin() {
        return new String[] {"Berlin", "Munich", "Hamburg", "Koeln"};
    }
    private static String[] setRoute_destination() {
        return new String[] {"Munich", "Berlin", "Koeln", "Hamburg"};
    }
    private static String[] setRoute_id() {
        String[] id = new String[4];
        for (int i = 0; i < 4; i++) {
            id[i] = route_origin[i] + " -> " + route_destination[i];
        }
        return id;
    }

    public static void injectRoute() {  // inject routes
        for (int i = 0; i < 4; i++) {
            Route newRoute = new Route();
            newRoute.setOrigin(route_origin[i]);
            newRoute.setDestination(route_destination[i]);
            newRoute.setId(route_id[i]);

            RouteManager.RouteList.add(newRoute); // add new route to route list
        }
    }

}
