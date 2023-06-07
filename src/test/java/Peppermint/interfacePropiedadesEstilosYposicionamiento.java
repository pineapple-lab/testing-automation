package Peppermint;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class interfacePropiedadesEstilosYposicionamiento extends interfaceElements{
    @Override
    public void start(Stage stage) {
        //PROPIEDADES
        consoleTextArea.setEditable(false);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        grid.setHgap(3);
        grid.setVgap(10);
        //ESTILOS
        crearWorkshop.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        enrollWorkshop.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearArticle.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearClub.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTechnique.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearClubEvent.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTaxonomy.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTag.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearLesson.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearSegment.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearUsuario.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        enviarSolicitudDeAmistad.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        joinClub.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        generarPostClub.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        deneterCasoDePrueba.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        ejecutar.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        removerDeLaCola.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        generarInviteGuest.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        scrollPane.setStyle(" -fx-text-fill: #FFFFFF; -fx-control-inner-background:#000000;");
        comboBox.setStyle("-fx-background-color: #99D0C2;");
        //POSICIONAMIENTO
        GridPane.setConstraints(comboBox,2,1);
        GridPane.setConstraints(ejecucionestf,2,2);
        GridPane.setConstraints(ejecutar, 3, 1);
        GridPane.setConstraints(deneterCasoDePrueba,4,1);
        GridPane.setConstraints(removerDeLaCola, 5, 1);
        GridPane.setConstraints(crearWorkshop, 2, 3);
        GridPane.setConstraints(enrollWorkshop, 2, 4);
        GridPane.setConstraints(crearArticle, 2, 5);
        GridPane.setConstraints(crearClub, 2, 6);
        GridPane.setConstraints(crearTechnique, 2, 7);
        GridPane.setConstraints(crearClubEvent, 2, 8);
        GridPane.setConstraints(crearTaxonomy, 2, 9);
        GridPane.setConstraints(crearTag, 2, 10);
        GridPane.setConstraints(crearLesson, 2, 11);
        GridPane.setConstraints(crearSegment, 2, 12);
        GridPane.setConstraints(crearUsuario, 2, 13);
        GridPane.setConstraints(enviarSolicitudDeAmistad, 3, 3);
        GridPane.setConstraints(joinClub, 3, 4);
        GridPane.setConstraints(generarInviteGuest, 3, 5);
        GridPane.setConstraints(generarPostClub, 3, 6);
        GridPane.setConstraints(scrollPane,1,15,5,15);
        //AGREGAR ELEMENTOS
        grid.getChildren().add(comboBox);
        grid.getChildren().add(ejecucionestf);
        grid.getChildren().add(deneterCasoDePrueba);
        grid.getChildren().add(ejecutar);
        grid.getChildren().add(removerDeLaCola);
        grid.getChildren().add(crearWorkshop);
        grid.getChildren().add(enrollWorkshop);
        grid.getChildren().add(crearArticle);
        grid.getChildren().add(crearClub);
        grid.getChildren().add(crearTechnique);
        grid.getChildren().add(crearClubEvent);
        grid.getChildren().add(crearTaxonomy);
        grid.getChildren().add(crearTag);
        grid.getChildren().add(crearLesson);
        grid.getChildren().add(crearSegment);
        grid.getChildren().add(crearUsuario);
        grid.getChildren().add(enviarSolicitudDeAmistad);
        grid.getChildren().add(joinClub);
        grid.getChildren().add(generarPostClub);
        grid.getChildren().add(generarInviteGuest);
        grid.getChildren().add(scrollPane);
        comboBox.getItems().add("DEV");
        comboBox.getItems().add("QA");
        comboBox.setValue("Elegir ambiente");
        Scene scene = new Scene (grid,490, 670);
        stage.setScene(scene);
        stage.show();
    }
}
