import java.util.List;
import java.util.Scanner;

public class ClientMenuState implements State {
    private WareContext context;
    private Client currentClient;

    public ClientMenuState(WareContext context, Client currentClient) {
        this.context = context;
        this.currentClient = currentClient;
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
        scanner.nextLine(); // Consume newline

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
                addToWishlist(scanner);
                break;
            case 5:
                displayWishlist();
                break;
            case 6:
                placeOrder(scanner);
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
        ProductList productList = context.getProductList();
        System.out.println(productList);
    }

    private void showTransactions() {
        // Display client transactions logic
    }

    private void addToWishlist(Scanner scanner) {
        System.out.println("Enter product name to add to wishlist:");
        String productName = scanner.nextLine();
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Product product = context.getProductList().getProduct(productName);
        if (product != null) {
            currentClient.addToWishlist(product, quantity);
            System.out.println("Added " + quantity + " of " + productName + " to wishlist.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void displayWishlist() {
        System.out.println("Wishlist for " + currentClient.getName() + ":");
        for (WishItem item : currentClient.getWishlist()) {
            System.out.println(item);
        }
    }

    private void placeOrder(Scanner scanner) {
        List<WishItem> wishlist = currentClient.getWishlist();
        for (WishItem item : wishlist) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (context.getWarehouse().isProductAvailable(product.getName(), quantity)) {
                double totalCost = product.getPrice() * quantity;
                if (currentClient.getBalance() >= totalCost) {
                    currentClient.subtractBalance(totalCost);
                    product.updateQuantity(product.getQuantity() - quantity);
                    System.out.println("Order placed for " + quantity + " of " + product.getName());
                } else {
                    System.out.println("Insufficient balance for " + product.getName());
                }
            } else {
                System.out.println("Product " + product.getName() + " is not available in the required quantity.");
            }
        }
        wishlist.clear(); // Clear wishlist after placing order
    }

    private void logout() {
        context.setState(new LoginState(context)); // Transition back to LoginState
    }
}