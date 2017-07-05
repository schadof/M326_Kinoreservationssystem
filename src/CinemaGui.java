import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Created by 11mmuellerde on 04.07.2017.
 */
public class CinemaGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }
        @Override
    public void start(Stage primaryStage) throws Exception {

        ClientAdministration clientModel = new ClientAdministration();
        RoomAdministration roomModel    = new RoomAdministration();
        MovieAdministration movieModel  = new MovieAdministration();
        PresentationAdministration presentationModel = new PresentationAdministration();
        CinemaControl control = new CinemaControl(roomModel,presentationModel,movieModel,clientModel);
        CinemaView view = new CinemaView(control);

        primaryStage.setScene(view.createView());
        primaryStage.setTitle("Kino Verwaltungssystem");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
