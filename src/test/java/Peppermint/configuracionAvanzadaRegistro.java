package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaRegistro extends interfaceActions{

    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
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
        gridPaneCrearUsuario.add(ejecutarRegistroAvanzado,6,6);
        tabRegistrarUsuarioConfigAvanzada.setContent(gridPaneCrearUsuario);
        tabPane.getTabs().add(tabRegistrarUsuarioConfigAvanzada);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzada = new Scene(rootConfigAvanzada,450,350);
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
                configuracionRegistroAvanzado = false;
            }
        });
        ejecutarRegistroAvanzado.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
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
                    passwordRegistro = textFieldPasswordAvanzado.getText();
                }else {
                    passwordRegistro="123123aA";
                }
                if (checkBoxEmailAvanzado.isSelected()){
                    emailRegistro = textFieldEmailAvanzado.getText();
                    configuracionRegistroAvanzado = true;
                }
                actionCreateUsuario();
            }, "ejecutar");
            if(ejecutar.isAlive()) {
                ejecutar.stop();
            }else {
                metodosPeppermint.iniciarTest();
                ejecutar.start();
            }
        });
    }
}
