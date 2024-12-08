import java.util.Scanner;

public class ClerkMenuState implements State {
    private WareContext context;

    public ClerkMenuState(WareContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Clerk Menu: Choose an operation");
        System.out.println("1. Add a client");
        System.out.println("2. Show list of products");
        System.out.println("3. Show list of clients");
        System.out.println("4. Show clients with outstanding balance");
        System.out.println("5. Record payment");
        System.out.println("6. Become a client");
        System.out.println("7. Logout");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addClient();
                break;
            case 2:
                showProducts();
                break;
            case 3:
                showClients();
                break;
            case 4:
                showOutstandingBalance();
                break;
            case 5:
                recordPayment();
                break;
            case 6:
                becomeClient();
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addClient() {
        // Add client logic
    }

    private void showProducts() {
        // Show products logic
    }

    private void showClients() {
        // Show clients logic
    }

    private void showOutstandingBalance() {
        // Show clients with outstanding balance logic
    }

    private void recordPayment() {
        // Record payment logic
    }

    private void becomeClient() {
        context.setState(new ClientMenuState(context));
    }

    private void logout() {
        context.setState(new LoginState(context));
    }
}
