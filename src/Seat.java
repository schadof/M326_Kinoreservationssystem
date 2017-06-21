public class Seat {

    private Seat nextSeat;
    private Seat previousSeat;
    private final int number;

    public Seat(){ this(null); }
    public Seat(Seat prevSeat) {
        if(prevSeat == null) number = 0;
        else{
            previousSeat = prevSeat;
            prevSeat.nextSeat = this;
            number = prevSeat.getNumber()+1;
        }
    }

    public int getNumber(){
        return number;
    }
}
