public class Reservation {

    Client client;
    Seat seat = new Seat();

    public Reservation(){

    }

    public Client getClient(){
        return client;
    }
    public Seat getSeat(){
        return seat;
    }
}
