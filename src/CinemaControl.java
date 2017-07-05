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
//              control.getPresentationAdmin().getAllPresentations();
                SmallWindow smallWindow = new SmallWindow(new String[]{"Date", "Film", "Seat"}, "Get Catalog");
                smallWindow.startWin();

            }
        };

        getFilm = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
                SmallWindow smallWindow = new SmallWindow(new String[]{"Date", "Time", "Room"}, "Get Film");
                smallWindow.startWin();

            }
        };
        reserveSeat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
                SmallWindow smallWindow = new SmallWindow(new String[]{"Room", "Date"}, "Reserve Seat");
                smallWindow.startWin();

            }
        };
        getReservations = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
                SmallWindow smallWindow = new SmallWindow(new String[]{"Roo", "Date", "Client"}, "get Reservation");
                smallWindow.startWin();

            }
        };
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