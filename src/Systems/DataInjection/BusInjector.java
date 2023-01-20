package Systems.DataInjection;

import Peaces.Bus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

// this lass is used to inject a number of busses into the program when its started
public class BusInjector {
    public final String[] bus_id;                                       // unique bus ID
    public final String[] bus_route;                                    // route of the bus
    public final LocalDate[] bus_date;                                  // date of departure
    public final LocalTime[] bus_time;                                  // time of departure
    public final int[] bus_capacity;                                    // capacity of the bus
    public final float[] bus_price;                                     // price of the bus

    private void setBus_id() {
        for (int i = 0; i < 10; i++) {
            String newId = UUID.randomUUID().toString();
            this.bus_id[i] = newId.substring(0,8);
        }
    }

    private void setBus_date() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int day = random.ints(1,29).findFirst().getAsInt();
            int month = random.ints(1,4).findFirst().getAsInt();
            this.bus_date[i] = LocalDate.of(2023, month, day);
        }
    }

    private void setBus_time() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int hour = random.ints(6,21).findFirst().getAsInt();
            int minute = random.ints(0,60).findFirst().getAsInt();
            this.bus_time[i] = LocalTime.of(hour, minute);
        }
    }

    private void setBus_capacity() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int capacity = random.ints(20,60).findFirst().getAsInt();
            this.bus_capacity[i] = capacity;
        }
    }

    private void setBus_price() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int price = random.ints(40,150).findFirst().getAsInt();
            this.bus_price[i] = (float)price;
        }
    }

    public BusInjector() {

        this.bus_id = new String[10];
        setBus_id();

        this.bus_route = new String[] {"Berlin -> Hamburg", "Munich -> Koeln", "Frankfurt -> Stuttgart", "Leipzig -> Dortmund", "Bremen -> Dresden",
                "Hamburg -> Berlin", "Koeln -> Munich", "Stuttgart -> Frankfurt", "Dortmund -> Leipzig", "Dresden -> Bremen"};

        this.bus_date = new LocalDate[10];
        setBus_date();

        this.bus_time = new LocalTime[10];
        setBus_time();

        this.bus_capacity = new int[10];
        setBus_capacity();

        this.bus_price = new float[10];
        setBus_price();
    }

    public ArrayList<Bus> injectBus() {
        ArrayList<Bus> injectedBus = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bus newBus = new Bus();
            newBus.setId(this.bus_id[i]);
            newBus.setRoute(this.bus_route[i]);
            newBus.setDate(this.bus_date[i]);
            newBus.setTime(this.bus_time[i]);
            newBus.setCapacity(this.bus_capacity[i]);
            newBus.setPrice(this.bus_price[i]);

            injectedBus.add(newBus);
        }
        return injectedBus;
    }
}
