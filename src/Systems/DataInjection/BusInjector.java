package Systems.DataInjection;

import Components.Bus;
import Components.Route;
import Systems.BusManager;
import Systems.RouteManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.OptionalInt;
import java.util.Random;
import java.util.UUID;

// this lass is used to inject a number of busses into the program when its started
public class BusInjector {
    public static final String[] bus_id = setBus_id();
    public static final Route[] bus_route = setBus_route();
    public static final LocalDate[] bus_date = setBus_date();
    public static final LocalTime[] bus_time = setBus_time();
    public static final int[] bus_capacity = setBus_capacity();
    public static final float[] bus_price = setBus_price();

    private static String[] setBus_id() {
        String[] id = new String[10];
        for (int i = 0; i < 10; i++) {
            String newId = UUID.randomUUID().toString();
            id[i] = newId.substring(0,8);
        }
        return id;
    }

    private static Route[] setBus_route() {
        Route[] route = new Route[10];
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * RouteManager.RouteList.size()); // random index
            route[i] = RouteManager.RouteList.get(index);
        }
        return route;
    }

    private static LocalDate[] setBus_date() {
        LocalDate[] date = new LocalDate[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            OptionalInt dayOl = random.ints(1,29).findFirst();
            OptionalInt monthOl = random.ints(1,4).findFirst();

            if (dayOl.isPresent() && monthOl.isPresent()) {
                int day = dayOl.getAsInt();
                int month = monthOl.getAsInt();
                date[i] = LocalDate.of(2023, month, day);
            }
        }
        return date;
    }

    private static LocalTime[] setBus_time() {
        LocalTime[] time = new LocalTime[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            OptionalInt hourOl = random.ints(6,21).findFirst();
            OptionalInt minuteOl = random.ints(0,60).findFirst();

            if (hourOl.isPresent() && minuteOl.isPresent()) {
                int hour = hourOl.getAsInt();
                int minute = minuteOl.getAsInt();
                time[i] = LocalTime.of(hour, minute);
            }
        }
        return time;
    }

    private static int[] setBus_capacity() {
        int[] capacity = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            OptionalInt capOl = random.ints(20,60).findFirst();
            if (capOl.isPresent()) {
                int cap = capOl.getAsInt();
                capacity[i] = cap;
            }
        }
        return capacity;
    }

    private static  float[] setBus_price() {
        float[] prices = new float[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            OptionalInt priceOl = random.ints(40,150).findFirst();

            if (priceOl.isPresent()) {
                int price = priceOl.getAsInt();
                prices[i] = (float)price;
            }
        }
        return prices;
    }

    public static void injectBus() {

        for (int i = 0; i < 10; i++) {
            Bus newBus = new Bus();
            newBus.setId(bus_id[i]);
            newBus.setRoute(bus_route[i]);
            newBus.setDate(bus_date[i]);
            newBus.setTime(bus_time[i]);
            newBus.setCapacity(bus_capacity[i]);
            newBus.setPrice(bus_price[i]);

            BusManager.BusList.add(newBus); // add bus to bus list
            bus_route[i].assignBus(newBus); // assign bus to route
        }
    }
}
