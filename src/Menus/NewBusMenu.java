package Menus;
import Peaces.Bus;

public class NewBusMenu {
    public static int length = 2; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu(Bus newBus) { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Vendor Platform          |");
        System.out.println("=====================================");
        System.out.println("| New bus added:                    |");
        System.out.println("|–----------------------------------|");
        System.out.printf("|  ID:         %-21s|\n", newBus.id);
        System.out.printf("|  Route:      %-21s|\n", newBus.route);
        System.out.printf("|  Date:       %-21s|\n", newBus.date);
        System.out.printf("|  Time:       %-21s|\n", newBus.time);
        System.out.printf("|  Capacity:   %-21s|\n", newBus.capacity);
        System.out.printf("|  Price:      %-21s|\n", newBus.price);
        System.out.println("|–----------------------------------|");
        System.out.println("| Options:                          |");
        System.out.println("|       1. Add another bus          |");
        System.out.println("|       2. Back to bus management   |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
