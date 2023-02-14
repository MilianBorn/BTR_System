package Menus.Vendor;
import Components.Transaction;
import Menus.Menu;
import Systems.CustomerManager;

import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;

public class TransactionOverviewMenu implements Menu {
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

        for ( Transaction transaction : CustomerManager.TransactionList) {
            System.out.printf("| Date:           %-20s|\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(transaction.getDate()));
            System.out.println("|                                         |");
            System.out.println("| User                                    |");
            System.out.printf("| First name:     %-20s|\n", transaction.getUser().getFname());
            System.out.printf("| Last name:      %-20s|\n", transaction.getUser().getLname());
            System.out.printf("| Username:       %-20s|\n", transaction.getUser().getUsername());
            System.out.println("|                                         |");
            System.out.println("| Bus Ticket                              |");
            System.out.printf("| ID:             %-20s|\n", transaction.getTicket().getId());
            System.out.printf("| Route:          %-20s|\n", transaction.getTicket().getRoute().getId());
            System.out.printf("| Price (EUR):    %-20.2f|\n", transaction.getTicket().getPrice());
            System.out.println("|–----------------------------------------|");
        }

        System.out.println("|      Options:                               |");
        System.out.println("|            1. Vendor Menu                   |");
        System.out.println("|                                             |");
        System.out.println("===============================================");
    }
}
