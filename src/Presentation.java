import java.time.Instant;

public class Presentation {

    private Instant start;
    private CinemaRoom room;
    private Movie movie;
    private Reservation[] reservations;

    public Presentation(Instant start, CinemaRoom room, Movie movie){
        reservations = new Reservation[0];
        this.start = start;
        this.room = room;
        this.movie = movie;
    }

    public Seat[] getFreeSeats(){
        Seat[] seats = new Seat[0];
        for( Row row : room.getAllRows())
            for (Seat seat : row.getSeats()){
                for(Reservation reservation : reservations)
                    if (reservation.getSeat() != seat)
                        seats = Utility.Array_Add(seats, seat);
            }
        return seats;
    }
    public void createReservation(Seat seat, Client client){
        reservations = Utility.Array_Add(reservations, new Reservation(client, this, seat));
    }

    public Movie getMovie(){return movie;}
    public CinemaRoom getRoom(){return room;}
    public Instant getStart(){return start;}

}
