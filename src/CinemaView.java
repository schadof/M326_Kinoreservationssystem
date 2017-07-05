import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Created by 11mmuellerde on 05.07.2017.
 */
public class CinemaView {
    private Button getCatalog, getFilm, reserveSeat, getReservations, removeReservation;
    private GridPane grid;
    private BorderPane border;
    private Scene mainScene;
    private CinemaControll  controll;

    public CinemaView(CinemaControll  controll){
        this.controll = controll;
    }
    private void createPanel(){
        getCatalog = new Button("Get Catalog");
        getFilm = new Button("Get Film Presentation");
        reserveSeat = new Button("Reserve a Seat");
        getReservations = new Button("Show Client Reservation");
        removeReservation = new Button("end Client Reservation");

        getCatalog.setPrefSize(200,20);
        getFilm.setPrefSize(200,20);
        reserveSeat.setPrefSize(200,20);
        getReservations.setPrefSize(200,20);
        removeReservation.setPrefSize(200,20);

        grid = new GridPane();
        border = new BorderPane();

        grid.add(getCatalog, 1,1);
        grid.add(getFilm, 1,2);
        grid.add(reserveSeat, 1,3);
        grid.add(removeReservation, 1,4);

        grid.setVgap(10);
        grid.setHgap(10);
        border.setLeft(grid);

        mainScene = new Scene(border,500,300);

    }
    private void addEvent(){
//      getCatalog.add;
//      getFilm.
//      reserveSeat.
//      getReservations.
    }
    public Scene createView(){
        createPanel();
        addEvent();

        return mainScene;
    }



}
