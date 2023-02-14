package Systems.DataInjection;

import Components.Bus;
import Components.Transaction;
import Components.User;
import Systems.BusManager;
import Systems.CustomerManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.OptionalLong;
import java.util.concurrent.ThreadLocalRandom;

// this lass is used to inject a number of users into the program when its started
public  class UserInjector {
    private static final String[] user_fname = setUser_fname();
    private static final String[] user_lname = setUser_lname();
    private static final LocalDate[] user_dob = setUser_dob();
    private static final String[] user_email = setUser_email();
    private static final String[] user_username = setUser_username();
    private static final String user_password = setUser_password();

    private static final ArrayList<ArrayList<Bus>> user_tickets = setUser_tickets();

    private static String[] setUser_fname() {
        return new String[] {"Michael", "Christopher", "Jessica", "Matthew", "Ashley",
                "Jennifer", "Joshua", "Amanda", "Daniel", "David"};
    }
    private static String[] setUser_lname() {
        return new String[] {"Smith", "Johnson", "Williams", "Brown", "Jones",
                "Miller", "Davis", "Wilson", "Anderson", "Taylor"};
    }
    private static LocalDate[] setUser_dob() {
        LocalDate[] dob = new LocalDate[10];
        LocalDate startDate = LocalDate.of(1990, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.of(2000, 1, 1); //end date
        long end = endDate.toEpochDay();

        for (int i = 0; i < 10; i++) {
            OptionalLong randomEpochDayOl = ThreadLocalRandom.current().longs(start, end).findAny();
            if (randomEpochDayOl.isPresent()) {
                long randomEpochDay = randomEpochDayOl.getAsLong();
                dob[i] = LocalDate.ofEpochDay(randomEpochDay);
            }
        }
        return dob;
    }
    private static String[] setUser_email() {
        String[] email = new String[10];
        for (int i = 0; i < 10; i++) {
            email[i] = user_fname[i].toLowerCase() + '.' + user_lname[i].toLowerCase() + "@mail.com";
        }
        return email;
    }
    private static String[] setUser_username() {
        return new String[] {"AnthraX", "AmbientTech", "Best_Name_Ever", "Scarface", "SilverLady",
                "TravelLust", "Retro_Reactive", "Brains&Beauty", "Exodus", "Angus"};
    }
    private static String setUser_password() {
        return "password";
    }

    private static ArrayList<ArrayList<Bus>> setUser_tickets() {
        ArrayList<ArrayList<Bus>> userTickets = new ArrayList<>();

        // create 10 ticket lists for all users
        for (int i = 0; i < 10; i++) {
            ArrayList<Bus> ticketList = new ArrayList<>();
            // add two random busses per ticket list
            for (int n = 0; n < 2; n++) {
                int index = (int) (Math.random() * BusManager.BusList.size()); // random index from bus list
                ticketList.add(BusManager.BusList.get(index)); // add bus to ticket list
            }
            userTickets.add(ticketList);
        }
        return userTickets;
    }


    public static void injectUser() {
        for (int i = 0; i < 10; i++) {
            User newUser = new User() {
                @Override
                public boolean isAdmin() {
                    return false;
                }
            };
            newUser.setFname(user_fname[i]);
            newUser.setLname(user_lname[i]);
            newUser.setDob(user_dob[i]);
            newUser.setEmail(user_email[i]);
            newUser.setUsername(user_username[i]);
            newUser.setPassword(user_password);
            newUser.setTicketList(user_tickets.get(i));

            CustomerManager.UserList.add(newUser); // add user to user list

            // update dependent lists (passenger and transaction)
            for (int n = 0; n < 2; n++) {
                user_tickets.get(i).get(n).addPassenger(newUser); // user to passenger lists from user tickets
                Transaction newTransaction = new Transaction(newUser, user_tickets.get(i).get(n)); // create transaction
                CustomerManager.TransactionList.add(newTransaction); // add to transaction list
            }
        }
    }
}
