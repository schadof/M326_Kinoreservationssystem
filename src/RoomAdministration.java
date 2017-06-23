public class RoomAdministration {

    private CinemaRoom[] cinemaRooms;

    public RoomAdministration(){
        cinemaRooms = new CinemaRoom[0];
    }

    public void createRoom(Row[] row){
        cinemaRooms = Utility.Array_Add(cinemaRooms,new CinemaRoom(row));
    }
    public CinemaRoom getRoom(int integer){
        return cinemaRooms[integer];
    }
    public CinemaRoom[] getAllRooms(){
        return cinemaRooms;
    }
}
