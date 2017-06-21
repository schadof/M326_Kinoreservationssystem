public class CinemaManagement {

    RoomAdministration roomAdmin;
    PresentationAdministration preAdmin;
    MovieAdministration movieAdmin;
    ClientAdministration clientAdmin;

    public RoomAdministration getRoomAdmin(){
        if (roomAdmin == null)
            roomAdmin = new RoomAdministration();
        return roomAdmin;
    }
    public MovieAdministration getMovieAdmin(){
        if (movieAdmin == null)
            movieAdmin = new MovieAdministration();
        return movieAdmin;
    }
    public PresentationAdministration getPresentationAdmin(){
        if (preAdmin == null)
            preAdmin = new PresentationAdministration();
        return preAdmin;
    }
    public ClientAdministration getClientAdmin(){
        if (clientAdmin == null)
            clientAdmin = new ClientAdministration();
        return clientAdmin;
    }
}
