package Peppermint;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import insumosPeppermint.methodsPeppermint;
import insumosPeppermint.variablesPeppermint;
import java.io.*;

import static insumosPeppermint.variablesPeppermint.*;

public class botCREATOR extends interfaceActions{

    methodsPeppermint metodosPeppermint = new methodsPeppermint();
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
         outputStream = new PrintStream(new PrintStream(new OutputStream() {
             @Override
             public void write(int b){
                 appendText(String.valueOf((char)b));
             }
             public void write (byte[] b, int off, int len){
                 appendText(new String (b,off,len));
             }
         }));
         outputStream.println("Bienvenido, selecciona un ambiente y el numero de executionDetails para empezar.\n\n");
         comboBox.setOnAction(e->{
             seleccion = comboBox.getValue();
             if (seleccion.equals("DEV")) {
                 variablesPeppermint.navigationLink="https://peppermint-development.web.app/auth/login";
             } else if (seleccion.equals("QA")) {
                 variablesPeppermint.navigationLink="https://peppermint-qa.web.app/auth/login";
             }else if (seleccion.equals("Local")) {
                 variablesPeppermint.navigationLink="http://localhost:4200/auth/login";
             }
         });
         deneterCasoDePrueba.setOnAction(event ->{
             metodosPeppermint.detenerTest();
             System.out.println("La ejecucion se detendra al final de la actual iteracion");
             outputStream.println("La ejecucion se detendra al final de la actual iteracion");
         });
         removerDeLaCola.setOnAction(event ->{
             actionEliminarDeLaCola();
         });
         suiteBasica.setOnAction(e->{
             listaDeEspera.add(ExecMethod.SuiteBasica);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("SuiteBasica");
             variablesPeppermint.userSendRecomendation ="AAAAAAusuariorecomendacionpineapple";
             variablesPeppermint.userSendRecomendationQA ="Paula Gomez";
             variablesPeppermint.emailRecomendationSending="pineappleuser1685718024380@mailinator.com";
             variablesPeppermint.emailRecomendationSendingQA="LauraPadilla1693506039635@mailinator.com";
             variablesPeppermint.emailUserBookmark="pineappleuser1685718024380@mailinator.com";
             variablesPeppermint.emailUserBookmarkQA="LauraPadilla1693506039635@mailinator.com";
             variablesPeppermint.emailUserEnrollMultiplesWorkshops = "pineappleuser1686586295370@mailinator.com";
             emailUserUnirMultiplesClub="pineAppleUser1683738718947@mailinator.com";
             variablesPeppermint.userEmailLoginInviteGuest="pineAppleUser1683738718947@mailinator.com";
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         validarDominios.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ValidarDominio);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("ValidarDominio");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.CreateWorkshops);
                 Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                 CheckBox checkBox = new CheckBox("CreateWorkshops");
                 checkBoxesMap.put(checkBox, elemento);
                 grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         crearWorkshop.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaCrearWorkshops configAvanzada = new configuracionAvanzadaCrearWorkshops(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         enrollWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.EnrollWorkshop);
                 Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
                 CheckBox checkBox = new CheckBox("EnrollWorkshops");
                 checkBoxesMap.put(checkBox, elemento);
                 grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         enrollWorkshop.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaEnrollWorkshop configAvanzada = new configuracionAvanzadaEnrollWorkshop(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
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
         crearUsuario.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 variablesPeppermint.firstName ="pineapple";
                 variablesPeppermint.lastName = "user";
                 variablesPeppermint.passwordRegister = "123123aA";
                 configuracionAvanzadaRegistro configAvanzada = new configuracionAvanzadaRegistro(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         enviarSolicitudDeAmistad.setOnAction(e->{
             listaDeEspera.add(ExecMethod.SendFriendRequest);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("SendFriendRequest");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         enviarSolicitudDeAmistad.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaSendFriends configAvanzada = new configuracionAvanzadaSendFriends(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
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
         generarInviteGuest.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaEnviarInviteGuest configAvanzada = new configuracionAvanzadaEnviarInviteGuest(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         enviarRecomendaciones.setOnAction(e->{
             listaDeEspera.add(ExecMethod.EnviarRecomendaciones);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("EnviarRecomendaciones");
             variablesPeppermint.userSendRecomendation ="AAAAAAusuariorecomendacionpineapple";
             variablesPeppermint.userSendRecomendationQA ="Paula Gomez";
             variablesPeppermint.emailRecomendationSending="pineappleuser1685718024380@mailinator.com";
             variablesPeppermint.emailRecomendationSendingQA="LauraPadilla1693506039635@mailinator.com";
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         enviarRecomendaciones.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaSendRecomendaciones configAvanzada = new configuracionAvanzadaSendRecomendaciones(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         guardarBookmark.setOnAction(e->{
             listaDeEspera.add(ExecMethod.GuardarBookmark);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("GuardarBookmark");
             variablesPeppermint.emailUserBookmark="pineappleuser1685718024380@mailinator.com";
             variablesPeppermint.emailUserBookmarkQA="LauraPadilla1693506039635@mailinator.com";
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         guardarBookmark.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaBookmark configAvanzada = new configuracionAvanzadaBookmark(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         unirMultiplesWorkshop.setOnAction(e->{
             listaDeEspera.add(ExecMethod.UnirMultiplesWorkshpos);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("UnirMultiplesWorkshpos");
             variablesPeppermint.emailUserEnrollMultiplesWorkshops = "pineappleuser1686586295370@mailinator.com";
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         unirMultiplesWorkshop.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaEnrollMultiWorkshop configAvanzada = new configuracionAvanzadaEnrollMultiWorkshop(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         unirMultiplesClub.setOnAction(e->{
             listaDeEspera.add(ExecMethod.UnirMultiplesClubs);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("UnirMultiplesClubs");
             emailUserUnirMultiplesClub="pineAppleUser1683738718947@mailinator.com";
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         unirMultiplesClub.setOnMousePressed( event -> {
             if (event.isSecondaryButtonDown()){
                 executionDetails=executionDetailstf.getText();
                 configuracionAvanzadaEnrollClub configAvanzada = new configuracionAvanzadaEnrollClub(executionDetails,seleccion);
                 Stage configAvanzadaStage = new Stage();
                 configAvanzada.start(configAvanzadaStage);
                 configAvanzadaStage.show();
             }
         });
         recomendarUsuarios.setOnAction(e->{
             listaDeEspera.add(ExecMethod.RecomendarUsuario);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("RecomendarUsuario");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         likePost.setOnAction(e->{
             listaDeEspera.add(ExecMethod.LikePost);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("LikePost");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         buttonexecuteEnviarActivity.setOnAction(e->{
             listaDeEspera.add(ExecMethod.EnviarActivity);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("EnviarActivity");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         buttonexecuteResponderActivity.setOnAction(e->{
             listaDeEspera.add(ExecMethod.ResponderActivity);
             Enum elemento = listaDeEspera.get(listaDeEspera.size()-1);
             CheckBox checkBox = new CheckBox("ResponderActivity");
             checkBoxesMap.put(checkBox, elemento);
             grid.add(checkBox, 0, listaDeEspera.size()-1);
         });
         ayuda.setOnAction(e->{
             dialog.show();
         });
     }, "interfaceThread");
     if(interfaceThread.isAlive()) {
         interfaceThread.stop();
     }else {
         interfaceThread.start();
     }
     execute.setOnAction(e->{
         Thread execute=  new Thread (()->{
             executionDetails = executionDetailstf.getText();
            accion();
         }, "execute");
         if(execute.isAlive()) {
             execute.stop();
         }else {
             metodosPeppermint.iniciarTest();
             execute.start();
            }
        });
    }
    public void accion(){
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
                case EnviarRecomendaciones:
                    actionSendRecomendation();
                    break;
                case GuardarBookmark:
                    actionSaveBookmark();
                    break;
                case UnirMultiplesWorkshpos:
                    actionEnrollMultiplesWorkshops();
                    break;
                case UnirMultiplesClubs:
                    actionJoinMultiplesClubs();
                    break;
                case RecomendarUsuario:
                    actionRecomendarUsuarios();
                    break;
                case EnviarActivity:
                    actionEnviarActivity();
                    break;
                case ResponderActivity:
                    actionResponderActivity();
                    break;
                case ValidarDominio:
                    actionValidarDominios();
                    break;
                case LikePost:
                    actionLikePost();
                    break;
                case SuiteBasica:
                    actionCrearWorkshop();
                    actionCreateArticle();
                    actionCreateClub();
                    actionCreateTechnique();
                    actionCreateClubEvent();
                    actionCreateLesson();
                    actionCreateSegment();
                    actionCreateUsuario();
                    actionEnrollWorkshop();
                    actionSendFriendRequest();
                    actionJoinClub();
                    actionInviteGuest();
                    actionPostClub();
                    actionSendRecomendation();
                    actionSaveBookmark();
                    actionRecomendarUsuarios();
                    break;
            }
        }
    }
}
