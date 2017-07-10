import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 04.07.2017.
 * the Class will Dynamically adjust itself, depending on the parameter, thus allowing for more broad use
 */
public class SmallWindow {

    private ArrayList<Label> label;
    private ArrayList<TextField> txtField;
    private ArrayList<CheckBox> checklist;
    private String title;
    private FlowPane flow;
    private Stage stage;

    public SmallWindow(String names[],String title){

        this.title = title;

        label = new ArrayList<Label>();
        txtField = new ArrayList<TextField>();
        for (int i = 0; i < names.length; i++){
            label.add(new Label(names[i]));
            txtField.add(new TextField());
        }

    }
    public void endWin(){
        stage.close();
    }
    public void startWin() {
        GridPane grid;

        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        for (int i = 0; i < label.size(); i++) {
            grid.add(label.get(i), 1, i);
            grid.add(txtField.get(i), 2, i);
        }

        flow = new FlowPane(grid);
        stage = new Stage();
        stage.setScene(new Scene(flow, 500, 500));
        stage.setTitle(title);
        stage.show();
    }
//  This will allow us to dynamically set aur selectionparameters
    public void selectionScreen(String screenInfo[], String screenLayout){
        checklist = new ArrayList<>();
        ScrollPane scroll = new ScrollPane();
        for (int i = 0; i < screenInfo.length; i++){
            checklist.add(new CheckBox(screenInfo[i]));
            scroll.setContent(checklist.get(i));
        }
        flow.getChildren().add(scroll);

    }

}
