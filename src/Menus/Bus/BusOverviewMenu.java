package Menus.Bus;
import Peaces.Bus;

import java.util.ArrayList;

public class BusOverviewMenu {

    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 3;
    }

    public static void printMenu(ArrayList<Bus> BusList) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Vendor Platform          |");
        System.out.println("=====================================");
        System.out.println("| Bus overview:                     |");
        System.out.println("|–----------------------------------|");

        for (Bus bus : BusList) {
            System.out.printf("|  ID:          %-20s|\n", bus.getId());
            System.out.printf("|  Route:       %-20s|\n", bus.getRoute());
            System.out.printf("|  Date:        %-20s|\n", bus.getDate());
            System.out.printf("|  Time:        %-20s|\n", bus.getTime());
            System.out.printf("|  Capacity:    %-20s|\n", bus.getCapacity());
            System.out.printf("|  Free seats:  %-20d|\n", bus.freeSeats());
            System.out.printf("|  Price (EUR): %-20s|\n", bus.getPrice());
            System.out.println("|–----------------------------------|");
        }

        System.out.println("| Options:                          |");
        System.out.println("|       1. Add Bus                  |");
        System.out.println("|       2. Remove Bus               |");
        System.out.println("|       3. Vendor Menu              |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
