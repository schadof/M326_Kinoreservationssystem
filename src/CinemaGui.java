import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 04.07.2017.
 */
public class CinemaGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }
        @Override
    public void start(Stage primaryStage) throws Exception {


//      Todo: implement checkbox array in small window like in Modmanager
//      Todo: implement test data
//      Todo: implement controls in smallWindow and bind them to the corresponding events in CinemaControl
//      Todo: Documentation in code
//      Todo: Add Client button Remove and Add
//      Todo: Implement Administration methods in events CinemaControl

//      This are the Model class, where we store all of our information
        ClientAdministration clientModel = new ClientAdministration();
        RoomAdministration roomModel    = new RoomAdministration();
        MovieAdministration movieModel  = new MovieAdministration();
        PresentationAdministration presentationModel = new PresentationAdministration();

//      The Control will morph the Data
        CinemaControl control = new CinemaControl(roomModel,presentationModel,movieModel,clientModel);
//      the View will display it
        CinemaView view = new CinemaView(control);

        primaryStage.setScene(view.createView());
        primaryStage.setTitle("Kino Verwaltungssystem");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
