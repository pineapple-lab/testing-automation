package Peppermint;
import javafx.application.Platform;
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
         crearWorkshop.setOnAction(e->{
            listaDeEspera.add(ExecMethod.CreateWorckshops);
         });
         enrollWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionEnrollWorkshop);
         });
         crearArticle.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateArticle);
         });
         crearClub.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateClub);
         });
         crearTechnique.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateTechnique);

         });
         crearClubEvent.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateClubEvent);

         });
         crearTaxonomy.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateTaxonomy);

         });
         crearTag.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateTag);
         });
         crearLesson.setOnAction(e->{
            listaDeEspera.add(ExecMethod.ActionCreateLesson);
         });
         crearSegment.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateSegment);
         });
         crearUsuario.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ActionCreateUsuario);

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
                     case CreateWorckshops:
                         actionCrearWorkshop();
                         break;
                     case ActionEnrollWorkshop:
                         actionEnrollWorkshop();
                         break;
                     case ActionCreateArticle:
                         actionCreateArticle();
                         break;
                     case ActionCreateClub:
                         actionCreateClub();
                         break;
                     case ActionCreateTechnique:
                         actionCreateTechnique();
                         break;
                     case ActionCreateClubEvent:
                         actionCreateClubEvent();
                         break;
                     case ActionCreateTaxonomy:
                         actionCreateTaxonomy();
                         break;
                     case ActionCreateTag:
                         actionCreateTag();
                         break;
                     case ActionCreateLesson:
                         actionCreateLesson();
                         break;
                     case ActionCreateSegment:
                         actionCreateSegment();
                         break;
                     case ActionCreateUsuario:
                         actionCreateUsuario();
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
