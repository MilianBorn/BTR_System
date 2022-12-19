package Menus;

public class VendorMainMenu {
    public static int length = 6;   // reflects the number of available options
    public static void printMenu() { // method to print the menu
        System.out.println("======================================");
        System.out.println("|   Bus Ticket Reservation System    |");
        System.out.println("|   ------------------------------   |");
        System.out.println("|        Vendor Main  Menu           |");
        System.out.println("======================================");
        System.out.println("| Options:                           |");
        System.out.println("|       1. Manage Routes             |");
        System.out.println("|       2. Manage Busses             |");
        System.out.println("|       3. Overview Busses & Routes  |");
        System.out.println("|       4. Transaction History       |");
        System.out.println("|       5. Registered Customers      |");
        System.out.println("|       6. Log Out (Main Menu)       |");
        System.out.println("|                                    |");
        System.out.println("======================================");
    }
}
