package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.*;

public class AdvancedSettingContentCreator extends InterfaceElements {
    private volatile boolean isRunning = true;
    Label labelContentTitle = new Label ("Title");
    TextField tfContentTitle = new TextField();
    Button settingAdvancedExecute = new Button("Ejecutar");
    Tab tbUploadFile = new Tab("Upload file");
    Tab tbCaptureVideo = new Tab("Capture video");
    Tab tbQuiz = new Tab("Quiz");
    Tab tbSurvey = new Tab("Survey");
    Tab tbVR = new Tab("VR");
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    BotDocola accion = new BotDocola();
    public AdvancedSettingContentCreator(String executionDetailsAvanzadas , String seleccionAvanzada){

        this.vDocola.executionDetails = executionDetailsAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    @Override
    public void start(Stage stageJoin) {
        stageJoin.setTitle("Configuraciones creacion de contenido");
        TabPane tabPane = new TabPane();

        GridPane gridUploadFile = new GridPane();
        gridUploadFile.setVgap(10);
        gridUploadFile.setHgap(10);
        gridUploadFile.add(labelContentTitle,2,2);
        gridUploadFile.add(tfContentTitle,2,3);
        tbUploadFile.setContent(gridUploadFile);

        GridPane gridCaptureVideo = new GridPane();
        gridCaptureVideo.setVgap(10);
        gridCaptureVideo.setHgap(10);
        tbCaptureVideo.setContent(gridCaptureVideo);

        GridPane gridQuiz = new GridPane();
        gridQuiz.setVgap(10);
        gridQuiz.setHgap(10);
        tbQuiz.setContent(gridQuiz);

        GridPane gridSurvey = new GridPane();
        gridSurvey.setVgap(10);
        gridSurvey.setHgap(10);
        tbSurvey.setContent(gridSurvey);

        GridPane gridVR = new GridPane();
        gridVR.setVgap(10);
        gridVR.setHgap(10);
        tbVR.setContent(gridVR);

        tabPane.getTabs().addAll(tbUploadFile,tbCaptureVideo,tbQuiz,tbSurvey,tbVR);

        GridPane mainLayout = new GridPane();

        mainLayout.setVgap(10);
        mainLayout.setHgap(10);
        mainLayout.add(tabPane, 0, 0);
        HBox buttonContainer = new HBox();
        buttonContainer.getChildren().add(settingAdvancedExecute);

        mainLayout.add(buttonContainer, 20, 6);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabPane, mainLayout);
        //vbox.setAlignment(Pos.TOP_CENTER);

        settingAdvancedExecute.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingAdvancedExecute.setOnMouseEntered(e -> settingAdvancedExecute.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingAdvancedExecute.setOnMouseExited(e -> settingAdvancedExecute.setStyle("-fx-background-color: #5bb346;"));
        tfContentTitle.setPromptText("Content title");
        tbUploadFile.setOnSelectionChanged(event -> {
            if (tbUploadFile.isSelected()) {
                resourceType = "Upload file";
            }
        });
        tbCaptureVideo.setOnSelectionChanged(event -> {
            if (tbCaptureVideo.isSelected()) {
                VariablesDocola.resourceType = "Capture video";
            }
        });

        tbQuiz.setOnSelectionChanged(event -> {
            if (tbQuiz.isSelected()) {
                VariablesDocola.resourceType = "Quiz";
            }
        });

        tbSurvey.setOnSelectionChanged(event -> {
            if (tbSurvey.isSelected()) {
                VariablesDocola.resourceType = "Survey";
            }
        });

        tbVR.setOnSelectionChanged(event -> {
            if (tbVR.isSelected()) {
                VariablesDocola.resourceType = "VR";
            }
        });
        Scene sceneConfigAvanzada = new Scene(vbox,310,190);
        stageJoin.setScene(sceneConfigAvanzada);
        settingAdvancedExecute.setOnAction(e->{
            Thread execute=  new Thread (()->{
                contentTitle = tfContentTitle.getText();
                System.out.println(contentTitle);
                iActions.actionNewResource();
                cleanWaitingList();
            }, "execute");
            if(isRunning) {
                mDocola.startTest();
                execute.start();
            }
        });
    }
    private void cleanWaitingList(){
        waitingList.clear();
        userEmail = null;
        resourceType = "";
    }
}
