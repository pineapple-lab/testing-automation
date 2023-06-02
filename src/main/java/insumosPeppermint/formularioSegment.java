package insumosPeppermint;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class formularioSegment extends Stage{
    public formularioSegment(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField pathImageJT = new TextField("path image");
        TextField pathVideoJT = new TextField("path video");
        TextField titleSegmentsJT = new TextField("title Segment");
        TextField descriptionSegmentsJT = new TextField("description Segment");
        TextField creatorSegmentsJT = new TextField("id creator Segment");
        TextField tagSegmentsJT = new TextField("id tag Segment");
        TextField transcriptSegmentsJT = new TextField("transcript segment");
        TextField categorySegmentsJT = new TextField("id category segment");
        TextField topicSegmentsJT = new TextField("id topic segment");
        TextField subTopicSegmentsJT = new TextField("id sub topic segment");
        TextField estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(pathImageJT,2,1);
        GridPane.setConstraints(pathVideoJT,4,1);
        GridPane.setConstraints(titleSegmentsJT,2,2);
        GridPane.setConstraints(descriptionSegmentsJT,4,2);
        GridPane.setConstraints(creatorSegmentsJT,2,3);
        GridPane.setConstraints(tagSegmentsJT,4,3);
        GridPane.setConstraints(transcriptSegmentsJT,2,4);
        GridPane.setConstraints(categorySegmentsJT,4,4);
        GridPane.setConstraints(topicSegmentsJT,2,5);
        GridPane.setConstraints(subTopicSegmentsJT,4,5);
        GridPane.setConstraints(estadoJT,2,6);
        GridPane.setConstraints(guardar,3,7);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String pathImage = pathImageJT.getText();
                String pathVideo = pathVideoJT.getText();
                String titleSegments = titleSegmentsJT.getText();
                String descriptionSegments = descriptionSegmentsJT.getText();
                String creatorSegments = creatorSegmentsJT.getText();
                String tagSegments = tagSegmentsJT.getText();
                String transcriptSegments = transcriptSegmentsJT.getText();
                String categorySegments = categorySegmentsJT.getText();
                String topicSegments = topicSegmentsJT.getText();
                String subTopicSegments = subTopicSegmentsJT.getText();
                String estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscrearsegment (" +
                        "`pathImage`," +
                        "`pathVideo`," +
                        "`titleSegments`," +
                        "`descriptionSegments`," +
                        "`creatorSegments`," +
                        "`tagSegments`," +
                        "`transcriptSegments`," +
                        "`categorySegments`," +
                        "`topicSegments`," +
                        "`subTopicSegments`," +
                        "`estado`,) " +
                        "VALUES("+
                        "'"+pathImage+"'"+","+
                        "'"+pathVideo+"'"+","+
                        "'"+titleSegments+"'"+","+
                        "'"+descriptionSegments+"'"+","+
                        "'"+creatorSegments+"'"+","+
                        "'"+tagSegments+"'"+","+
                        "'"+transcriptSegments+"'"+","+
                        "'"+categorySegments+"'"+","+
                        "'"+topicSegments+"'"+","+
                        "'"+subTopicSegments+"'"+","+
                            estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(pathImageJT);
        grid.getChildren().add(pathVideoJT);
        grid.getChildren().add(titleSegmentsJT);
        grid.getChildren().add(descriptionSegmentsJT);
        grid.getChildren().add(creatorSegmentsJT);
        grid.getChildren().add(tagSegmentsJT);
        grid.getChildren().add(transcriptSegmentsJT);
        grid.getChildren().add(categorySegmentsJT);
        grid.getChildren().add(topicSegmentsJT);
        grid.getChildren().add(subTopicSegmentsJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
