import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
    private Button multiButton;

    public SmallWindow(String names[],String title, EventHandler<ActionEvent> multiEvent){

        this.title = title;
        if(multiEvent != null) {
            this.multiButton = new Button("ok");
            this.multiButton.addEventHandler(ActionEvent.ACTION, multiEvent);
        }

        label = new ArrayList<Label>();
        txtField = new ArrayList<TextField>();
        for (int i = 0; i < names.length; i++){
            label.add(new Label(names[i]));
            txtField.add(new TextField());
        }

    }
    public void popup(String input){
        stage.setScene(new Scene( new Label(input), 100, 100));
    }
    public String[] getText(){
        String parameters[] = new String[label.size()];
        for(int i = 0; i < label.size(); i++) {
            parameters[i] = txtField.get(i).getText();
        }
        return parameters;
    }
    public void endWin(){
        stage.close();
    }
    public void startWin() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        for (int i = 0; i < label.size(); i++) {
            grid.add(label.get(i), 1, i);
            grid.add(txtField.get(i), 2, i);
            if(multiButton != null && i + 1 >= label.size() ){
                grid.add(multiButton,1, i+1 );
            }
        }

        flow = new FlowPane(Orientation.VERTICAL);
        flow.getChildren().add(grid);
        stage = new Stage();
        stage.setScene(new Scene(flow, 500, 500));
        stage.setTitle(title);
        stage.show();
    }
//  This will allow us to dynamically set aur selectionparameters
    public void selectionScreen(ArrayList<String> screenInfo, String screenLayout){
        checklist = new ArrayList<>();
        ScrollPane scroll = new ScrollPane();
        scroll.setMinWidth(500);
        for (int i = 0; i < screenInfo.size(); i++){
            checklist.add(new CheckBox(screenInfo.get(i)));
            scroll.setContent(checklist.get(i));
        }
        flow.getChildren().add(scroll);

    }
    public String returnSelection(){
        for(int i = 0; i < checklist.size(); i++){
            if(checklist.get(i).isSelected()){
                return  checklist.get(i).getText().toString();
            }
        }
        return null;
    }

}
