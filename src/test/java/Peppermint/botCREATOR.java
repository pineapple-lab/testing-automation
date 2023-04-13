package Peppermint;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import insumosPeppermint.robotBasePeppermint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class botCREATOR extends Application{

    public static void main(String[]args){
        Application.launch(botCREATOR.class);
    }
robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
 @Override
    public void start(Stage stage1){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        Button crearWorkshop = new Button("Crear workshop");
        Button crearArticle = new Button("Crear article");
        Button crearClub = new Button("Crear club");
        Button crearTechnique = new Button("Crear technique");
        Button crearClubEvent = new Button("Crear evento");
        Button crearTaxonomy = new Button("Crear taxonomy");
        Button crearTag = new Button("Crear tag");
        Button crearLesson = new Button("Crear lesson");
        Button crearSegment = new Button("Crear segment");
        Button deneterCasoDePrueba = new Button("Detener");
        TextField ejecucionestf = new TextField("ejecuciones");
        GridPane.setConstraints(ejecucionestf,2,1);
        GridPane.setConstraints(deneterCasoDePrueba,3,1);
        GridPane.setConstraints(crearWorkshop , 2, 2);
        GridPane.setConstraints(crearArticle , 2, 3);
        GridPane.setConstraints(crearClub , 2, 4);
        GridPane.setConstraints(crearTechnique , 2, 5);
        GridPane.setConstraints(crearClubEvent , 2, 6);
        GridPane.setConstraints(crearTaxonomy , 2, 7);
        GridPane.setConstraints(crearTag , 2, 8);
        GridPane.setConstraints(crearLesson , 2, 9);
        GridPane.setConstraints(crearSegment , 2, 10);
        grid.getChildren().add(ejecucionestf);
        grid.getChildren().add(deneterCasoDePrueba);
        grid.getChildren().add(crearWorkshop);
        grid.getChildren().add(crearArticle);
        grid.getChildren().add(crearClub);
        grid.getChildren().add(crearTechnique);
        grid.getChildren().add(crearClubEvent);
        grid.getChildren().add(crearTaxonomy);
        grid.getChildren().add(crearTag);
        grid.getChildren().add(crearLesson);
        grid.getChildren().add(crearSegment);
        deneterCasoDePrueba.setOnAction(event ->{
            metodosPeppermint.detenerTest();
            System.out.println("La ejecucion se detendra al final de la iteracion");
        });
        crearWorkshop.setOnAction(e->{
            Thread testtThreadworkshop =  new Thread (()->{
                try {
                    String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                    String username = "root";
                    String password = "root";
                    Connection CN = DriverManager.getConnection(url, username, password);
                    String ejecuciones = ejecucionestf.getText();
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES(" + ejecuciones + ")";
                    Statement stmt = CN.createStatement();
                    stmt.executeUpdate(insertSql);
                    CN.close();
                    funcionWorkshopManagment test = new funcionWorkshopManagment();
                    test.validarCrearWorkshop();
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
        crearArticle.setOnAction(e->{
            Thread testtThreadArticle =  new Thread (()->{
                try {
                    String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
                    String username = "root";
                    String password = "root";
                    Connection CN = DriverManager.getConnection(url, username, password);
                    String ejecuciones = ejecucionestf.getText();
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
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
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
                    Statement stmt = CN.createStatement();
                    stmt.executeUpdate(insertSql);
                    CN.close();
                    funcionClubManagment test = new funcionClubManagment();
                    test.crearClub();
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
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
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
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
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
                    String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
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
                 String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
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
                 String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
                 Statement stmt = CN.createStatement();
                 stmt.executeUpdate(insertSql);
                 CN.close();
                 funcionLessonManagment test = new funcionLessonManagment();
                 test.crearLesson();
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
                 String insertSql = "INSERT INTO testbdpeppermint.configuracion(`ejecuciones`) VALUES("+ejecuciones+")";
                 Statement stmt = CN.createStatement();
                 stmt.executeUpdate(insertSql);
                 CN.close();
                 funcionSegmentsManagment test = new funcionSegmentsManagment();
                 test.crearSegment();
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
        Scene scene = new Scene (grid,300, 500);
        stage1.setScene(scene);
        stage1.show();
        }

}

