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
    private Button getCatalog, getFilm, reserveSeat, getReservations, removeReservation;
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
        getCatalog = new Button("Get Catalog");
        getFilm = new Button("Get Film Presentation");
        reserveSeat = new Button("Reserve a Seat");
        getReservations = new Button("Show Client Reservation");
        removeReservation = new Button("end Client Reservation");
        img = new Image("LOGO.png");
        imgView = new ImageView(img);
        imgView.setFitWidth(img.getWidth()/2);
        imgView.setFitHeight(img.getHeight()/2);

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
        border.setRight(imgView);
        border.setStyle("-fx-background-color: #FFFF");

        mainScene = new Scene(border,500,300);

    }
    private void addEvent(){
      getCatalog.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
              SmallWindow smallWindow = new SmallWindow(new String[]{});
              smallWindow.startWin();

          }
      });

      getFilm.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
            SmallWindow smallWindow = new SmallWindow(new String[]{});
            smallWindow.startWin();

        }
    });
      reserveSeat.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
            SmallWindow smallWindow = new SmallWindow(new String[]{});
            smallWindow.startWin();

        }
    });
      getReservations.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
            SmallWindow smallWindow = new SmallWindow(new String[]{});
            smallWindow.startWin();

        }
    });
      removeReservation.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//              control.getPresentationAdmin().getAllPresentations();
                SmallWindow smallWindow = new SmallWindow(new String[]{});
                smallWindow.startWin();

            }
        });
    }
    public Scene createView(){
        createPanel();
        addEvent();

        return mainScene;
    }



}
