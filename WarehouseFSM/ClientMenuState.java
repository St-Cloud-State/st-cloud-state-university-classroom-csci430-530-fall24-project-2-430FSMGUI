import java.util.Scanner;

public class ClientMenuState implements State {
    private WareContext context;

    public ClientMenuState(WareContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client Menu: Choose an operation");
        System.out.println("1. Show client details");
        System.out.println("2. Show list of products");
        System.out.println("3. Show client transactions");
        System.out.println("4. Add item to wishlist");
        System.out.println("5. Display wishlist");
        System.out.println("6. Place an order");
        System.out.println("7. Logout");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                showClientDetails();
                break;
            case 2:
                showProducts();
                break;
            case 3:
                showTransactions();
                break;
            case 4:
                addToWishlist();
                break;
            case 5:
                displayWishlist();
                break;
            case 6:
                placeOrder();
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void showClientDetails() {
        // Display client details logic
    }

    private void showProducts() {
        // Display products available logic
    }

    private void showTransactions() {
        // Display client transactions logic
    }

    private void addToWishlist() {
        // Add item to wishlist logic
    }

    private void displayWishlist() {
        // Display wishlist logic
    }

    private void placeOrder() {
        // Place order logic
    }

    private void logout() {
        context.setState(new LoginState(context));
    }
}
