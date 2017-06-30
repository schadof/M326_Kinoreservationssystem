import java.util.ArrayList;

public class CinemaRoom {

    private ArrayList<Row> rows;

    public CinemaRoom(ArrayList rows){
        this.rows = rows;
    }

    public ArrayList<Seat> getRow(int index){
        if (rows.isEmpty()) return null;
        return rows.get(index).getSeats();
    }
    public ArrayList<Row> getAllRows(){
        return rows;
    }
}
