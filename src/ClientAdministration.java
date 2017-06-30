import java.util.ArrayList;

public class ClientAdministration {

    private ArrayList<Client> clients;

    public ClientAdministration(){
        clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }
    public Client getClientByName(String name){
        return Utility.Array_First(clients, client -> client.getName().equals(name));
    }
    public Client getClientByPhone(String phone){
        return Utility.Array_First(clients, client -> client.getPhone().equals(phone));
    }
    public Client getClientByMail(String mail){
        return Utility.Array_First(clients, client -> client.getMail().equals(mail));
    }
    public Client getClientByAddress(String address){
        return Utility.Array_First(clients, client -> client.getAddress().equals(address));
    }
}
