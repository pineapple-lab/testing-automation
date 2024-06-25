package Peppermint;
import javafx.scene.control.CheckBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static insumosPeppermint.variablesPeppermint.outputStream;

public class interfaceActions extends interfacePropiedadesEstilosYposicionamiento {
    enum ExecMethod {
        CreateWorkshops,
        EnrollWorkshop,
        CreateArticle,
        CreateClub,
        CreateTechnique,
        CreateClubEvent,
        CreateTaxonomy,
        CreateTag,
        CreateLesson,
        CreateSegment,
        CreateUsuario,
        SendFriendRequest,
        JoinClub,
        GenerateInviteGuest,
        GeneratePostClub,
        EnviarRecomendaciones,
        RecomendarUsuario,
        UnirMultiplesWorkshpos,
        UnirMultiplesClubs,
        GuardarBookmark,
        EnviarActivity,
        ResponderActivity,
        ValidarDominio,
        SuiteBasica,
        LikePost
    }
    public void actionCrearWorkshop() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando workshop");
            functionWorkshopManagment test = new functionWorkshopManagment();
            test.validationCreateWorkshop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionEliminarDeLaCola() {
        List<CheckBox> checkBoxesSeleccionados = new ArrayList<>();
        for (CheckBox checkBox : checkBoxesMap.keySet()) {
            if (checkBox.isSelected()) {
                checkBoxesSeleccionados.add(checkBox);
            }
        }
        for (CheckBox checkBox : checkBoxesSeleccionados) {
            Enum elemento = checkBoxesMap.get(checkBox);
            listaDeEspera.remove(elemento);
            checkBoxesMap.remove(checkBox);
            grid.getChildren().remove(checkBox);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void actionEnrollWorkshop() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("iniciando Enroll workshop");
            System.out.println("iniciando Enroll workshop");
            functionWorkshopUser test = new functionWorkshopUser();
            test.validateWorkshopEnrollmente();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateArticle() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando articulo");
            System.out.println("Creando articulo");
            functionArticleManagment test = new functionArticleManagment();
            test.validationCreateArticle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateClub() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando club");
            System.out.println("Creando club");
            functionClubManagment test = new functionClubManagment();
            test.validationCreateClub();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTechnique() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando technique");
            System.out.println("Creando technique");
            functionTechniqueManagment test = new functionTechniqueManagment();
            test.validationCreateTechnique();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateClubEvent() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando club event");
            System.out.println("Creando club event");
            functionEventManagment test = new functionEventManagment();
            test.validationCreateEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTaxonomy() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionContentTaxonomy test = new functionContentTaxonomy();
            test.validationCreateTaxonomy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateTag() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionTag test = new functionTag();
            test.validationCreateTag();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateLesson() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando lesson");
            System.out.println("Creando lesson");
            functionLessonManagment test = new functionLessonManagment();
            test.validationCreateLesson();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateSegment() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando segment");
            System.out.println("Creando segment");
            functionSegmentsManagment test = new functionSegmentsManagment();
            test.validationCreateSegment();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionCreateUsuario() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando usuario");
            System.out.println("Creando usuario");
            functionRegistryManagment test = new functionRegistryManagment();
            test.validationCreateUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionSendFriendRequest() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Enviando solicitud de amistad");
            System.out.println("Enviando solicitud de amistad");
            functionFriendRequest test = new functionFriendRequest();
            test.validationSendAcceptFriendRequest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionJoinClub() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Uniendo a club");
            System.out.println("Uniendo a club");
            functionClubManagment test = new functionClubManagment();
            test.validationJoinClub();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionPostClub() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("\nCreando post club");
            System.out.println("\nCreando post club");
            functionClubManagment test = new functionClubManagment();
            test.validationPostClub();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionLikePost() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionLike test = new functionLike();
            test.validationLikePost();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionInviteGuest() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Creando invite guest");
            System.out.println("Creando invite guest");
            functionInviteGuest test = new functionInviteGuest();
            test.validationCreateInviteGuest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionSendRecomendation() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Enviando recomendacion");
            System.out.println("Enviando recomendacion");
            functionSendRecomendation test = new functionSendRecomendation();
            test.validationSendRecomendation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionEnrollMultiplesWorkshops() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionWorkshopUser test = new functionWorkshopUser();
            test.validateMultipleWorkshopEnrollment();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionJoinMultiplesClubs() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionClubManagment test = new functionClubManagment();
            test.validationMultipleClubJoin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionSaveBookmark() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Guardando bookmark");
            System.out.println("Guardando bookmark");
            functionBookmark test = new functionBookmark();
            test.validationSaveBookmark();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionRecomendarUsuarios() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            outputStream.println("Recomendando usuario");
            System.out.println("Recomendando usuario");
            functionSendRecomendation test = new functionSendRecomendation();
            test.validationSendUserRecommendation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionEnviarActivity() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionWorkshopUser test = new functionWorkshopUser();
            test.validateSendActivity();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionResponderActivity() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            functionWorkshopUser test = new functionWorkshopUser();
            test.validationReplyActivity();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void actionValidarDominios() {
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "UPDATE testbdpeppermint.configuracion SET executionDetails = " + "'" + executionDetails + "'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
            mailDomainValidation test = new mailDomainValidation();
            test.validationDomains();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
