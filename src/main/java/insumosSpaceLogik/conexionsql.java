package insumosSpaceLogik;

import java.sql.*;



public class conexionsql extends variablesSpaceLogik{

    private static final String url = "jdbc:mysql://localhost:3306/testbdspacelogik?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";
    public static Connection CN;

    public static void sqlconectar(){
        try {
            CN = DriverManager.getConnection(url, username, password);
        }catch (Exception ex){ex.printStackTrace();}
    }
    public static void sqlclose() {
        try {
            CN.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

