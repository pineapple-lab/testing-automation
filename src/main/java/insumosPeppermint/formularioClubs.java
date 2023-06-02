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
public class formularioClubs extends Stage {
    public formularioClubs(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField pathImageJT = new TextField("path image");
        TextField titleClubJT = new TextField("title Club");
        TextField descriptionClubJT = new TextField("description club");
        TextField creatorClubJT = new TextField("id creator Club");
        TextField tagClubJT = new TextField("id tag Club");
        TextField categoryClubJT = new TextField("id category Club");
        TextField topicClubJT = new TextField("id topic Club");
        TextField subTopicClubJT = new TextField("id sub topic Club");
        TextField estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(pathImageJT,2,1);
        GridPane.setConstraints(titleClubJT,4,1);
        GridPane.setConstraints(descriptionClubJT,2,2);
        GridPane.setConstraints(creatorClubJT,4,2);
        GridPane.setConstraints(tagClubJT,2,3);
        GridPane.setConstraints(categoryClubJT,4,3);
        GridPane.setConstraints(topicClubJT,2,4);
        GridPane.setConstraints(subTopicClubJT,4,4);
        GridPane.setConstraints(estadoJT,2,5);
        GridPane.setConstraints(guardar,3,6);
        guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String pathImage = pathImageJT.getText();
                String titleClub = titleClubJT.getText();
                String descriptionClub = descriptionClubJT.getText();
                String creatorClub = creatorClubJT.getText();
                String tagClub = tagClubJT.getText();
                String categoryClub = categoryClubJT.getText();
                String topicClub = topicClubJT.getText();
                String subTopicClub = subTopicClubJT.getText();
                String estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscrearclub (`pathImage`,`titleClub`,`descriptionClub`,`creatorClub`,`tagClub`,`categoryClub`,`topicClub`,`subTopicClub`,`estado`,`ejecuciones`) " +
                        "VALUES("+"'"+pathImage+"'"+","+"'"+titleClub+"'"+","+"'"+descriptionClub+"'"+","+"'"+creatorClub+"'"+","+"'"+tagClub+"'"+","+
                        "'"+categoryClub+"'"+","+"'"+topicClub+"'"+","+"'"+subTopicClub+"'"+","+estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(pathImageJT);
        grid.getChildren().add(titleClubJT);
        grid.getChildren().add(descriptionClubJT);
        grid.getChildren().add(creatorClubJT);
        grid.getChildren().add(tagClubJT);
        grid.getChildren().add(categoryClubJT);
        grid.getChildren().add(topicClubJT);
        grid.getChildren().add(subTopicClubJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
    }
    public static void main(String[]args){
        Application.launch();
    }
}
