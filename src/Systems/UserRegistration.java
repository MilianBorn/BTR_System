package Systems;

import Peaces.User;

import java.util.*;

public class UserRegistration { // this class is used to for any logic needed to register users
    public ArrayList<User> UserList = new ArrayList<>(); // this is the user list

    public void register() { // method to register a new user and add them to the user list
        // create scanner object for user input
        Scanner getInput = new Scanner(System.in);
        // create user object
        User newUser = new User();

        // prompt the user for input and saves information in customer (User object)
        System.out.print("First name: ");
        newUser.fname = getInput.nextLine();
        System.out.print("Last name: ");
        newUser.lname = getInput.nextLine();
        System.out.print("Date of birth: ");
        newUser.dob = getInput.nextLine();
        System.out.print("Email: ");
        newUser.email = getInput.nextLine();

        // set username and check for duplicates in UserList (username must be unique)
        while (true) { // while loop is always true and is exited by break statement

            boolean isUnique = true; // used to track if the username is unique (assumption = true)

            // set up username
            System.out.print("Username: "); // prompt for username
            newUser.username = getInput.nextLine(); // set username

            // check if username is unique
            for (User user : UserList) { // repeat for each User in UserList
                if (newUser.username.equals(user.username)) { // check is new username equals username from UserList
                    System.out.println("Username already exists"); // inform user that username is not unique
                    System.out.println(); // empty line for formatting
                    isUnique = false; // assumption = false, username is not unique
                }
            }
            if (isUnique) { // only exit the while loop when username is unique
                break;
            }
        }

        // set up password
        System.out.print("Password: "); // prompt for password
        newUser.password = getInput.nextLine(); // read user input
        System.out.println(); // empty lines for formatting
        System.out.println();

        // append newUser to user list
        UserList.add(newUser);
    }
}
