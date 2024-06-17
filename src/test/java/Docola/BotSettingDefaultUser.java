package Docola;

import InsumosDocola.MethodsDocola;
import InsumosDocola.VariablesDocola;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BotSettingDefaultUser extends InterfaceElements {
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
                vDocola.linkNavigation="https://docolasandbox.web.app/";
            }else if(radioButtonDev.isDisabled()){
                vDocola.linkNavigation=null;
            }
        });
        radioButtonLocal.setOnAction(e->{
            if(radioButtonLocal.isSelected()){
                vDocola.linkNavigation="http://localhost:4200/";
            }else if(radioButtonLocal.isDisabled()){
                vDocola.linkNavigation=null;
            }
        });
        radioButtonContentProvider.setOnAction(e->{
            if(radioButtonContentProvider.isSelected()){
                vDocola.joinRol="Content provider";
            }else if(radioButtonContentProvider.isDisabled()){
                vDocola.joinRol=null;
            }
        });
        radioButtonClinician.setOnAction(e->{
            if(radioButtonClinician.isSelected()){
                vDocola.joinRol="Clinician";
            }else if(radioButtonClinician.isDisabled()){
                vDocola.joinRol=null;
            }
        });
        radioButtonPatient.setOnAction(e->{
            if(radioButtonPatient.isSelected()){
                vDocola.joinRol="Patient";
            }else if(radioButtonPatient.isDisabled()){
                vDocola.joinRol=null;
            }
        });
        settingSave.setOnAction(e->{
            Thread execute=  new Thread (()->{
                VariablesDocola.email = tfEmail.getText();
                System.out.println(VariablesDocola.email);
                iActions.actionUpdateUndefinedUser(VariablesDocola.email);
            }, "execute");
            if(execute.isAlive()) {
                execute.stop();
            }else {
                mDocola.startTest();
                execute.start();
            }
        });
    }
}
