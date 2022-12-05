package Systems;

import Peaces.User;

import java.util.*;

public class UserManager {
    public ArrayList<Peaces.User> UserList = new ArrayList<>();

    public void register() {
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);
        // create user object
        Peaces.User customer = new Peaces.User();

        // get personal user information
        System.out.print("First name: ");
        customer.fname = getInput.nextLine();
        System.out.print("Last name: ");
        customer.lname = getInput.nextLine();
        System.out.print("Date of birth: ");
        customer.dob = getInput.nextLine();
        System.out.print("Email: ");
        customer.email = getInput.nextLine();

        // set username and check for duplicates in UserList (username must be unique)
        while (true) {
            Boolean isUnique = true;
            // set up username
            System.out.print("Username: ");
            customer.username = getInput.nextLine();
            for (int i = 0; i < UserList.size(); i++) {
                if (customer.username.equals(UserList.get(i).username)) {
                    System.out.println("Username already exists");
                    System.out.println();
                    isUnique = false;
                }
            }
            if (isUnique) {
                break;
            }
        }

        // set up password
        System.out.print("Password: ");
        customer.password = getInput.nextLine();

        // append to user list
        UserList.add(customer);
    }
}
