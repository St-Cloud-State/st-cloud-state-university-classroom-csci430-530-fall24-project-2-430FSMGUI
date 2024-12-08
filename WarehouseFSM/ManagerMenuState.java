import java.util.Scanner;

public class ManagerMenuState implements State {
    private WareContext context;

    public ManagerMenuState(WareContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manager Menu: Choose an operation");
        System.out.println("1. Add a product");
        System.out.println("2. Display waitlist for a product");
        System.out.println("3. Receive shipment");
        System.out.println("4. Become a clerk");
        System.out.println("5. Logout");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProduct(scanner);
                break;
            case 2:
                displayWaitlist(scanner);
                break;
            case 3:
                receiveShipment(scanner);
                break;
            case 4:
                becomeClerk();
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter product quantity:");
        int quantity = scanner.nextInt();
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        Product product = new Product(productName, quantity, price);
        context.getProductList().addProduct(product);
        System.out.println("Product " + productName + " added successfully.");
    }

    private void displayWaitlist(Scanner scanner) {
        System.out.println("Enter product name to display waitlist:");
        String productName = scanner.nextLine();
        // Display waitlist logic using productName
    }

    private void receiveShipment(Scanner scanner) {
        System.out.println("Enter product name to receive shipment:");
        String productName = scanner.nextLine();
        System.out.println("Enter quantity to receive:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        // Receive shipment logic using productName and quantity
    }

    private void becomeClerk() {
        context.setState(new ClerkMenuState(context, context.getClientList()));
    }

    private void logout() {
        context.setState(new LoginState(context));
    }
}
