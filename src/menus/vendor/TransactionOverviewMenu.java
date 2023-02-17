package menus.vendor;
import components.transactions.Transaction;
import systems.CustomerManager;

import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;

public class TransactionOverviewMenu {
    public static int getLength() {
        // reflects the number of available options (used for getOption method in MenuManager class)
        return 1;
    }
    public static void printMenu() { // method to print the menu
        System.out.println("===============================================");
        System.out.println("|        Bus Ticket Reservation System        |");
        System.out.println("|   ---------------------------------------   |");
        System.out.println("|               Vendor Platform               |");
        System.out.println("===============================================");
        System.out.println("| Transaction overview:                       |");
        System.out.println("|–--------------------------------------------|");

        // print all transactions
        for ( Transaction transaction : CustomerManager.TransactionList) {
            System.out.printf("| Type:           %-37s|\n", transaction.toString());
            System.out.printf("| Date:           %-28s|\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(transaction.getDate()));
            System.out.println("|                                             |");
            System.out.println("| User                                        |");
            System.out.printf("| First name:     %-28s|\n", transaction.getUser().getFname());
            System.out.printf("| Last name:      %-28s|\n", transaction.getUser().getLname());
            System.out.printf("| Username:       %-28s|\n", transaction.getUser().getUsername());
            System.out.println("|                                             |");
            System.out.println("| Bus Ticket                                  |");
            System.out.printf("| ID:             %-28s|\n", transaction.getTicket().getId());
            System.out.printf("| Route:          %-28s|\n", transaction.getTicket().getRoute().getId());
            System.out.printf("| Price (EUR):    %-28.2f|\n", transaction.getTicket().getPrice());
            System.out.println("|–--------------------------------------------|");
        }

        System.out.println("|  Options:                                   |");
        System.out.println("|            1. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}