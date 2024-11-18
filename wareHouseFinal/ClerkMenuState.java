import java.util.Scanner;

public class ClerkMenuState implements State {
    private Context context;

    public ClerkMenuState(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Clerk Menu ---");
        System.out.println("1. Add a client");
        System.out.println("2. Show list of products");
        System.out.println("3. Show list of clients");
        System.out.println("4. Show list of clients with outstanding balance");
        System.out.println("5. Record payment from a client");
        System.out.println("6. Become a client");
        System.out.println("7. Logout");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> addClient();
            case 2 -> showProducts();
            case 3 -> showClients();
            case 4 -> showClientsWithBalance();
            case 5 -> recordPayment();
            case 6 -> becomeClient();
            case 7 -> logout();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handle(); // Retry
            }
        }
    }

    private void addClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new client ID: ");
        String clientId = scanner.nextLine();
        System.out.println("Client " + clientId + " added successfully.");
    }

    private void showProducts() {
        // Simulated product list
        System.out.println("Products:");
        System.out.println("1. Product A - 10 units - $10");
        System.out.println("2. Product B - 20 units - $20");
    }

    private void showClients() {
        // Simulated client list
        System.out.println("Clients:");
        System.out.println("1. Client ID: 101, Name: Alice, Balance: $50");
        System.out.println("2. Client ID: 102, Name: Bob, Balance: $0");
    }

    private void showClientsWithBalance() {
        // Simulated clients with outstanding balances
        System.out.println("Clients with Outstanding Balances:");
        System.out.println("1. Client ID: 101, Name: Alice, Balance: $50");
    }

    private void recordPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter client ID for payment: ");
        String clientId = scanner.nextLine();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Recorded payment of $" + amount + " for Client ID: " + clientId);
    }

    private void becomeClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Client ID to switch: ");
        String clientId = scanner.nextLine();
        context.setState(new ClientMenuState(context, clientId));
    }

    private void logout() {
        System.out.println("Logging out...");
        context.setState(new LoginState(context));
    }
}

WarehouseFSM.JAVA
public class WarehouseFSM {
    public static void main(String[] args) {
        Context context = new Context();

        while (true) {
            context.handle();
        }
    }
}


