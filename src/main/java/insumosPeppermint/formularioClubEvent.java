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
public class formularioClubEvent extends Stage {
    public formularioClubEvent(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField  titleEventJT = new TextField("title event");
        TextField  ZoomURLEventJT = new TextField("zoom url");
        TextField  descriptionEventJT = new TextField("description event");
        TextField  estadoJT = new TextField("estado");
        TextField  clubsEventJT = new TextField("id club");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(titleEventJT,2,1);
        GridPane.setConstraints(ZoomURLEventJT,4,1);
        GridPane.setConstraints(descriptionEventJT,2,2);
        GridPane.setConstraints(estadoJT,4,2);
        GridPane.setConstraints(clubsEventJT,2,3);
        GridPane.setConstraints(guardar,3,4);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String  titleEvent = titleEventJT.getText();
                String  ZoomURLEvent = ZoomURLEventJT.getText();
                String  descriptionEvent = descriptionEventJT.getText();
                String  estado = estadoJT.getText();
                String  clubsEvent = clubsEventJT.getText();
                String insertSql = "INSERT INTO datoscrearclubevent (" +
                        "`titleEvent`," +
                        "`ZoomURLEvent`," +
                        "`descriptionEvent`," +
                        "`estado`," +
                        "`clubsEvent`) " +
                        "VALUES("+
                        "'"+titleEvent+"'"+","+
                        "'"+ZoomURLEvent+"'"+","+
                        "'"+descriptionEvent+"'"+","+
                            estado+","+
                        "'"+clubsEvent+"'"+
                        ")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(titleEventJT);
        grid.getChildren().add(ZoomURLEventJT);
        grid.getChildren().add(descriptionEventJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(clubsEventJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
