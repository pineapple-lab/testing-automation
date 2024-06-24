package Docola;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class BotSettings extends InterfaceElements{
    Button undefinedUser = new Button("Undefineduser");
    public BotSettings(String environment){
        this.seleccion = environment;
    }
    public void start (Stage botSettings){
        GridPane gridBotSettings = new GridPane();
        gridBotSettings.setVgap(10);
        gridBotSettings.setHgap(10);
        gridBotSettings.add(undefinedUser,5,2);
        undefinedUser.setStyle("-fx-background-color:#298dcc;");
        undefinedUser.setOnMouseEntered(e -> undefinedUser.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        undefinedUser.setOnMouseExited(e -> undefinedUser.setStyle("-fx-background-color: #298dcc;"));
        rootConfigAvanzada.getChildren().add(gridBotSettings);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,199,170);
        botSettings.setScene(sceneConfigAvanzada);
        undefinedUser.setOnAction( event -> {
            //ejecuciones=tfExecute.getText();
            BotSettingDefaultUser configAvanzada = new BotSettingDefaultUser(seleccion);
            Stage botSettingsStage = new Stage();
            configAvanzada.start(botSettingsStage);
            botSettingsStage.show();
        });
    }
}
