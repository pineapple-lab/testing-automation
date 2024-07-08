package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static InsumosDocola.VariablesDocola.resourceType;
import static InsumosDocola.VariablesDocola.userEmail;

public class BotSettingDefaultUser extends InterfaceElements {
    private volatile boolean isRunning = true;
    Label labelEmail = new Label ("Userdefined");
    Label setRol = new Label("Set rol");
    Label setEnvironment = new Label("Set environment");
    TextField tfEmail = new TextField();
    Button settingSave = new Button("Guardar");
    Tab tbUndefinedEmail = new Tab();
    RadioButton radioButtonContentProvider = new RadioButton("Content provider");
    RadioButton radioButtonClinician = new RadioButton("Cilnician");
    RadioButton radioButtonPatient = new RadioButton("Patient");
    RadioButton radioButtonDev = new RadioButton("Dev");
    RadioButton radioButtonLocal = new RadioButton("Local");
    MethodsDocola mDocola = new MethodsDocola();
    VariablesDocola vDocola = new VariablesDocola();
    InterfaceActions iActions = new InterfaceActions();
    public BotSettingDefaultUser(String environment){
        this.seleccion = environment;
    }
    @Override
    public void start(Stage undefineduserSetting) {
        undefineduserSetting.setTitle("Undefined User");
        GridPane gridPaneUndefinedSettings = new GridPane();
        gridPaneUndefinedSettings.setVgap(10);
        gridPaneUndefinedSettings.setHgap(10);
        gridPaneUndefinedSettings.add(labelEmail,2,1);
        gridPaneUndefinedSettings.add(tfEmail,2,2);
        gridPaneUndefinedSettings.add(setEnvironment,2,3);
        gridPaneUndefinedSettings.add(radioButtonDev,2,4);
        gridPaneUndefinedSettings.add(radioButtonLocal,3,4);
        gridPaneUndefinedSettings.add(setRol,2,6);
        gridPaneUndefinedSettings.add(radioButtonContentProvider,2,7);
        gridPaneUndefinedSettings.add(radioButtonClinician,3,7);
        gridPaneUndefinedSettings.add(radioButtonPatient,4,7);
        gridPaneUndefinedSettings.add(settingSave,6,9);
        settingSave.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #5bb346;");
        settingSave.setOnMouseEntered(e -> settingSave.setStyle("-fx-background-color: #6ec957; -fx-text-fill: white;"));
        settingSave.setOnMouseExited(e -> settingSave.setStyle("-fx-background-color: #5bb346;"));
        tfEmail.setPromptText("Userdefined");
        tbUndefinedEmail.setContent(gridPaneUndefinedSettings);
        tabPane.getTabs().addAll(tbUndefinedEmail);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,450,280);
        undefineduserSetting.setScene(sceneConfigAvanzada);
        radioButtonDev.setOnAction(e->{
            if(radioButtonDev.isSelected()){
                vDocola.navigationLink="https://docolasandbox.web.app/";
            }else if(radioButtonDev.isDisabled()){
                vDocola.navigationLink=null;
            }
        });
        radioButtonLocal.setOnAction(e->{
            if(radioButtonLocal.isSelected()){
                vDocola.navigationLink="http://localhost:4200/";
            }else if(radioButtonLocal.isDisabled()){
                vDocola.navigationLink=null;
            }
        });
        radioButtonContentProvider.setOnAction(e->{
            if(radioButtonContentProvider.isSelected()){
                vDocola.userRole ="Content provider";
            }else if(radioButtonContentProvider.isDisabled()){
                vDocola.userRole =null;
            }
        });
        radioButtonClinician.setOnAction(e->{
            if(radioButtonClinician.isSelected()){
                vDocola.userRole ="Clinician";
            }else if(radioButtonClinician.isDisabled()){
                vDocola.userRole =null;
            }
        });
        radioButtonPatient.setOnAction(e->{
            if(radioButtonPatient.isSelected()){
                vDocola.userRole ="Patient";
            }else if(radioButtonPatient.isDisabled()){
                vDocola.userRole =null;
            }
        });
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.userEmail = tfEmail.getText();
                iActions.actionUpdateUndefinedUser(VariablesDocola.userEmail);
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
