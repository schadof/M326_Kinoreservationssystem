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
        roomModel.createRoom("Room01", roomRow);

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
                Client client = new Client(smallWindow.getText()[0],smallWindow.getText()[1], smallWindow.getText()[2], smallWindow.getText()[3]);
                clientModel.addClient(client);
                smallWindow.popup("successfull created");
            }
        };
        removeClient = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Client client = clientModel.getClientByName(smallWindow.getText()[0]);
                clientModel.getClients().remove(client);
                smallWindow.popup("successfull removed");
            }
        };
        removePresentation = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    PresInfo info = getScreenInfo();
                    presentationModel. removePresentation(
                            presentationModel.getPresentation(
                                    movieModel.getMovieByName(info.getParameters()[0]),info.getDate(),
                                    roomModel.getRoom(info.getRoomNum()
                                    )
                            )
                    );
                    smallWindow.popup("successful removal");
                }
                catch (NullPointerException ne){
                    smallWindow.popup("could not be removed");
                }
            }
        };
        getPresInfo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    PresInfo info = getScreenInfo();
                    presentationModel.createPresentation(
                            movieModel.getMovieByName(info.getParameters()[0]),
                            roomModel.getRoom(info.getRoomNum()),
                            info.getDate()
                    );
                    smallWindow.popup("successfull created");
                }
                catch (NullPointerException ne){
                    smallWindow.popup("could not be created");
                }
            }
        };
    }
    private PresInfo getScreenInfo(){

        PresInfo info = new PresInfo();
        info.setParameters(smallWindow.getText());
        info.setRoomNum(Integer.parseInt(info.getParameters()[1]) - 1);
        info.setDate( LocalDate.parse(info.getParameters()[2]).atStartOfDay().toInstant(ZoneOffset.UTC));

        return info;
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