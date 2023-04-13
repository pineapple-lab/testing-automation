package insumosPeppermint;

import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class formularioLesson extends Stage {
    public formularioLesson(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField pathImageJT = new TextField("path image");
        TextField titleLessonJT = new TextField("title lesson");
        TextField descriptionLessonJT = new TextField("description lesson");
        TextField creatorLessonJT = new TextField("id creator lesson");
        TextField tagLessonJT = new TextField("id tag lesson");
        TextField categoryLessonJT = new TextField("id category lesson");
        TextField topicLessonJT = new TextField("id topic lesson");
        TextField subTopicLessonJT = new TextField("id subtopic lesson");
        TextField estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(pathImageJT,2,1);
        GridPane.setConstraints(titleLessonJT,4,1);
        GridPane.setConstraints(descriptionLessonJT,2,2);
        GridPane.setConstraints(creatorLessonJT,4,2);
        GridPane.setConstraints(tagLessonJT,2,3);
        GridPane.setConstraints(categoryLessonJT,4,3);
        GridPane.setConstraints(topicLessonJT,2,4);
        GridPane.setConstraints(subTopicLessonJT,4,4);
        GridPane.setConstraints(estadoJT,2,5);
        GridPane.setConstraints(guardar,3,6);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String pathImage = pathImageJT.getText();
                String titleLesson = titleLessonJT.getText();
                String descriptionLesson = descriptionLessonJT.getText();
                String creatorLesson = creatorLessonJT.getText();
                String tagLesson = tagLessonJT.getText();
                String categoryLesson = categoryLessonJT.getText();
                String topicLesson = topicLessonJT.getText();
                String subTopicLesson = subTopicLessonJT.getText();
                String estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscrearlesson (" +
                        "`pathImage`," +
                        "`titleLesson`," +
                        "`descriptionLesson`," +
                        "`creatorLesson`," +
                        "`tagLesson`," +
                        "`categoryLesson`," +
                        "`topicLesson`," +
                        "`subTopicLesson`," +
                        "`estado`," +
                        "VALUES("+
                        "'"+pathImage+"'"+","+
                        "'"+titleLesson+"'"+","+
                        "'"+descriptionLesson+"'"+","+
                        "'"+creatorLesson+"'"+","+
                        "'"+tagLesson+"'"+","+
                        "'"+categoryLesson+"'"+","+
                        "'"+topicLesson+"'"+","+
                        "'"+subTopicLesson+"'"+","+
                        "'"+estado+"')";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
         grid.getChildren().add(pathImageJT);
         grid.getChildren().add(titleLessonJT);
         grid.getChildren().add(descriptionLessonJT);
         grid.getChildren().add(creatorLessonJT);
         grid.getChildren().add(tagLessonJT);
         grid.getChildren().add(categoryLessonJT);
         grid.getChildren().add(topicLessonJT);
         grid.getChildren().add(subTopicLessonJT);
         grid.getChildren().add(estadoJT);
         grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
