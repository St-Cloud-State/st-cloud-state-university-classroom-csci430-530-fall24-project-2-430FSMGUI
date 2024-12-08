
import java.util.Scanner;

public class UserInterface {
    private WareContext context;

    public UserInterface() {
        context = new WareContext();  // Initialize the FSM context with the first state (LoginState)
    }

    public void displayMenu() {
        while (true) {
            context.executeState();  // Execute the current state, which will handle transitions
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();  // Create the UserInterface instance
        ui.displayMenu();  // Start the FSM interface
    }
}