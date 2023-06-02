package insumosPeppermint;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class botINSERT extends Application {
    public static void main(String[]args){
        Application.launch();
    }
    @Override
    public void start (Stage stage){ {
        ComboBox <String> comboBox = new ComboBox<>();
        HBox hbox = new HBox();
        comboBox.getItems().add("Add Workshops");
        comboBox.getItems().add("Add Techniques");
        comboBox.getItems().add("Add Articles");
        comboBox.getItems().add("Add clubs");
        comboBox.getItems().add("Add club event");
        comboBox.getItems().add("Add Taxonomy");
        comboBox.getItems().add("Add Tag");
        comboBox.getItems().add("Add lesson");
        comboBox.getItems().add("Add segment");
        comboBox.setValue("Select a form");
        GridPane.setConstraints(comboBox, 2, 2);
        comboBox.setOnAction(e->{
            String seleccion = comboBox.getValue();
            if (seleccion.equals("Add Workshops")) {
                formularioWorkshop form = new formularioWorkshop();
                form.show();
            } else if (seleccion.equals("Add Techniques")) {
                formularioTechnique form2 = new formularioTechnique();
                form2.show();
            } else if (seleccion.equals("Add Articles")) {
                formularioArticles form3 = new formularioArticles();
                form3.show();
            } else if (seleccion.equals("Add clubs")) {
                formularioClubs form4 = new formularioClubs();
                form4.show();
            } else if (seleccion.equals("Add club event")) {
                formularioClubEvent form5 = new formularioClubEvent();
                form5.show();
            } else if (seleccion.equals("Add Taxonomy")) {
                formularioTaxonomy form6 = new formularioTaxonomy();
                form6.show();
            } else if (seleccion.equals("Add Tag")) {
                formularioTag form7 = new formularioTag();
                form7.show();
            } else if (seleccion.equals("Add lesson")) {
                formularioLesson form8 = new formularioLesson();
                form8.show();
            } else if (seleccion.equals("Add segment")) {
                formularioSegment form9 = new formularioSegment();
                form9.show();
            }
        });
        hbox.getChildren().add(comboBox);
        Scene scene = new Scene(hbox,400,400);
        stage.setScene(scene);
        stage.show();
        }
    }
}


