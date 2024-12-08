
public class UserInterface {
    private WareContext context;
    private ClientList clientList;
    private ProductList productList;
    private Warehouse warehouse;

    public UserInterface() {
        clientList = new ClientList();
        productList = new ProductList();
        warehouse = new Warehouse();
        context = new WareContext(clientList, productList, warehouse);
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