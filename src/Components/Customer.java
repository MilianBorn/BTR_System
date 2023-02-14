package Components;
import java.time.LocalDate;
public class Customer extends User{
    public Customer(String fname, String lname, LocalDate dob, String email, String username, String password) {
        super(fname, lname);
    }

    @Override
    public boolean isAdmin() {
        return false;
    }
}
