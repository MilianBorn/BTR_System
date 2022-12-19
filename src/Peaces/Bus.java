package Peaces;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class Bus {
    public String name;
    public String id = uniqueID();
    public String date = randomDate();
    public String time = randomTime();
    public int passengers = randomCapacity();

    public Bus(String name){
        this.name = name;
    }
    public String uniqueID(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }
    public String randomDate(){
        // Declare DateTimeFormatter with desired format.
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Save current LocalDateTime into a variable.
        LocalDateTime localDateTime = LocalDateTime.now();

        // Format LocalDateTime into a String variable and print.
        String formattedLocalDateTime = localDateTime.format(dateTimeFormatter);

        // Get a random amount of days between 5 and 10.
        Random random = new Random();
        int randomAmountOfDays = random.nextInt(10) + 1 ;

        // Add randomAmountOfDays to the LocalDateTime variable we defined
        // earlier and store it into a new variable.
        LocalDateTime futureLocalDateTime = localDateTime.plusDays(randomAmountOfDays);

        // Format new LocalDateTime variable into a String variable and print.
        String formattedFutureLocalDateTime = futureLocalDateTime.format(dateTimeFormatter);
        return formattedFutureLocalDateTime;
    }
    public String randomTime() {
        final Random randomNumber = new Random();
        final int millisInDay = 24 * 60 * 60*1000;
        Time time = new Time((long) randomNumber.nextInt(millisInDay));
        return time.toString();
    }
    public int  randomCapacity(){
        Random capacity = new Random();
        int low = 50;
        int high = 70;
        int result = capacity.nextInt(high-low) + low;
        return result;
    }
}

