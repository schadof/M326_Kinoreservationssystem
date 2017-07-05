import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 04.07.2017.
 */
public class SmallWindow {

    private ArrayList<Label> label;
    private ArrayList<TextField> txtField;
    private String title;

    public SmallWindow(String names[],String title){

        this.title = title;

        label = new ArrayList<Label>();
        txtField = new ArrayList<TextField>();
        for (int i = 0; i < names.length; i++){
            label.add(new Label(names[i]));
            txtField.add(new TextField());
        }

    }
    public void startWin(){
        Stage stage;
        GridPane grid;

        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        for(int i = 0; i < label.size(); i++){
            grid.add(label.get(i), 1, i);
            grid.add(txtField.get(i), 2, i);
        }

        stage = new Stage();
        stage.setScene(new Scene(grid, 500, 500));
        stage.setTitle(title);
        stage.show();
    }

}
