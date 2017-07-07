import java.util.ArrayList;

public class RoomAdministration {

    private ArrayList<CinemaRoom> cinemaRooms;

    public RoomAdministration(){
        cinemaRooms = new ArrayList<>();
    }

    public void createRoom(String ID, ArrayList<Row> row){
        cinemaRooms.add(new CinemaRoom(ID, row));
    }
    public CinemaRoom getRoom(int index){
        return cinemaRooms.get(index);
    }
    public CinemaRoom getRoom(String ID){ return Utility.Array_First(cinemaRooms, cinemaRoom -> cinemaRoom.getID().equals(ID)); }
    public ArrayList<CinemaRoom> getAllRooms(){
        return cinemaRooms;
    }
}
