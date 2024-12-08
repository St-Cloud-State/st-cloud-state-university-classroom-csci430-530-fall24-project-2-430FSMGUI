import java.util.Scanner;

public class ClerkMenuState implements State {
    private WareContext context;
    private ClientList clientList;

    public ClerkMenuState(WareContext context, ClientList clientList) {
        this.context = context;
        this.clientList = clientList;
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
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addClient(scanner);
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
                recordPayment(scanner);
                break;
            case 6:
                becomeClient(scanner);
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addClient(Scanner scanner) {
        System.out.println("Enter client name:");
        String clientName = scanner.nextLine();
        Client client = new Client(clientName);
        clientList.addClient(client);
        System.out.println("Client " + clientName + " added successfully.");
    }

    private void showProducts() {
        ProductList productList = context.getProductList();
        System.out.println(productList);
    }

    private void showClients() {
        for (Client client : clientList.getClients()) {
            System.out.println(client);
        }
    }

    private void showOutstandingBalance() {
        for (Client client : clientList.getClients()) {
            if (client.getBalance() < 0) {
                System.out.println(client);
            }
        }
    }

    private void recordPayment(Scanner scanner) {
        System.out.println("Enter client name to record payment:");
        String clientName = scanner.nextLine();
        // Record payment logic using clientName
    }

    private void becomeClient(Scanner scanner) {
        System.out.println("Enter client name to become:");
        String clientName = scanner.nextLine();
        Client client = clientList.getClient(clientName);
        if (client != null) {
            context.setState(new ClientMenuState(context, client)); // Pass the client
        } else {
            System.out.println("Client not found.");
        }
    }

    private void logout() {
        context.setState(new LoginState(context));
    }
}
