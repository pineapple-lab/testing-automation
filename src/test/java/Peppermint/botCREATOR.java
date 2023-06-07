package Peppermint;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import insumosPeppermint.robotBasePeppermint;
import insumosPeppermint.variablesPeppermint;
import java.io.*;
import static insumosPeppermint.variablesPeppermint.printStream;
public class botCREATOR extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public static void main(String[]args){
        launch(botCREATOR.class, args);
    }
    private void appendText(String text) {
        Platform.runLater(() -> consoleTextArea.appendText(text));
    }
 @Override
    public void start(Stage stage1){
        super.start(stage1);
     Thread interfaceThread =  new Thread (()->{
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
         comboBox.setOnAction(e->{
             String seleccion = comboBox.getValue();
             if (seleccion.equals("DEV")) {
                 variablesPeppermint.linkDeNavegacion="http://localhost:4200/";
             } else if (seleccion.equals("QA")) {
                 variablesPeppermint.linkDeNavegacion="https://peppermint-qa.web.app/";
             }
         });
         deneterCasoDePrueba.setOnAction(event ->{
             metodosPeppermint.detenerTest();
             System.out.println("La ejecucion se detendra al final de la actual iteracion");
             printStream.println("La ejecucion se detendra al final de la actual iteracion");
         });
         removerDeLaCola.setOnAction(event ->{
             actionEliminarDeLaCola();
         });
         crearWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateWorkshops);
                 Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                 CheckBox checkBox = new CheckBox("CreateWorkshops");
                 checkBoxesMap.put(checkBox, elemento);
                 grid.add(checkBox, 0, listaDeEspera.size()-1);

         });
         enrollWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.EnrollWorkshop);
                 Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                 CheckBox checkBox = new CheckBox("EnrollWorkshops");
                 checkBoxesMap.put(checkBox, elemento);
                 grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearArticle.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateArticle);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateArticle");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearClub.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateClub);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateClub");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearTechnique.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateTechnique);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateTechnique");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearClubEvent.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateClubEvent);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateClubEvent");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearTaxonomy.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateTaxonomy);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateTaxonomy");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearTag.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateTag);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateTag");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearLesson.setOnAction(e->{
            listaDeEspera.add(ExecMethod.CreateLesson);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateLesson");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearSegment.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateSegment);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateSegment");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearUsuario.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateUsuario);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("CreateUsuario");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         enviarSolicitudDeAmistad.setOnAction(e->{
             listaDeEspera.add(ExecMethod.SendFriendRequest);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("SendFriendRequest");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         joinClub.setOnAction(e->{
             listaDeEspera.add(ExecMethod.JoinClub);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("JoinClub");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         generarPostClub.setOnAction(e->{
             listaDeEspera.add(ExecMethod.GeneratePostClub);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("GeneratePostClub");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         generarInviteGuest.setOnAction(e->{
             listaDeEspera.add(ExecMethod.GenerateInviteGuest);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("GenerateInviteGuest");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
     }, "interfaceThread");
     if(interfaceThread.isAlive()) {
         interfaceThread.stop();
     }else {
         interfaceThread.start();
     }
     ejecutar.setOnAction(e->{
         Thread ejecutar=  new Thread (()->{
             for (int i = 0; i < listaDeEspera.size(); i++) {
                 ExecMethod var = listaDeEspera.get(i);
                 switch (var){
                     case CreateWorkshops:
                         actionCrearWorkshop();
                         break;
                     case EnrollWorkshop:
                         actionEnrollWorkshop();
                         break;
                     case CreateArticle:
                         actionCreateArticle();
                         break;
                     case CreateClub:
                         actionCreateClub();
                         break;
                     case CreateTechnique:
                         actionCreateTechnique();
                         break;
                     case CreateClubEvent:
                         actionCreateClubEvent();
                         break;
                     case CreateTaxonomy:
                         actionCreateTaxonomy();
                         break;
                     case CreateTag:
                         actionCreateTag();
                         break;
                     case CreateLesson:
                         actionCreateLesson();
                         break;
                     case CreateSegment:
                         actionCreateSegment();
                         break;
                     case CreateUsuario:
                         actionCreateUsuario();
                         break;
                     case SendFriendRequest:
                         actionSendFriendRequest();
                         break;
                     case JoinClub:
                         actionJoinClub();
                         break;
                     case GenerateInviteGuest:
                         actionInviteGuest();
                         break;
                     case GeneratePostClub:
                         actionPostClub();
                         break;
                 }
             }
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
