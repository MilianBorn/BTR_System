package Systems.DataInjection;

import Peaces.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// this lass is used to inject a number of users into the program when its started
public class UserInjector {
    private final String[] user_fname;

    private final String[] user_lname;
    private final String[] user_email;

    private final LocalDate[] user_dob;

    private  final String[] user_username;

    private final String user_password;

    private void setUser_dob() {
        LocalDate startDate = LocalDate.of(1990, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.of(2000, 1, 1); //end date
        long end = endDate.toEpochDay();

        for (int i = 0; i < 10; i++) {
            long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
            this.user_dob[i] = LocalDate.ofEpochDay(randomEpochDay);
        }
    }

    private void setUser_email() {
        for (int i = 0; i < 10; i++) {
            this.user_email[i] = this.user_fname[i].toLowerCase() + '.' + this.user_lname[i].toLowerCase() + "@mail.com";
        }
    }

    public UserInjector() {

        this.user_fname = new String[] {"Michael", "Christopher", "Jessica", "Matthew", "Ashley",
                "Jennifer", "Joshua", "Amanda", "Daniel", "David"};

        this.user_lname = new String[] {"Smith", "Johnson", "Williams", "Brown", "Jones",
                "Miller", "Davis", "Wilson", "Anderson", "Taylor"};

        this.user_dob = new LocalDate[10];
        this.setUser_dob();

        this.user_email = new String[10];
        this.setUser_email();

        this.user_username = new String[] {"AnthraX", "AmbientTech", "Best_Name_Ever", "Scarface", "SilverLady",
                "TravelLust", "Retro_Reactive", "Brains&Beauty", "Exodus", "Angus"};

        this.user_password = "password";
    }

    public ArrayList<User> injectUser() {
        ArrayList<User> injectedUser = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User newUser = new User();
            newUser.fname = this.user_fname[i];
            newUser.lname = this.user_lname[i];
            newUser.dob = this.user_dob[i];
            newUser.email = this.user_email[i];
            newUser.username = this.user_username[i];
            newUser.password = this.user_password;

            injectedUser.add(newUser);
        }
        return injectedUser;
    }
}
