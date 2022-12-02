public class Main {

    public static void main(String[] args) {
        StartMenu.printMenu();
        int option = MenuManager.getOption(StartMenu.length);
        if (option == 1) {
            CustomerLoginMenu.printMenu();
            option = MenuManager.getOption(CustomerLoginMenu.length);
        } else if (option == 2) {
            VendorLoginMenu.printMenu();
            option = MenuManager.getOption(VendorLoginMenu.length);
        } else {
            System.exit(0);
        }
    }
}
