import java.util.ArrayList;
import java.util.List;

public class ClientList {
    private List<Client> clients;

    public ClientList() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null; // Client not found
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        StringBuilder clientList = new StringBuilder("Clients:\n");
        for (Client client : clients) {
            clientList.append(client.toString()).append("\n");
        }
        return clientList.toString();
    }
}
