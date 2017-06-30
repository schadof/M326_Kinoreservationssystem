import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;

    public Row(int seatCount){
        seats = new ArrayList<>();
        Seat prev = null;
        Seat next;
        for(int i = 0; i < seatCount ; i++)
        {
            next = new Seat(prev);
            seats.add(next);
            prev = next;
        }
    }
    public Seat getFirstSeat(){ return seats.get(0); }
    public Seat getLastSeat(){ return seats.get(seats.size()-1); }
    public ArrayList<Seat> getSeats(){ return seats; }
}
