public class Row {

    Seat[] seats;

    public Row(){
        seats = new Seat[0];
    }
    public Seat getFirstSeat(){ return Utility.Array_Any(seats) ? seats[0] : null; }
    public Seat getLastSeat(){ return Utility.Array_Last(seats); }
    public Seat[] getSeats(){ return seats; }
}
