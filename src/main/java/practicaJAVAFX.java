import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class practicaJAVAFX extends Application {
    public static void main(String[]args){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage1){
        stage1.setTitle("hello JavaFX");
        GridPane grid = new GridPane();
        Button b1 = new Button ("First button");
        Button b2 = new Button ("second button");
        GridPane.setConstraints(b1,1,1);
        GridPane.setConstraints(b2,1,2);
        grid.getChildren().addAll(b1,b2);
        Scene scene = new Scene (grid,300, 500);
        stage1.setScene(scene);
        stage1.setAlwaysOnTop(true);
        stage1.show();
    }
}
