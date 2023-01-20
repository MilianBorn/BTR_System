package Systems;
import Peaces.Bus;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.*;

public class BusManager {

    public ArrayList<Bus> BusList = new ArrayList<>(); // this is the bus list

    // method to register a new bus and add them to the bus list
    public Bus addBus() {
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);
        // create user object
        Bus newBus = new Bus();

        // set random ID
        String newId = UUID.randomUUID().toString();
        newBus.setId(newId.substring(0,8)); // only first 8 chars

        // prompt the user for input and saves information in bus (Bus object)

        // set route from user input
        // ToDo: Select and add existing routes from route list
        // ToDo: Add bus to list of assigned busses in the route object
        System.out.print("Route: ");
        newBus.setRoute(getInput.nextLine());

        // set date and time of departure from user input
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate newDate;
        LocalTime newTime;
        boolean isSet_date = false;
        boolean isSet_time = false;

        while (!isSet_date || !isSet_time) {
            if (!isSet_date) {
                System.out.print("Date of departure [dd.mm.yyyy]: ");
                String dateString = getInput.nextLine();
                try {
                    newDate = LocalDate.parse(dateString, dateFormatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format");
                    continue;
                }
                newBus.setDate(newDate);
                isSet_date = true;
            }
            System.out.print("Time of departure [hh:mm]: ");
            String timeString = getInput.nextLine();
            try {
                newTime = LocalTime.parse(timeString, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format");
                continue;
            }
            newBus.setTime(newTime);
            isSet_time = true;
        }

        // set capacity from user input
        int newCapacity;
        boolean isSet_cap = false;

        while (!isSet_cap) {
            System.out.print("Capacity: ");
            String capacityString = getInput.nextLine();
            try {
                newCapacity = Integer.parseInt(capacityString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid capacity (format)");
                continue;
            }
            if (newCapacity <= 0 || newCapacity > 100) {
                System.out.println("Invalid amount for capacity");
                continue;
            }
            newBus.setCapacity(newCapacity);
            isSet_cap = true;
        }

        // set price from user input
        float newPrice;
        boolean isSet_price = false;

        while (!isSet_price) {
            System.out.print("Price [x.xx]: ");
            String priceString = getInput.nextLine();
            try {
                newPrice = Float.parseFloat(priceString);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format");
                continue;
            }
            if (newPrice <= 0 || newPrice >= 1000) {
                System.out.println("Invalid amount for price");
                continue;
            }
            newPrice = Float.parseFloat(String.format("%.2f", newPrice)); // truncate to two decimals
            newBus.setPrice(newPrice);
            isSet_price = true;
        }

        // add new bus to list
        BusList.add(newBus);
        return newBus;
    }

    public Bus removeBus() {
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);

        Bus rmvBus = null;
        boolean isFound = false;
        while(!isFound) {
            // get bus ID from user
            System.out.print("Bus ID: ");
            String id = getInput.nextLine();

            // search for bus ID
            for (Bus bus : BusList) {
                if (bus.getId().equals(id)) {
                    rmvBus = bus;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Bus ID not found");
                System.out.print("Try again? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave search if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
        if (isFound) {
            BusList.remove(rmvBus);
            return rmvBus;
        } else { return null; }
    }
}

