import java.util.Scanner;

public class UserInterface {
    private WareContext context;

    public UserInterface() {
        context = new WareContext();
    }

    public void displayMenu() {
        while (true) {
            context.executeState();
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayMenu();
    }
}
