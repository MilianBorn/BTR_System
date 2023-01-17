package Menus.Route;

import Peaces.Route;

import java.util.ArrayList;


public class NewRouteProfile {
    public static int length = 2; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printRouteMenu(ArrayList<Route> RouteList) { // method to print the menu
        //Route newRoute = new Route();
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|         New Route Profile         |");
        System.out.println("=====================================");
        System.out.println("| Details:                          |");
        for (Route route : RouteList) {
            System.out.println("|–----------------------------------|");
            System.out.printf("   ID:    %s\n", route.id);
            System.out.printf("   Source:    %s\n", route.source);     // print Route details
            System.out.printf("   Destination:     %s\n", route.Destination);
        }
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Register another Route   |");
        System.out.println("|       2. Back to menu             |");
        System.out.println("|                                   |");
        System.out.println("=====================================");

    }

}
