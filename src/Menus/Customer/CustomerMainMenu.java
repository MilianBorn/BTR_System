package Menus.Customer;

public class CustomerMainMenu {
    // ToDo: Varsha -> write customer main menu
    public static int length = 3; // reflects the number of available options (used for getOption method in MenuManager class)
    public static void printMenu() { // method to print the menu
        System.out.println("=====================================");
        System.out.println("|    Bus Ticket Reservation System  |");
        System.out.println("|   -----------------------------   |");
        System.out.println("|          Customer Management      |");
        System.out.println("=====================================");
        System.out.println("| Options:                          |");
        System.out.println("|            1. Search Routes       |");
        System.out.println("|            2. Ticket History      |");
        System.out.println("|            3. Logout              |");
        System.out.println("=====================================");
    }
}
