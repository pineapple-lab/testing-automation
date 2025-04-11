package Arla;

import Arla.InterfaceActions;
import InsumosArla.MethodsArla;
import InsumosArla.VariablesArla;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static InsumosArla.VariablesArla.userEmail;

public class BotSettingsDefaultUser extends InterfaceElements{
    private volatile boolean isRunning = true;
    Label labelEmail = new Label ("Userdefined");
    Label setRol = new Label("Set rol");
    Label setEnvironment = new Label("Set environment");
    TextField tfEmail = new TextField();
    Button settingSave = new Button("Guardar");
    Tab tbUndefinedEmail = new Tab();
    RadioButton radioButtonContentProvider = new RadioButton("Content provider");
    RadioButton radioButtonClinician = new RadioButton("Clinician");
    RadioButton radioButtonPatient = new RadioButton("Patient");
    RadioButton radioButtonDev = new RadioButton("Dev");
    RadioButton radioButtonLocal = new RadioButton("Local");
    MethodsArla mDocola = new MethodsArla();
    VariablesArla vArla = new VariablesArla();
    Arla.InterfaceActions iActions = new InterfaceActions();
    public BotSettingsDefaultUser(String environment){
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
        settingSave.setStyle("-fx-background-color: #cb4b81;");
        settingSave.setOnMouseEntered(e -> settingSave.setStyle("-fx-background-color: #e27da1; -fx-text-fill: white;"));
        settingSave.setOnMouseExited(e -> settingSave.setStyle("-fx-background-color: #cb4b81;"));
        tfEmail.setPromptText("Userdefined");
        tbUndefinedEmail.setContent(gridPaneUndefinedSettings);
        tabPane.getTabs().addAll(tbUndefinedEmail);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene sceneConfigAvanzada = new Scene(rootConfigAvanzada,450,280);
        undefineduserSetting.setScene(sceneConfigAvanzada);
        radioButtonDev.setOnAction(e->{
            if(radioButtonDev.isSelected()){
                vArla.navigationLink="https://docolasandbox.web.app/";
            }else if(radioButtonDev.isDisabled()){
                vArla.navigationLink=null;
            }
        });
        radioButtonLocal.setOnAction(e->{
            if(radioButtonLocal.isSelected()){
                vArla.navigationLink="http://localhost:4200/";
            }else if(radioButtonLocal.isDisabled()){
                vArla.navigationLink=null;
            }
        });
        radioButtonContentProvider.setOnAction(e->{
            if(radioButtonContentProvider.isSelected()){
                vArla.userRole ="Content provider";
            }else if(radioButtonContentProvider.isDisabled()){
                vArla.userRole =null;
            }
        });
        radioButtonClinician.setOnAction(e->{
            if(radioButtonClinician.isSelected()){
                vArla.userRole ="Clinician";
            }else if(radioButtonClinician.isDisabled()){
                vArla.userRole =null;
            }
        });
        radioButtonPatient.setOnAction(e->{
            if(radioButtonPatient.isSelected()){
                vArla.userRole ="Patient";
            }else if(radioButtonPatient.isDisabled()){
                vArla.userRole =null;
            }
        });
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesArla.userEmail = tfEmail.getText();
                //iActions.actionUpdateUndefinedUser(VariablesArla.userEmail);
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
    }
}
