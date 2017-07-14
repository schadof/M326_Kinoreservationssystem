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
            getPresInfo, getPresentation, getRoom;
    private SmallWindow smallWindow;
    private Presentation pres;

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
        movieModel.addMovie(new Movie("The Black Bear", Duration.ofSeconds(60), "The evil White Bear"));
        movieModel.addMovie(new Movie("The Yellow Bear", Duration.ofSeconds(60), "The evil White Bear"));
        movieModel.addMovie(new Movie("The Green Bear", Duration.ofSeconds(60), "The evil White Bear"));
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
                createWindow(labels, title,multiEvent);
            }
        };

        return  request;
    }

    private void createEvent(){
        getPresentation  = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               String screenInfo[] = new String[ presentationModel.getAllPresentations().size()];
                Instant userInput = LocalDate.parse(smallWindow.getText()[0]).atStartOfDay().toInstant(ZoneOffset.UTC);
                for(int i = 0; i < presentationModel.getAllPresentations().size(); i++){
                    Instant presDate = presentationModel.getAllPresentations().get(i).getStart();
                    if (presDate.equals(userInput)){
                            screenInfo[i] = (smallWindow.getText()[0]+", "+
                                    presentationModel.getAllPresentations().get(i).getRoom().getID() +", "+
                                    presentationModel.getAllPresentations().get(i).getMovie().getTitle() );
                    }
                }
                createWindow(new String[]{}, "Choose Pres",getRoom);
                smallWindow.selectionScreen(screenInfo, "Name");
            }
        };
        getRoom = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getPres();
                String seats[] = new String[pres.getFreeSeats().size()];
                int rowCount = pres.getRoom().getAllRows().size();
                for(int j = 0; j < rowCount; j++){
                    for(int i = 0; i < pres.getRoom().getAllRows().get(j).getSeats().size() ; i++) {
                        int add = (pres.getRoom().getAllRows().get(j).getSeats().size() * j)+1;
                       seats[i+add-1] = (pres.getFreeSeats().get(i).getNumber()+add+"");
                    }
                }
                createWindow(new String[]{}, "Choose seats",reserveSeat);
                smallWindow.selectionScreen(seats, "Name");

            }
        };
        reserveSeat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String seats[] = smallWindow.returnSelection().split(", ");
               for(int i = 0; i < seats.length; i++){

               }
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
                catch (NullPointerException e){
                    smallWindow.popup("could not be removed");
                }

            }
        };
        getPresInfo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                     PresInfo info = getScreenInfo();
                     if(!movieModel.getMovieByName(info.getParameters()[0]).equals(null)){

                        presentationModel.createPresentation(
                        movieModel.getMovieByName(info.getParameters()[0]),
                        roomModel.getRoom(info.getRoomNum()),
                        info.getDate()
                        );
                     }
                     else {
                         throw new NullPointerException();
                     }
                    smallWindow.popup("successfull created");
                }
                catch (Exception ne){
                    smallWindow.popup("could not be created");
                }

            }
        };
    }
    private  void getPres(){
        String selection[] = smallWindow.returnSelection().split(", ");
        Instant presDate = LocalDate.parse(selection[0]).atStartOfDay().toInstant(ZoneOffset.UTC);
        Movie film = movieModel.getMovieByName(selection[2]);
        CinemaRoom room = roomModel.getRoom(selection[1]);
        pres = presentationModel.getPresentation(film,presDate,room);
    }
    private PresInfo getScreenInfo() throws IndexOutOfBoundsException{

        PresInfo info = new PresInfo();
        info.setParameters(smallWindow.getText());
        info.setRoomNum(Integer.parseInt(info.getParameters()[1])-1);
        info.setDate( LocalDate.parse(info.getParameters()[2]).atStartOfDay().toInstant(ZoneOffset.UTC));
        if(info.getRoomNum() > roomModel.getAllRooms().size() || info.getRoomNum() < 0){
            throw new IndexOutOfBoundsException();
        }

        return info;
    }
    private void createWindow(String fields[], String title, EventHandler<ActionEvent> multiEvent){
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

    public EventHandler<ActionEvent> getGetPresentation() {
        return getPresentation;
    }
}