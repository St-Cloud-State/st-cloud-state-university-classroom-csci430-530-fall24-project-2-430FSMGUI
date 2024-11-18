import java.util.Scanner;

public class LoginState implements State {
    private Context context;

    public LoginState(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Warehouse System!");
        System.out.println("1. Client Menu");
        System.out.println("2. Clerk Menu");
        System.out.println("3. Manager Menu");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Client ID: ");
                String clientId = scanner.next();
                context.setState(new ClientMenuState(context, clientId));
            }
            case 2 -> context.setState(new ClerkMenuState(context));
            case 3 -> context.setState(new ManagerMenuState(context));
            case 4 -> {
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handle(); // Retry
            }
        }
    }
}
