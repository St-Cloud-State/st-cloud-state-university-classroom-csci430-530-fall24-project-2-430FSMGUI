import java.util.Scanner;

public class ClientMenuState implements State {
    private Context context;
    private String clientId;

    public ClientMenuState(Context context, String clientId) {
        this.context = context;
        this.clientId = clientId;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Client Menu ---");
        System.out.println("Client ID: " + clientId);
        System.out.println("1. Show client details");
        System.out.println("2. Show list of products");
        System.out.println("3. Show client transactions");
        System.out.println("4. Add item to wishlist");
        System.out.println("5. Display wishlist");
        System.out.println("6. Place an order");
        System.out.println("7. Logout");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> showClientDetails();
            case 2 -> showProducts();
            case 3 -> showTransactions();
            case 4 -> addToWishlist();
            case 5 -> displayWishlist();
            case 6 -> placeOrder();
            case 7 -> logout();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handle(); // Retry
            }
        }
    }

    private void showClientDetails() {
        // Simulated client details
        System.out.println("Client Details for ID: " + clientId);
        System.out.println("Name: John Doe");
        System.out.println("Email: john.doe@example.com");
    }

    private void showProducts() {
        // Simulated product list
        System.out.println("Available Products:");
        System.out.println("1. Product A - $10");
        System.out.println("2. Product B - $20");
        System.out.println("3. Product C - $30");
    }

    private void showTransactions() {
        // Simulated transactions
        System.out.println("Transactions for Client ID: " + clientId);
        System.out.println("1. Order #1234 - $50");
        System.out.println("2. Order #5678 - $30");
    }

    private void addToWishlist() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product to add to wishlist: ");
        String product = scanner.nextLine();
        System.out.println("Added " + product + " to wishlist.");
    }

    private void displayWishlist() {
        // Simulated wishlist
        System.out.println("Wishlist for Client ID: " + clientId);
        System.out.println("1. Product A");
        System.out.println("2. Product C");
    }

    private void placeOrder() {
        // Simulated order placement
        System.out.println("Order placed for Client ID: " + clientId);
    }

    private void logout() {
        System.out.println("Logging out...");
        context.setState(new LoginState(context));
    }
}
