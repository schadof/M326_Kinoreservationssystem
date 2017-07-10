import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 05.07.2017.
 */
public class CinemaControl {

    private RoomAdministration roomModel;
    private PresentationAdministration presentationModel;
    private MovieAdministration movieModel;
    private ClientAdministration clientModel;
    private EventHandler<ActionEvent>
            getCatalog, getFilm, reserveSeat, getReservations, removeReservation,
            addClient, removeClient, createPresentation, removePresentation;
    private SmallWindow smallWindow;

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
    public void createTestData(){
//      Testdata for Rooms
        ArrayList<Row> roomRow = new ArrayList<Row>();
        roomRow.add(new Row(5));
        roomRow.add(new Row(5));
        roomRow.add(new Row(5));
        roomModel.createRoom(roomRow);

//      Testdata for client
//        clientModel.addClient();

    }
//  This events will help us Morph the date, the events have a flow, which will help us not code redundant events
//  the current events will pass the next events after it to smallWindow by reference
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
                smallWindow(new String[]{"Room", "Date", "Client"}, "get Reservation");

            }
        };
        removeReservation =new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Room", "Date", "Client"}, "remove Reservation");

            }
        };
        addClient = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"full Name", "phone", "email"}, "look/add Client");

            }
        };
        removeClient = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"full Name", "phone", "email"}, "remove Client");

            }
        };
        createPresentation = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Film", "Room", "Date"}, "create Presentation");

            }
        };
        removePresentation = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(new String[]{"Film", "Room", "Date"}, "remove Presentation");

            }
        };
    }
    private void smallWindow(String fields[], String title){
        if(smallWindow != null){
            smallWindow.endWin();
        }
        smallWindow = new SmallWindow(fields,title);
        smallWindow.startWin();
    }

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

    public EventHandler<ActionEvent> getAddClient() {
        return addClient;
    }

    public EventHandler<ActionEvent> getCreatePresentation() {
        return createPresentation;
    }

    public EventHandler<ActionEvent> getRemovePresentation() {
        return removePresentation;
    }

    public EventHandler<ActionEvent> getRemoveClient() {
        return removeClient;
    }
}