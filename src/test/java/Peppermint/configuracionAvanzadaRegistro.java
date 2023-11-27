package Peppermint;

import insumosPeppermint.methodsPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaRegistro extends interfaceActions{

    methodsPeppermint metodosPeppermint = new methodsPeppermint();
    public configuracionAvanzadaRegistro(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }

    @Override
    public void start(Stage stageCrearUsuarioConfigAvanzada) {
        stageCrearUsuarioConfigAvanzada.setTitle("Configuracion avanzada crear usuario");
        GridPane gridPaneCrearUsuario = new GridPane();
        gridPaneCrearUsuario.setHgap(3);
        gridPaneCrearUsuario.setVgap(10);
        gridPaneCrearUsuario.add(checkboxFirstNameAvanzado,2,1);
        gridPaneCrearUsuario.add(textFieldFirstNameAvanzado,3,1);
        gridPaneCrearUsuario.add(checkboxLastNameAvanzado,2,2);
        gridPaneCrearUsuario.add(textFieldLastNameAvanzado,3,2);
        gridPaneCrearUsuario.add(checkBoxPasswordAvanzado,2,3);
        gridPaneCrearUsuario.add(textFieldPasswordAvanzado,3,3);
        gridPaneCrearUsuario.add(checkBoxEmailAvanzado,2,4);
        gridPaneCrearUsuario.add(textFieldEmailAvanzado,3,4);
        gridPaneCrearUsuario.add(executeRegistroAvanzado,6,6);
        executeRegistroAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabRegistrarUsuarioConfigAvanzada.setContent(gridPaneCrearUsuario);
        tabPane.getTabs().add(tabRegistrarUsuarioConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzada = new Scene(rootConfigAvanzada,310,230);
        stageCrearUsuarioConfigAvanzada.setScene(configAvanzada);
        textFieldFirstNameAvanzado.setVisible(false);
        textFieldLastNameAvanzado.setVisible(false);
        textFieldEmailAvanzado.setVisible(false);
        textFieldPasswordAvanzado.setVisible(false);
        checkboxFirstNameAvanzado.setOnAction(actionEvent -> {
            if (checkboxFirstNameAvanzado.isSelected()){
                textFieldFirstNameAvanzado.setVisible(true);
            }else {
                textFieldFirstNameAvanzado.setVisible(false);
            }
        });
        checkboxLastNameAvanzado.setOnAction(actionEvent -> {
            if (checkboxLastNameAvanzado.isSelected()){
                textFieldLastNameAvanzado.setVisible(true);
            }else {
                textFieldLastNameAvanzado.setVisible(false);
            }
        });
        checkBoxPasswordAvanzado.setOnAction(actionEvent -> {
            if (checkBoxPasswordAvanzado.isSelected()){
                textFieldPasswordAvanzado.setVisible(true);
            }else {
                textFieldPasswordAvanzado.setVisible(false);
            }
        });
        checkBoxEmailAvanzado.setOnAction(actionEvent -> {
            if (checkBoxEmailAvanzado.isSelected()){
                textFieldEmailAvanzado.setVisible(true);
            }else {
                textFieldEmailAvanzado.setVisible(false);
                configurationAdvancedRegistration = false;
            }
        });
        executeRegistroAvanzado.setOnAction(e->{
            Thread execute=  new Thread (()->{
                if (checkboxFirstNameAvanzado.isSelected()){
                    firstName = textFieldFirstNameAvanzado.getText();
                }else {
                    firstName="pineapple";
                }
                if (checkboxLastNameAvanzado.isSelected()){
                    lastName = textFieldLastNameAvanzado.getText();
                }else {
                    lastName="user";
                }
                if (checkBoxPasswordAvanzado.isSelected()){
                    passwordRegister = textFieldPasswordAvanzado.getText();
                }else {
                    passwordRegister="123123aA";
                }
                if (checkBoxEmailAvanzado.isSelected()){
                    emailRegister = textFieldEmailAvanzado.getText();
                    configurationAdvancedRegistration = true;
                }
                actionCreateUsuario();
            }, "execute");
            if(execute.isAlive()) {
                execute.stop();
            }else {
                metodosPeppermint.iniciarTest();
                execute.start();
            }
        });
    }
}
