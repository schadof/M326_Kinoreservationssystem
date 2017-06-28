import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;

    public Row(ArrayList<Seat> seats){
        this.seats = seats;
    }
    public Seat getFirstSeat(){ return seats.get(0); }
    public Seat getLastSeat(){ return seats.get(seats.size()-1); }
    public ArrayList<Seat> getSeats(){ return seats; }
}
