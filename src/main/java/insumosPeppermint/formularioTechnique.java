package insumosPeppermint;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
public class formularioTechnique extends Stage{
    public formularioTechnique(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField imagePathJT= new TextField("path image");
        TextField videoPathJT= new TextField("path video");
        TextField titleTechniqueJT= new TextField("title Technique");
        TextField descriptionTechniqueJT= new TextField("description Technique");
        TextField creatorTechniqueJT= new TextField("id creator Technique");
        TextField tagTechniqueJT= new TextField("id tag Technique");
        TextField categoryTechniqueJT= new TextField("id category Technique");
        TextField topicTechniqueJT= new TextField("id topic Technique");
        TextField subTopicTechniqueJT= new TextField("id sub topic Technique");
        TextField estadoJT= new TextField("estado");
        Button guardar= new Button("Guardar");
        GridPane.setConstraints(imagePathJT,2,1);
        GridPane.setConstraints(videoPathJT,4,1);
        GridPane.setConstraints(titleTechniqueJT,2,2);
        GridPane.setConstraints(descriptionTechniqueJT,4,2);
        GridPane.setConstraints(creatorTechniqueJT,2,3);
        GridPane.setConstraints(tagTechniqueJT,4,3);
        GridPane.setConstraints(categoryTechniqueJT,2,4);
        GridPane.setConstraints(topicTechniqueJT,4,4);
        GridPane.setConstraints(subTopicTechniqueJT,2,5);
        GridPane.setConstraints(estadoJT,4,5);
        GridPane.setConstraints(guardar,2,6);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String imagePath = imagePathJT.getText();
                String videoPath = videoPathJT.getText();
                String titleTechnique = titleTechniqueJT.getText();
                String descriptionTechnique = descriptionTechniqueJT.getText();
                String creatorTechnique = creatorTechniqueJT.getText();
                String tagTechnique = tagTechniqueJT.getText();
                String categoryTechnique = categoryTechniqueJT.getText();
                String topicTechnique = topicTechniqueJT.getText();
                String subTopicTechnique = subTopicTechniqueJT.getText();
                String estado = estadoJT.getText();

                String insertSql = "INSERT INTO datoscreartechnique (`imagePath`,`videoPath`,`titleTechnique`,`descriptionTechnique`,`creatorTechnique`,`tagTechnique`,`categoryTechnique`,`topicTechnique`,`subTopicTechnique`,`estado`) " +
                        "VALUES("+"'"+imagePath+"'"+","+ "'"+videoPath+"'"+","+"'"+titleTechnique+"'"+","+"'"+descriptionTechnique+"'"+","+"'"+creatorTechnique+"'"+","+"'"+tagTechnique+"'"+","+
                        "'"+categoryTechnique+"'"+","+"'"+topicTechnique+"'"+","+"'"+subTopicTechnique+"'"+","+estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(imagePathJT);
        grid.getChildren().add(videoPathJT);
        grid.getChildren().add(titleTechniqueJT);
        grid.getChildren().add(descriptionTechniqueJT);
        grid.getChildren().add(creatorTechniqueJT);
        grid.getChildren().add(tagTechniqueJT);
        grid.getChildren().add(categoryTechniqueJT);
        grid.getChildren().add(topicTechniqueJT);
        grid.getChildren().add(subTopicTechniqueJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
