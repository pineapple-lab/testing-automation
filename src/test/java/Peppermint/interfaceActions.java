package Peppermint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class interfaceActions extends interfacePropiedadesEstilosYposicionamiento {
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
