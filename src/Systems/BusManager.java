package Systems;
import Peaces.Bus;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class BusManager {
    public List<Bus> BusList = new ArrayList<>();     // this is bus list
    Bus Bus1 = new Bus("M45");
    Bus Bus2 = new Bus("X1");
    Bus Bus3 = new Bus("M24");
    Bus Bus4 = new Bus("N38");
    Bus Bus5 = new Bus("M70");
    Bus Bus6 = new Bus("X50");
    Bus Bus7 = new Bus("N81");
    Bus Bus8 = new Bus("M46");
    Bus Bus9 = new Bus("X65");
    Bus Bus10 = new Bus("X13");

    public void AddBusses(){
        BusList.add(Bus1);                // Add Busses to list
        BusList.add(Bus2);
        BusList.add(Bus3);
        BusList.add(Bus4);
        BusList.add(Bus5);
        BusList.add(Bus6);
        BusList.add(Bus7);
        BusList.add(Bus8);
        BusList.add(Bus9);
        BusList.add(Bus10);
    }
    public void ListBusses() {          // List all the busses in list
        for (Bus bus : BusList) {
            System.out.println("Name of the Bus is: " + bus.name);
            System.out.println("Unique ID of Bus is: " + bus.id);
            System.out.println("Date of Bus is: " + bus.date);
            System.out.println("Time of Bus is: " + bus.time);
            System.out.println("Capacity of Bus is: " + bus.passengers);
            System.out.println(" ");
        }
    }
    public void RemoveBusByID(){                     // Remove Busses by ID
        System.out.println("Enter the Unique ID of bus");
        Scanner scn = new Scanner (System.in);
        String enteredID = scn.next();
        BusList.removeIf(item -> item.id.equals(enteredID));
        ListBusses();
    }
    }

