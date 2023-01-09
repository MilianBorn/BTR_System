package Menus;
import Peaces.Bus;

public class DeletedBusMenu {
    public static int length = 2; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu(Bus rmvBus) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Vendor Platform          |");
        System.out.println("=====================================");
        System.out.println("| Bus removed:                      |");
        System.out.println("|–----------------------------------|");
        System.out.printf("|  UID:        %-21s|\n", rmvBus.id);
        System.out.printf("|  Route:      %-21s|\n", rmvBus.route);
        System.out.printf("|  Date:       %-21s|\n", rmvBus.date);
        System.out.printf("|  Time:       %-21s|\n", rmvBus.time);
        System.out.printf("|  Capacity:   %-21s|\n", rmvBus.capacity);
        System.out.printf("|  Cancelled:  %-21s|\n", rmvBus.capacity - rmvBus.freeSeats());
        System.out.printf("|  Price:      %-21s|\n", rmvBus.price);
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Remove another bus       |");
        System.out.println("|       2. Back to bus management   |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
