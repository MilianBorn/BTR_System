public class Main {
    public static void main(String[] args) {
        LoginSystem.printStartMenu();
        int action = LoginSystem.getOption();
        System.out.println("Success: user selected valid option " + action + " in the start menu");
        }
}