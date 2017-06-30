import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;

public class Presentation {

    private Instant start;
    private CinemaRoom room;
    private Movie movie;
    private ArrayList<Reservation> reservations;

    public Presentation(Instant start, CinemaRoom room, Movie movie){
        reservations = new ArrayList<>();
        this.start = start;
        this.room = room;
        this.movie = movie;
    }

    public ArrayList<Seat> getFreeSeats(){
        ArrayList<Seat> seats = new ArrayList<>();
        for( Row row : room.getAllRows())
            for (Seat seat : row.getSeats()){
                for(Reservation reservation : reservations)
                    if (reservation.getSeat() != seat)
                        seats.add(seat);
            }
        return seats;
    }

    public ArrayList<Reservation> getReservations(){ return reservations; }

    public int createReservation(Seat seat, Client client){
        Reservation newres = new Reservation(client,this,seat);
        reservations.add(newres);
        return newres.getID();
    }

    public Movie getMovie(){return movie;}
    public CinemaRoom getRoom(){return room;}
    public Instant getStart(){return start;}

}
