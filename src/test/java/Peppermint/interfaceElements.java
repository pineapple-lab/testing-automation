package Peppermint;
import clojure.lang.IFn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class interfaceElements extends Application{
    String executionDetails;
    String seleccion;
    ArrayList<botCREATOR.ExecMethod> listaDeEspera = new ArrayList<>();
    GridPane grid = new GridPane();
    ComboBox<String> comboBox = new ComboBox<>();
    public Map<CheckBox,Enum> checkBoxesMap = new HashMap<>();
    TabPane tabPane = new TabPane();
    StackPane rootConfigAvanzada = new StackPane();
    Button removerDeLaCola = new Button("Remover de la cola");
    public int rowIndex;
    TextArea consoleTextArea =  new TextArea();
    ScrollPane scrollPane = new ScrollPane(consoleTextArea);
    Button suiteBasica = new Button("Suite Basica");
    //Cuadros de ayuda
    Button ayuda = new Button ("?");
    Dialog<String> dialog = new Dialog<>();
    TextArea cuadroDeAyudas = new TextArea();
    //VALIDAR DOMINIOS
    Button validarDominios = new Button("Validar Dominios");
    //CREAR WORKSHOP
    Button crearWorkshop = new Button("Crear workshop");
    Tab tabConfiguracionAvanzadaWorkshops = new Tab("Configuracion avanzada Workshops");
    CheckBox checkBoxEditarTituloWorkshops = new CheckBox("Editar titulo");
    CheckBox checkBoxEditarEstudiantesOptimosModalidadGroupWithInstructor = new CheckBox("Editar estudiantes optimos");
    CheckBox checkBoxEditarEstudiantesMaximosModalidadGroupWithInstructor = new CheckBox("Editar estudiantes maximos");
    CheckBox checkBoxEditarEstudiantesOptimosModalidadGroupSinInstructor = new CheckBox("Editar estudiantes optimos");
    CheckBox checkBoxEditarEstudiantesMaximosModalidadGroupSinInstructor = new CheckBox("Editar estudiantes maximos");
    TextField textFieldEditarTituloWorkshops = new TextField("Introducir titulo");
    Label labelModalidadGroupWithInstructor = new Label("Modalidad grupo con instructor");
    TextField textFieldMaxStudentsGroupWithInstructor = new TextField("Maximo de estudiantes");
    TextField textFieldOptimalBuddyGroupGroupWithInstructor = new TextField("Estudiantes optimos");
    Label labelModalidadGrupoSinInstructor = new Label("Modalidad grupo sin instructor");
    TextField textFieldMaxStudentsGroup = new TextField("Maximo de estudiantes");
    TextField textFieldOptimalBuddyGroup = new TextField("Estudiantes optimos");
    Button executeWorkshopAvanzado = new Button("execute");
    //ENROLL WORKSHOP
    Button enrollWorkshop = new Button("Enroll workshop");
    Button unirMultiplesWorkshop = new Button ("Enroll multi workshops");
    Tab tabEnrollMultiWorkshopAvanzado = new Tab("Enroll multiworkshop avanzado");
    Label labelEmailEnrollMultiWorkshopAvanzado = new Label("Email");
    TextField textFieldEmailEnrollMultiWorkshopAvanzado = new TextField("Email");
    Button buttonexecuteEnrollMultiWorkshopAvanzado = new Button("execute");
    Tab tabEnrollWorkshopAvanzado = new Tab("Enroll workshop avanzado");
    Label labelModalityEnrollWorkshopAvanzado = new Label("Modality");
    TextField textFieldModalityEnrollWorkshopAvanzado = new TextField("Modality");
    Button buttonexecuteEnrollWorkshopAvanzado = new Button("execute");
    Button buttonexecuteEnviarActivity = new Button("Completar activity");
    Button buttonexecuteResponderActivity = new Button("Responder activity");
    Button crearArticle = new Button("Crear article");
    Button crearClub = new Button("Crear club");
    Button crearTechnique = new Button("Crear technique");
    Button crearClubEvent = new Button("Crear evento");
    Button crearTaxonomy = new Button("Crear taxonomy");
    Button crearTag = new Button("Crear tag");
    Button crearLesson = new Button("Crear lesson");
    Button crearSegment = new Button("Crear segment");
    //REGISTRAR USUARIOS
    Button crearUsuario = new Button("Crear usuario");
    Tab tabRegistrarUsuarioConfigAvanzada = new Tab("Crear usuario configuracion avanzada");
    Button executeRegistroAvanzado  = new Button("ejectuar");
    CheckBox checkboxFirstNameAvanzado = new CheckBox("First name");
    CheckBox checkboxLastNameAvanzado = new CheckBox("Last name");
    CheckBox checkBoxEmailAvanzado = new CheckBox("Email");
    CheckBox checkBoxPasswordAvanzado = new CheckBox("Passowrd");
    TextField textFieldFirstNameAvanzado = new TextField("First name");
    TextField textFieldLastNameAvanzado = new TextField("LastName");
    TextField textFieldEmailAvanzado = new TextField("Email");
    TextField textFieldPasswordAvanzado = new TextField("Password");
    //ENVIAR AMIGOS
    Tab tabSendFriendsConfigAvanzada = new Tab("Send Friends");
    Button enviarSolicitudDeAmistad = new Button("Generar amigos");
    Label labelEmailAceptarAmigos = new Label("Aceptar amigos");
    TextField emailAceptarFriends = new TextField("introducir email");
    Label labelUserSendFriends = new Label("Enviar amigos");
    TextField userSendFriends = new TextField("introducir first name");
    Button executeSendFriends = new Button("execute");
    //CLUB
    Button joinClub = new Button("Join club");
    Button unirMultiplesClub = new Button ("Enroll multi clubs");
    Tab tabEnrollMultiClubAvanzado = new Tab("Enroll multiclub avanzado");
    Label labelEmailEnrollMultiClubAvanzado = new Label("Email");
    TextField textFieldEmailEnrollMultiClubAvanzado = new TextField("Email");
    Button buttonexecuteEnrollMultiClubAvanzado = new Button("execute");
    //INVITE GUEST
    Tab tabConfiguracionAvanzadaInviteGuest = new Tab("Configuracion avanzada invite guest");
    Button generarInviteGuest = new Button("Generar invite guest");
    Label labelEnviarInviteGuest = new Label("Introducir email");
    TextField textFieldEmailInviteGuestAvanzado = new TextField("email");
    Button executeInviteGuestAvanzado = new Button ("execute");
    //POST CLUB
    Button generarPostClub = new Button("Generar post club");
    Button likePost = new Button("Like post");
    //RECOMENDACIONES
    Tab tabSendRecommendationConfigAvanzada = new Tab("Send Recomendations");
    Button enviarRecomendaciones = new Button ("Enviar recomendaciones");
    Label labelEnviarRecomendaciones = new Label("Enviar recomendaciones");
    CheckBox checkBoxEditarEmisor = new CheckBox("Editar emisor");
    TextField introducirUsuarioRecomend = new TextField("First name");
    TextField introducirEmisorRecomendaciones = new TextField("Email");
    Button executeSendRecomendations = new Button("execute");
    //RECOMENDAR USUARIOS
    Button recomendarUsuarios = new Button ("Recomendar usuarios");
    //BOOKMARK
    Button guardarBookmark = new Button ("Guardar bookmark");
    Tab tabMultiBookmark = new Tab("Bookmark avanzado");
    Label labelMultiBookmark = new Label("Email");
    TextField textFieldEmailMultiBookmark = new TextField("Email");
    Button buttonexecuteMultiBookmark = new Button("execute");
    Button deneterCasoDePrueba = new Button("Detener");
    Button execute = new Button("execute");
    TextField executionDetailstf = new TextField("executionDetails");

    public void start(Stage stage) throws Exception {}
}
