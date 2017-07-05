import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by 11mmuellerde on 05.07.2017.
 */
public class CinemaControl {

    private RoomAdministration roomModel;
    private PresentationAdministration presentationModel;
    private MovieAdministration movieModel;
    private ClientAdministration clientModel;

    public CinemaControl( RoomAdministration roomModel,
                          PresentationAdministration presentationModel,
                          MovieAdministration movieModel,
                          ClientAdministration clientModel
                        ){
        this.clientModel = clientModel;
        this.roomModel  = roomModel;
        this.movieModel = movieModel;
        this.presentationModel = presentationModel;

    }

    public RoomAdministration getRoomAdmin(){
        if (roomModel == null)
            roomModel = new RoomAdministration();
        return roomModel;
    }
    public MovieAdministration getMovieAdmin(){
        if (movieModel == null)
            movieModel = new MovieAdministration();
        return movieModel;
    }
    public PresentationAdministration getPresentationAdmin(){
        if (presentationModel == null)
            presentationModel = new PresentationAdministration();
        return presentationModel;
    }
    public ClientAdministration getClientAdmin(){
        if (clientModel == null)
            clientModel = new ClientAdministration();
        return clientModel;
    }
}
