import java.util.*;

public class UserManager {
    private LinkedList<User> UserList = new LinkedList<>();

    public void register() {
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);
        // create user object
        User customer = new User();

        // get personal user information
        System.out.print("First name: ");
        customer.fname = getInput.nextLine();
        System.out.print("Last name: ");
        customer.lname = getInput.nextLine();
        System.out.print("Date of birth: ");
        customer.dob = getInput.nextLine();
        System.out.print("Email: ");
        customer.email = getInput.nextLine();

        // set up username
        System.out.println("Username: ");
        customer.usrname = getInput.nextLine();
        // ToDo: insert check for duplicated usernames (username must be unique)

        // set up password
        System.out.println("Password: ");
        customer.password = getInput.nextLine();

        // append to user list
        UserList.add(customer);
    }
}
