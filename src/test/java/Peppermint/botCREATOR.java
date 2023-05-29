package Peppermint;
import insumosPeppermint.formularioTechnique;
import insumosPeppermint.formularioWorkshop;
import javafx.application.Application;
import javafx.application.Platform;
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
import org.fusesource.jansi.Ansi;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static insumosPeppermint.variablesPeppermint.printStream;


public class botCREATOR extends Application{
    TextArea consoleTextArea =  new TextArea();
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    variablesPeppermint variablesPep = new variablesPeppermint();
    public static void main(String[]args){
        Application.launch(botCREATOR.class);
    }

    private void appendText(String text) {
        Platform.runLater(() -> consoleTextArea.appendText(text));
    }
    @Override
    public void start(Stage stage1){
        //INICIALIZACION
        GridPane grid = new GridPane();
        ComboBox<String> comboBox = new ComboBox<>();
        consoleTextArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(consoleTextArea);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        grid.setHgap(10);
        grid.setVgap(10);
        Button crearWorkshop = new Button("Crear workshop");
        Button enrollWorkshop = new Button("Enroll users workshop");
        Button crearArticle = new Button("Crear article");
        Button crearClub = new Button("Crear club");
        Button crearTechnique = new Button("Crear technique");
        Button crearClubEvent = new Button("Crear evento");
        Button crearTaxonomy = new Button("Crear taxonomy");
        Button crearTag = new Button("Crear tag");
        Button crearLesson = new Button("Crear lesson");
        Button crearSegment = new Button("Crear segment");
        Button crearUsuario = new Button("Crear usuario");
        Button deneterCasoDePrueba = new Button("Detener");
        TextField ejecucionestf = new TextField("ejecuciones");
        //ESTILOS
        crearWorkshop.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        enrollWorkshop.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearArticle.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearClub.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTechnique.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearClubEvent.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTaxonomy.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearTag.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearLesson.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearSegment.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        crearUsuario.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        deneterCasoDePrueba.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        //consoleTextArea.setStyle("-fx-text-inner-color: #FFFFFF; -fx-control-inner-background:#000000;");
        scrollPane.setStyle(" -fx-text-fill: #FFFFFF; -fx-control-inner-background:#000000;");
        comboBox.setStyle("-fx-background-color: #99D0C2;");
        //POSICIONAMIENTO
        GridPane.setConstraints(comboBox,2,1);
        GridPane.setConstraints(ejecucionestf,2,2);
        GridPane.setConstraints(deneterCasoDePrueba,4,2);
        GridPane.setConstraints(crearWorkshop , 2, 3);
        GridPane.setConstraints(enrollWorkshop , 2, 4);
        GridPane.setConstraints(crearArticle , 2, 5);
        GridPane.setConstraints(crearClub , 2, 6);
        GridPane.setConstraints(crearTechnique , 2, 7);
        GridPane.setConstraints(crearClubEvent , 2, 8);
        GridPane.setConstraints(crearTaxonomy , 2, 9);
        GridPane.setConstraints(crearTag , 2, 10);
        GridPane.setConstraints(crearLesson , 2, 11);
        GridPane.setConstraints(crearSegment , 2, 12);
        GridPane.setConstraints(crearUsuario , 2, 13);
        GridPane.setConstraints(scrollPane,2,14,3,14);
        //AGREGAR ELEMENTOS
        grid.getChildren().add(comboBox);
        grid.getChildren().add(ejecucionestf);
        grid.getChildren().add(deneterCasoDePrueba);
        grid.getChildren().add(crearWorkshop);
        grid.getChildren().add(enrollWorkshop);
        grid.getChildren().add(crearArticle);
        grid.getChildren().add(crearClub);
        grid.getChildren().add(crearTechnique);
        grid.getChildren().add(crearClubEvent);
        grid.getChildren().add(crearTaxonomy);
        grid.getChildren().add(crearTag);
        grid.getChildren().add(crearLesson);
        grid.getChildren().add(crearSegment);
        grid.getChildren().add(crearUsuario);
        //grid.getChildren().add(consoleTextArea);
        grid.getChildren().add(scrollPane);
        comboBox.getItems().add("DEV");
        comboBox.getItems().add("QA");
        comboBox.setValue("Elegir ambiente");
        //LOGICA E HILOS
        comboBox.setOnAction(e->{
            String seleccion = comboBox.getValue();
            if (seleccion.equals("DEV")) {
                variablesPeppermint.linkDeNavegacion="http://localhost:4200/";
            } else if (seleccion.equals("QA")) {
                variablesPeppermint.linkDeNavegacion="https://peppermint-qa.web.app/";
            }
        });
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
        deneterCasoDePrueba.setOnAction(event ->{
            metodosPeppermint.detenerTest();
            System.out.println("La ejecucion se detendra al final de la actual iteracion");
            printStream.println("La ejecucion se detendra al final de la actual iteracion");
        });
        crearWorkshop.setOnAction(e->{
            Thread testtThreadworkshop =  new Thread (()->{
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
            }, "testtThreadworkshop");
            if(testtThreadworkshop.isAlive()) {
                testtThreadworkshop.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadworkshop.start();
        });
        enrollWorkshop.setOnAction(e->{
            Thread testenrollWorkshop =  new Thread (()->{
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
            }, "testtThreadworkshop");
            if(testenrollWorkshop.isAlive()) {
                testenrollWorkshop.stop();
            }
            metodosPeppermint.iniciarTest();
            testenrollWorkshop.start();
        });
        crearArticle.setOnAction(e->{
            Thread testtThreadArticle =  new Thread (()->{
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
            },"testtThreadArticle");
            if(testtThreadArticle.isAlive()) {
                testtThreadArticle.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadArticle.start();
        });
        crearClub.setOnAction(e->{
            Thread testtThreadClub =  new Thread (()->{
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
            },"testtThreadClub");
            if(testtThreadClub.isAlive()) {
                testtThreadClub.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadClub.start();
        });
        crearTechnique.setOnAction(e->{
            Thread testtThreadTechnique =  new Thread (()->{
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
            },"testtThreadTechnique");
            if(testtThreadTechnique.isAlive()) {
                testtThreadTechnique.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadTechnique.start();
        });
        crearClubEvent.setOnAction(e->{
            Thread testtThreadClubEvent =  new Thread (()->{
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
            },"testtThreadClubEvent");
            if(testtThreadClubEvent.isAlive()) {
                testtThreadClubEvent.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadClubEvent.start();
        });

        crearTaxonomy.setOnAction(e->{
            Thread testtThreadTaxonomy =  new Thread (()->{
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
            },"testtThreadTaxonomy");
            if(testtThreadTaxonomy.isAlive()) {
                testtThreadTaxonomy.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadTaxonomy.start();
        });
        crearTag.setOnAction(e->{
            Thread testtThreadTag =  new Thread (()->{
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
            },"testtThreadTag");
            if(testtThreadTag.isAlive()) {
                testtThreadTag.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadTag.start();
        });
        crearLesson.setOnAction(e->{
            Thread testtThreadLesson =  new Thread (()->{
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
            },"testtThreadLesson");
            if(testtThreadLesson.isAlive()) {
                testtThreadLesson.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadLesson.start();
        });
        crearSegment.setOnAction(e->{
            Thread testtThreadSegment =  new Thread (()->{
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
            },"testtThreadSegment");
            if(testtThreadSegment.isAlive()) {
                testtThreadSegment.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadSegment.start();
        });
        crearUsuario.setOnAction(e->{
            Thread testtThreadCrearUsuario =  new Thread (()->{
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
            },"testtThreadSCrearUsuario");
            if(testtThreadCrearUsuario.isAlive()) {
                testtThreadCrearUsuario.stop();
            }
            metodosPeppermint.iniciarTest();
            testtThreadCrearUsuario.start();
        });
        Scene scene = new Scene (grid,520, 670);
        stage1.setScene(scene);
        stage1.show();
    }
}
