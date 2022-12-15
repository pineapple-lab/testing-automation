package testEnConstruccionPeppermint;

import java.sql.*;



public class conexionsql {

    private static final String url = "jdbc:mysql://localhost:3306/testbdspacelogik?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";
    private static Connection CN;

    static String prueba = "prueba";

    public static void main(String[] args) {
        conectar();
        insertar();
        close();
    }
    public static void conectar(){
        try {
            CN = DriverManager.getConnection(url, username, password);
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void insertar(){
        try {
            Statement st = CN.createStatement();
            String query = "INSERT INTO nombredecaso (nombre_de_prueba) VALUES('prueba2')";
            st.executeUpdate(query);
            System.out.println("se guardo el dato");
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void close() {
        try {
            CN.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

