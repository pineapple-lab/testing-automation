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
public class formularioTaxonomy extends Stage{
    public formularioTaxonomy(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField  titleCategoryJT = new TextField("title category");
        TextField  titleTopicJT = new TextField("title topic");
        TextField  titleSubTopicJT = new TextField("title sub topic");
        TextField  estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(titleCategoryJT,2,1);
        GridPane.setConstraints(titleTopicJT,4,1);
        GridPane.setConstraints(titleSubTopicJT,2,2);
        GridPane.setConstraints(estadoJT,4,2);
        GridPane.setConstraints(estadoJT,2,3);
        GridPane.setConstraints(guardar,3,4);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String   titleCategory = titleCategoryJT.getText();
                String   titleTopic = titleTopicJT.getText();
                String   titleSubTopic = titleSubTopicJT.getText();
                String   estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscreartaxonomy (" +
                        "`titleCategory`," +
                        "`titleTopic`," +
                        "`titleSubTopic`," +
                        "`estado`)" +
                        "VALUES("+
                        "'"+titleCategory+"'"+","+
                        "'"+titleTopic+"'"+","+
                        "'"+titleSubTopic+"'"+","+
                            estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(titleCategoryJT);
        grid.getChildren().add(titleTopicJT);
        grid.getChildren().add(titleSubTopicJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
