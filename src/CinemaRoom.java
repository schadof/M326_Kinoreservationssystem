import java.util.ArrayList;

public class CinemaRoom {

    private String ID;

    private ArrayList<Row> rows;

    public CinemaRoom(String ID, ArrayList rows){
        this.ID = ID;
        this.rows = rows;
    }

    public ArrayList<Seat> getRow(int index){
        if (rows.isEmpty()) return null;
        return rows.get(index).getSeats();
    }
    public ArrayList<Row> getAllRows(){
        return rows;
    }

    public String getID() {return ID;}
}
