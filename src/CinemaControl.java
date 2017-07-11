import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.time.*;
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
            reserveSeat, removeReservation,
            addClient, removeClient, removePresentation,
            getPresInfo;
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
        createEvent();
        createTestData();

    }
    public void createTestData(){
//      Testdata for Rooms
        ArrayList<Row> roomRow = new ArrayList<Row>();
        roomRow.add(new Row(5));
        roomRow.add(new Row(5));
        roomRow.add(new Row(5));
        roomModel.createRoom(roomRow);

//      Testdata for Film
        movieModel.addMovie(new Movie("The White Bear", Duration.ofSeconds(60), "The evil White Bear"));

//      Testdata for client
//        clientModel.addClient();

    }
//  This events will help us Morph the date, the events have a flow, which will help us not code redundant events
//  the current events will pass the next events after it to smallWindow by reference
    public EventHandler<ActionEvent> eventFactory(String labels[], String title, EventHandler<ActionEvent> multiEvent) {
        EventHandler<ActionEvent> request;

        request = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                smallWindow(labels, title,multiEvent);
            }
        };

        return  request;
    }

    private void createEvent(){
        reserveSeat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //smallWindow(new String[]{"Room", "Date"}, "Reserve Seat",null);

            }
        };
        removeReservation =new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        };
        addClient = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        };
        removeClient = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        };
        removePresentation = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        };
        getPresInfo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String parameters[] = smallWindow.getText();
                int i;
                try {
                    i = (Integer.parseInt(parameters[1]) - 1);

                    LocalDate localDate = LocalDate.parse(parameters[2]);
                    LocalDateTime localDateTime = localDate.atStartOfDay();
                    Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

                    presentationModel.createPresentation(movieModel.getMovieByName(parameters[0]),
                                                         roomModel.getRoom(i),
                                                        instant);
                    smallWindow.popup("successfull created");
                }
                catch (NullPointerException ne){
                   smallWindow.popup("could not be created");
                }
            }

        };
    }
    private void smallWindow(String fields[], String title, EventHandler<ActionEvent> multiEvent){
        if(smallWindow != null){
            smallWindow.endWin();
            smallWindow = null;
        }
        smallWindow = new SmallWindow(fields,title, multiEvent);
        smallWindow.startWin();
    }

    public EventHandler<ActionEvent> getReserveSeat() {
        return reserveSeat;
    }

    public EventHandler<ActionEvent> getRemoveReservation() {
        return removeReservation;
    }

    public EventHandler<ActionEvent> getAddClient() {
        return addClient;
    }

    public EventHandler<ActionEvent> getPresInfo() {
        return getPresInfo;
    }

    public EventHandler<ActionEvent> getRemovePresentation() {
        return removePresentation;
    }

    public EventHandler<ActionEvent> getRemoveClient() {
        return removeClient;
    }
}