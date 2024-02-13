package Docola;
import InsumosDocola.variablesDocola;
import InsumosDocola.methodsDocola;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.PrintStream;
import static InsumosDocola.variablesDocola.*;
import static insumosPeppermint.variablesPeppermint.printStream;
public class botCreator extends Docola.interfaceActions {
    methodsDocola methods= new methodsDocola();
    public static void main(String[] args) {
        launch(botCreator.class, args);
    }

    private void appendText(String text) {
        Platform.runLater(() -> consoleTextArea.appendText(text));
    }
    @Override
    public void start(Stage stage1) {
        super.start(stage1);
        Thread interfaceThread = new Thread(() -> {
            printStream = new PrintStream(new PrintStream(new OutputStream() {
                @Override
                public void write(int b){
                    appendText(String.valueOf((char)b));
                }
                public void write (byte[] b, int off, int len){
                    appendText(new String (b,off,len));
                }
            }));
            printStream.println("Bienvenido, selecciona un ambiente y el numero de ejecuciones para empezar.\n\n");
            comboBox.setOnAction(e -> {
                seleccion = comboBox.getValue();
                if (seleccion.equals("Local")) {
                    variablesDocola.linkNavigation = "http://localhost:4200/";
                }
            });
            createUser.setOnAction(e->{
                listaDeEspera.add(ExecMethod.CreateUser);
                Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                CheckBox checkBox = new CheckBox("CreateUser");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, listaDeEspera.size()-1);
            });
            createUser.setOnMousePressed( event -> {
                if (event.isSecondaryButtonDown()){
                    ejecuciones=Integer.parseInt(tfExecute.getText());
                    configuracionAvanzadaJoin configAvanzada = new configuracionAvanzadaJoin(String.valueOf(ejecuciones),seleccion);
                    Stage configAvanzadaStage = new Stage();
                    configAvanzada.start(configAvanzadaStage);
                    configAvanzadaStage.show();
                }
            });
            validationsFirstNameRegister.setOnAction(e->{
                listaDeEspera.add(ExecMethod.validationFirstNameRegister);
                Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                CheckBox checkBox = new CheckBox("validationFirstNameRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, listaDeEspera.size()-1);
            });
            validationsLastNameRegister.setOnAction(e->{
                listaDeEspera.add(ExecMethod.validationLastNameRegister);
                Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                CheckBox checkBox = new CheckBox("validationLastNameRegister");
                checkBoxesMap.put(checkBox, elemento);
                gridCola.add(checkBox, 0, listaDeEspera.size()-1);
            });
            /*deneterCasoDePrueba.setOnAction(event ->{
                methods.detenerTest();
                System.out.println("La ejecucion se detendra al final de la actual iteracion");
                printStream.println("La ejecucion se detendra al final de la actual iteracion");
            });*/
            removerDeLaCola.setOnAction(event ->{
                actionEliminarDeLaCola();
            });
        }, "interfaceThread");
        if(interfaceThread.isAlive()) {
            interfaceThread.stop();
        }else {
            interfaceThread.start();
        }
        execute.setOnAction(e -> {
            System.out.println(linkNavigation);
            Thread execute = new Thread(() -> {
                ejecuciones =  Integer.parseInt(tfExecute.getText());
                accion();
                }, "execute");
            if (execute.isAlive()) {
                execute.stop();
            } else {
                methods.iniciarTest();
                execute.start();
            }
        });
    }
    public void accion () {
        for (int i = 0; i < listaDeEspera.size(); i++) {
            interfaceActions.ExecMethod var = listaDeEspera.get(i);
            switch (var) {
                case CreateUser:
                    actionJoin();
                    break;
                case validationFirstNameRegister:
                    actionValidationFirstNameRegister();
                    break;
                case validationLastNameRegister:
                    actionValidationLastNameRegister();
                    break;
            }
        }
    }
}