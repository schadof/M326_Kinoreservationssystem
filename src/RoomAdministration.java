import java.util.ArrayList;

public class RoomAdministration {

    private ArrayList<CinemaRoom> cinemaRooms;

    public RoomAdministration(){
        cinemaRooms = new ArrayList<>();
    }

    public void createRoom(ArrayList<Row> row){
        cinemaRooms.add(new CinemaRoom(row));
    }
    public CinemaRoom getRoom(int integer){
        return cinemaRooms.get(integer);
    }
    public ArrayList<CinemaRoom> getAllRooms(){
        return cinemaRooms;
    }
}
