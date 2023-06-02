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
public class formularioArticles extends Stage {
    public formularioArticles(){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField pathImageJT = new TextField("path image");
        TextField pathVideoJT = new TextField("path video");
        TextField titleArticleJT = new TextField("title Articles");
        TextField descriptionArticleJT = new TextField("description Articles");
        TextField creatorArticleJT = new TextField("id creator Articles");
        TextField tagArticleJT = new TextField("id tag Articles");
        TextField estimatedReadTimeJT = new TextField("estimated readtime Articles");
        TextField categoryArticleJT = new TextField("id category article");
        TextField topicArticleJT = new TextField("id topic article");
        TextField subTopicArticleJT = new TextField("id sub topic article");
        TextField contentTitleJT = new TextField("content title");
        TextField textContentJT = new TextField("text content");
        TextField estadoJT = new TextField("estado");
        Button guardar = new Button("Guardar");
        GridPane.setConstraints(pathImageJT,2,1);
        GridPane.setConstraints(pathVideoJT,4,1);
        GridPane.setConstraints(pathImageJT,2,2);
        GridPane.setConstraints(pathVideoJT,4,2);
        GridPane.setConstraints(titleArticleJT,2,3);
        GridPane.setConstraints(descriptionArticleJT,4,3);
        GridPane.setConstraints(creatorArticleJT,2,4);
        GridPane.setConstraints(tagArticleJT,4,4);
        GridPane.setConstraints(estimatedReadTimeJT,2,5);
        GridPane.setConstraints(categoryArticleJT,4,5);
        GridPane.setConstraints(topicArticleJT,2,6);
        GridPane.setConstraints(subTopicArticleJT,4,6);
        GridPane.setConstraints(contentTitleJT,2,7);
        GridPane.setConstraints(textContentJT,4,7);
        GridPane.setConstraints(estadoJT,2,8);
        GridPane.setConstraints(guardar,3,9);
         guardar.setOnAction(e->{
            try{
                String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                String username = "root";
                String password = "root";
                Connection CN = DriverManager.getConnection(url, username, password);
                String pathImage = pathImageJT.getText();
                String pathVideo = pathVideoJT.getText();
                String titleArticle = titleArticleJT.getText();
                String descriptionArticle = descriptionArticleJT.getText();
                String creatorArticle = creatorArticleJT.getText();
                String tagArticle = tagArticleJT.getText();
                String estimatedReadTime = estimatedReadTimeJT.getText();
                String categoryArticle = categoryArticleJT.getText();
                String topicArticle = topicArticleJT.getText();
                String subTopicArticle = subTopicArticleJT.getText();
                String contentTitle = contentTitleJT.getText();
                String textContent = contentTitleJT.getText();
                String estado = estadoJT.getText();
                String insertSql = "INSERT INTO datoscreararticle (" +
                        "`pathImage`," +
                        "`pathVideo`," +
                        "`titleArticle`," +
                        "`descriptionArticle`," +
                        "`creatorArticle`," +
                        "`tagArticle`," +
                        "`estimatedReadTime`," +
                        "`categoryArticle`," +
                        "`topicArticle`," +
                        "`subTopicArticle`," +
                        "`contentTitle`," +
                        "`textContent`," +
                        "`estado`) " +
                        "VALUES("+
                        "'"+pathImage+"'"+","+
                        "'"+pathVideo+"'"+","+
                        "'"+titleArticle+"'"+","+
                        "'"+descriptionArticle+"'"+","+
                        "'"+creatorArticle+"'"+","+
                        "'"+tagArticle+"'"+","+
                        "'"+estimatedReadTime+"'"+","+
                        "'"+categoryArticle+"'"+","+
                        "'"+topicArticle+"'"+","+
                        "'"+subTopicArticle+"'"+","+
                        "'"+contentTitle+"'"+","+
                        "'"+textContent+"'"+
                        ","+estado+")";
                Statement stmt = CN.createStatement();
                stmt.executeUpdate(insertSql);
                CN.close();
            }catch (Exception ex){ex.printStackTrace();}
        });
        grid.getChildren().add(pathImageJT);
        grid.getChildren().add(pathVideoJT);
        grid.getChildren().add(titleArticleJT);
        grid.getChildren().add(descriptionArticleJT);
        grid.getChildren().add(creatorArticleJT);
        grid.getChildren().add(tagArticleJT);
        grid.getChildren().add(estimatedReadTimeJT);
        grid.getChildren().add(categoryArticleJT);
        grid.getChildren().add(topicArticleJT);
        grid.getChildren().add(subTopicArticleJT);
        grid.getChildren().add(contentTitleJT);
        grid.getChildren().add(textContentJT);
        grid.getChildren().add(estadoJT);
        grid.getChildren().add(guardar);
        Scene scene = new Scene(grid,400,400);
        setScene(scene);
        }
    public static void main(String[]args){
        Application.launch();
    }
}
