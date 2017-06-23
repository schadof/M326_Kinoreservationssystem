public class RoomAdministration {

    CinemaRoom cinemaRoom;
    CinemaRoom[] cinemaRooms;

    public RoomAdministration(){

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
