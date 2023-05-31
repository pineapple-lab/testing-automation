package Peppermint;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Consumer;

public class interfaceElements extends Application{
    ArrayList<botCREATOR.ExecMethod> listaDeEspera = new ArrayList<>();
    GridPane grid = new GridPane();
    ComboBox<String> comboBox = new ComboBox<>();
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);
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
    Button ejecutar = new Button("Ejecutar");
    TextField ejecucionestf = new TextField("ejecuciones");


    public void start(Stage stage) throws Exception {

    }
}
