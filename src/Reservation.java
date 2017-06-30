import javax.rmi.CORBA.Util;
import java.util.ArrayList;

public class Reservation {
    private static int nextID = 0;
    private int ID;
    private Client client;
    private Presentation presentation;
    private Seat seat;
    private static ArrayList<Reservation> allReservations = new ArrayList<>();

    public Reservation(Client client, Presentation presentation, Seat seat){
        ID = getNextID();
        this.client = client;
        this.presentation = presentation;
        this.seat = seat;
        allReservations.add(this);
    }
    public int getID(){return ID;}
    public Presentation getPresentation(){return presentation;}
    public Client getClient(){return client;}
    public Seat getSeat(){return seat;}
    public static Reservation getReservation(int ID){ return Utility.Array_First(allReservations, reservation -> reservation.getID() == ID); }

    // Auto Increment
    private static int getNextID(){return ++nextID;}
}
