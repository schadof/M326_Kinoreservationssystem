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
        for(Client client : clients) {
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
    public Client getClientByPhone(String phone){
        for(Client client : clients) {
            if(client.getPhone().equals(phone)){
                return client;
            }
        }
        return null;
    }
    public Client getClientByMail(String mail){
        for(Client client : clients) {
            if(client.getMail().equals(mail)){
                return client;
            }
        }
        return null;
    }
    public Client getClientByAddress(String address){
        for(Client client : clients) {
            if(client.getAddress().equals(address)){
                return client;
            }
        }
        return null;
    }
}
