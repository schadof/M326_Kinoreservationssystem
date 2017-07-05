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
    private EventHandler<ActionEvent> getCatalog, getFilm, reserveSeat, getReservations, removeReservation;

    public CinemaControl( RoomAdministration roomModel,
                          PresentationAdministration presentationModel,
                          MovieAdministration movieModel,
                          ClientAdministration clientModel
                        ){
        this.clientModel = clientModel;
        this.roomModel  = roomModel;
        this.movieModel = movieModel;
        this.presentationModel = presentationModel;
        createEvents();

    }
    private void createEvents() {
        getCatalog = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Date", "Film", "Seat"}, "Get Catalog");

            }
        };

        getFilm = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Date", "Time", "Room"}, "Get Film");

            }
        };
        reserveSeat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Room", "Date"}, "Reserve Seat");

            }
        };
        getReservations = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Roo", "Date", "Client"}, "get Reservation");

            }
        };
    }
    private void smallWindow(String fields[], String title){
        SmallWindow smallWindow = new SmallWindow(fields,title);
        smallWindow.startWin();
    }


//    public RoomAdministration getRoomAdmin(){
//        if (roomModel == null)
//            roomModel = new RoomAdministration();
//        return roomModel;
//    }
//    public MovieAdministration getMovieAdmin(){
//        if (movieModel == null)
//            movieModel = new MovieAdministration();
//        return movieModel;
//    }
//    public PresentationAdministration getPresentationAdmin(){
//        if (presentationModel == null)
//            presentationModel = new PresentationAdministration();
//        return presentationModel;
//    }
//    public ClientAdministration getClientAdmin(){
//        if (clientModel == null)
//            clientModel = new ClientAdministration();
//        return clientModel;
//    }

    public RoomAdministration getRoomModel() {
        return roomModel;
    }

    public PresentationAdministration getPresentationModel() {
        return presentationModel;
    }

    public MovieAdministration getMovieModel() {
        return movieModel;
    }

    public ClientAdministration getClientModel() {
        return clientModel;
    }

    public EventHandler<ActionEvent> getGetCatalog() {
        return getCatalog;
    }

    public EventHandler<ActionEvent> getGetFilm() {
        return getFilm;
    }

    public EventHandler<ActionEvent> getReserveSeat() {
        return reserveSeat;
    }

    public EventHandler<ActionEvent> getGetReservations() {
        return getReservations;
    }

    public EventHandler<ActionEvent> getRemoveReservation() {
        return removeReservation;
    }
}