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

public class formularioTag extends Stage{
    public formularioTag(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField  titleTagJT = new TextField("title category");
        TextField  estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(titleTagJT,2,1);
        GridPane.setConstraints(estadoJT,4,1);
        GridPane.setConstraints(guardar,3,2);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String    titleTag = titleTagJT.getText();
                String    estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscreartag (" +
                        "`titleTag`," +
                        "`estado`,)" +
                        "VALUES("+
                        "'"+titleTag+"'"+","
                           +estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(titleTagJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
