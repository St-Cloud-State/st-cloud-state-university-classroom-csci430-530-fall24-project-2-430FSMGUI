public class WareContext {
    private State currentState;
    private ClientList clientList;
    private ProductList productList;
    private Warehouse warehouse;

    public WareContext(ClientList clientList, ProductList productList, Warehouse warehouse) {
        this.clientList = clientList;
        this.productList = productList;
        this.warehouse = warehouse;
        currentState = new LoginState(this); // Initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void executeState() {
        currentState.execute();
    }

    public ClientList getClientList() {
        return clientList;
    }

    public ProductList getProductList() {
        return productList;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
