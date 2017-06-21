public class Reservation {
    private static int nextID = 0;
    private int ID;
    private Client client;
    private Presentation presentation;
    private Seat seat;


    public Reservation(Client client, Presentation presentation, Seat seat){
        ID = getNextID();
        this.client = client;
        this.presentation = presentation;
        this.seat = seat;
    }
    public int getID(){return ID;}
    public Presentation getPresentation(){return presentation;}
    public Client getClient(){return client;}
    public Seat getSeat(){return seat;}


    // Auto Increment
    private static int getNextID(){return ++nextID;}
}
