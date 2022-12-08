package Systems;
import Peaces.User;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    // ToDo: Max -> write user login system
    public int customerLogin(ArrayList<User> UserList) { // takes the user list as input

        Scanner getInput = new Scanner(System.in); // set up java input scanner

        // get username and password from user
        System.out.print("Username: ");
        String username = getInput.nextLine();
        System.out.print("Password: ");
        String password = getInput.nextLine();


    }
}
