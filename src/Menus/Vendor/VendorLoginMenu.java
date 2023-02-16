package Menus.Vendor;

public abstract class VendorLoginMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 2;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("|  Options:                                   |");
        System.out.println("|             1. Login                        |");
        System.out.println("|             2. Back                         |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
