import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
 * Created by 11mmuellerde on 05.07.2017.
 */
public class CinemaView {
    private Button
            getCatalog, getFilm, getReservations, removeReservation
            , addClient, removeClient, createPresentaion, removePresentation;
    private GridPane grid;
    private BorderPane border;
    private Scene mainScene;
    private Image img;
    private ImageView imgView ;
    private CinemaControl control;

    public CinemaView(CinemaControl control){
        this.control = control;
    }
    private void createPanel(){
//      Screen Buttons
        getCatalog = new Button("Get Catalog");
        getFilm = new Button("Get Film Presentation");
        getReservations = new Button("Show Client Reservation");
        removeReservation = new Button("end Client Reservation");
        addClient = new Button("Add Client");
        removeClient = new Button("Remove Client");
        createPresentaion = new Button("Create Presentation");
        removePresentation = new Button("Remove Presentation");

        getCatalog.setPrefSize(200,20);
        getFilm.setPrefSize(200,20);
        getReservations.setPrefSize(200,20);
        removeReservation.setPrefSize(200,20);
        addClient.setPrefSize(200,20);
        removeClient.setPrefSize(200,20);
        createPresentaion.setPrefSize(200,20);
        removePresentation.setPrefSize(200,20);

//      Screen Logo
        img = new Image("LOGO.png");
        imgView = new ImageView(img);
        imgView.setFitWidth(img.getWidth()/2);
        imgView.setFitHeight(img.getHeight()/2);

//      Screen Layout
        grid = new GridPane();
        border = new BorderPane();

        grid.add(getCatalog, 1,1);
        grid.add(getFilm, 1,3);
        grid.add(removeReservation, 1,4);
        grid.add(addClient, 1,5);
        grid.add(removeClient, 1,6);
        grid.add(createPresentaion, 1,7);
        grid.add(removePresentation, 1,8);

        grid.setVgap(10);
        grid.setHgap(10);

        border.setLeft(grid);
        border.setRight(imgView);
        border.setStyle("-fx-background-color: #FFFF");

        mainScene = new Scene(border,500,300);
    }
    private void addEvent(){
      getCatalog.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Date"}, "Get Catalog", control.getReserveSeat()));
      getFilm.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Date", "Time", "Room"}, "Get Film", control.getReserveSeat()));
      getReservations.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Room", "Date", "Client"}, "get Reservation",null));
      removeReservation.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Room", "Date", "Client"}, "remove Reservation", control.getRemoveReservation()));
      addClient.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"full Name", "phone", "email"}, "look/add Client", control.getAddClient()));
      removeClient.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"full Name", "phone", "email"}, "remove Client", control.getRemoveClient()));
      createPresentaion.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Film", "Room", "Date"}, "create Presentation", control.getPresInfo()));
      removePresentation.addEventHandler(ActionEvent.ACTION, control.eventFactory(new String[]{"Film", "Room", "Date"}, "remove Presentation", control.getRemovePresentation()));
    }
    public Scene createView(){
        createPanel();
        addEvent();

        return mainScene;
    }



}
