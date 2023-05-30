package Peppermint;
import insumosPeppermint.formularioTechnique;
import insumosPeppermint.formularioWorkshop;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import insumosPeppermint.robotBasePeppermint;
import insumosPeppermint.variablesPeppermint;
import net.bytebuddy.pool.TypePool;
import org.fusesource.jansi.Ansi;

import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import Peppermint.interfacePropiedadesEstilosYposicionamiento;
import org.jetbrains.kotlin.psi.CreateByPatternKt;
import org.jetbrains.kotlin.serialization.js.ast.JsAstProtoBuf;

import static insumosPeppermint.variablesPeppermint.printStream;


public class botCREATOR extends interfacePropiedadesEstilosYposicionamiento{
    enum ExecMethod {
        CreateWorckshops,
       ActionEnrollWorkshop,
        ActionCreateArticle,
        ActionCreateClub,
        ActionCreateTechnique,
        ActionCreateClubEvent,
        ActionCreateTaxonomy,
        ActionCreateTag,
        ActionCreateLesson,
        ActionCreateSegment,
        ActionCreateUsuario;

    }
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
    public void actionCrearWorkshop(){
                try {
                    String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                    String username = "root";
                    String password = "root";
                    Connection CN = DriverManager.getConnection(url, username, password);
                    String ejecuciones = ejecucionestf.getText();
                    String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
                    Statement stmt = CN.createStatement();
                    stmt.executeUpdate(insertSql);
                    CN.close();
                    funcionWorkshopManagment test = new funcionWorkshopManagment();
                    test.validacionCrearWorkshop();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
    public void actionEnrollWorkshop(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionWorkshopUser test = new functionWorkshopUser();
            test.ValidarWorkshopEnrollmente();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateArticle(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionArticleManagment test = new funcionArticleManagment();
            test.validacionCrearArticle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateClub(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionClubManagment test = new funcionClubManagment();
            test.vaidacionCrearClub();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTechnique(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionTechniqueManagment test = new funcionTechniqueManagment();
            test.validacionCreateTechnique();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateClubEvent(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionEventManagment test = new funcionEventManagment();
            test.validacionCreateEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTaxonomy(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionContentTaxonomy test = new funcionContentTaxonomy();
            test.validacionCrearTaxonomy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTag(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionTag test = new funcionTag();
            test.validacionCrearTag();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateLesson(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionLessonManagment test = new funcionLessonManagment();
            test.vaidacionCrearLesson();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateSegment(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionSegmentsManagment test = new funcionSegmentsManagment();
            test.vaidacionCreacionSegment();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateUsuario(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String ejecuciones = ejecucionestf.getText();
            String insertSql = "UPDATE testbdpeppermint.configuracion SET ejecuciones = "+"'"+ejecuciones+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            funcionRegistroManagment test = new funcionRegistroManagment();
            test.validacionCrearUsuario();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
