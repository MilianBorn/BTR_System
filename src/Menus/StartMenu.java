package Menus;

public class StartMenu {
    public static int length = 3; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu() { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|   Bus Ticket Reservation System   |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|             Main Menu             |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. Customer platform   |");
        System.out.println("|            2. Vendor platform     |");
        System.out.println("|            3. Exit                |");
        System.out.println("|                                   |");
        System.out.println("=====================================");
    }
}
