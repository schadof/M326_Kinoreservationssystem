
public class ClientAdministration {

    private Client[] clients;

    public ClientAdministration(){
        clients = new Client[0];
    }

    public void addClient(Client client){
        clients = Utility.Array_Add(clients, client);
    }
    public Client getClientByName(String name){
        return Utility.Array_Find(clients, client -> client.getName().equals(name));
    }
    public Client getClientByPhone(String phone){
        return Utility.Array_Find(clients, client -> client.getPhone().equals(phone));
    }
    public Client getClientByMail(String mail){
        return Utility.Array_Find(clients, client -> client.getMail().equals(mail));
    }
    public Client getClientByAddress(String address){
        return Utility.Array_Find(clients, client -> client.getAddress().equals(address));
    }
}
