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

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                displayWaitlist();
                break;
            case 3:
                receiveShipment();
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

    private void addProduct() {
        // Add product logic
    }

    private void displayWaitlist() {
        // Display waitlist logic
    }

    private void receiveShipment() {
        // Receive shipment logic
    }

    private void becomeClerk() {
        context.setState(new ClerkMenuState(context));
    }

    private void logout() {
        context.setState(new LoginState(context));
    }
}
