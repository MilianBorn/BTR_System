package systems.loginSystem;
import components.User;
import systems.CustomerManager;

import java.util.Scanner;

public class LoginManager {
    // the user login system validates the user identity and sets the current user

    public static LoginResult login(boolean isAdmin) { // boolean indicates user or admin login

        Scanner getInput = new Scanner(System.in); // set up java input scanner

        // find the user in user list
        User userLogin = null;
        boolean login = false;
        while (!login) {
            // get username and password from user
            System.out.print("Username: ");
            String username = getInput.nextLine();
            System.out.print("Password: ");
            String password = getInput.nextLine();

            if (isAdmin) { // admin login
                if (username.equals("admin") && password.equals("admin")) {
                    System.out.println();
                    System.out.println("You are logged in as ADMIN");
                    System.out.println();
                    login = true;
                }
            } else { // user login
                for (User user : CustomerManager.UserList) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println();
                        System.out.println("Welcome " + user.getFname() + " " + user.getLname());
                        System.out.println();
                        userLogin = user;
                        login = true;
                    }
                }
            }

            if (!login) { // prompt error message
                System.out.println("Incorrect username or password");
                System.out.print("Try again? [y/n]");
                String option = getInput.nextLine();
                System.out.println();

                // leave login system if user chooses to exit
                if (option.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
        // return the LoginResult -> current user (or "null") and state of the login variable for validation
        return new LoginResult(userLogin, login);
        // userLogin = null     and login = true  -> successful admin login
        // userLogin = not null and login = true  -> successful user login
        // userLogin = null     and login = false -> failed login
    }
}
