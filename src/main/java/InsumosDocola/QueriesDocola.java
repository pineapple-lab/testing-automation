package InsumosDocola;
import java.sql.*;

public class QueriesDocola extends ContextBaseDocola{
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testbddocola?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private Connection connectDatabase()throws SQLException{
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
    public void saveUser(String email){
        String insertSql = "INSERT INTO users (`emailUser`,`rol`,`ambiente`) VALUES(?, ?, ?)";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setString(1,email);
            stmt.setString(2,userRole);
            stmt.setString(3,navigationLink);
            stmt.executeUpdate();
        }catch(SQLException ex) {
            handleSQLException(ex);
        }
    }
    public void updateUndefinedUser(String email) {
        String updateSql = "UPDATE undefinedusers SET emailUser = ? WHERE rol = ? AND ambiente = ?";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(updateSql);
            stmt.setString(1,email);
            stmt.setString(2,userRole);
            stmt.setString(3,navigationLink);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        System.out.println("Se actualizo correctamente email por defecto\n" +
                "Rol: "+userRole+"\n"+
                "Ambiente: "+navigationLink);
    }
    public String getEmailUser(String joinRol){
            if(joinRol == null){
                joinRol = "Content provider";
            }
            String selectSql = "SELECT * FROM testbddocola.users WHERE rol = ? and ambiente =  ? ORDER BY RAND() LIMIT 1";
            return getUserEmailQuery(selectSql, joinRol);
    }
    public String getUndefinedUser(String joinRol){
            if(joinRol == null){
                joinRol = "Content provider";
            }
            String selectSql = "SELECT * FROM testbddocola.undefinedusers WHERE rol = ? and ambiente = ? ORDER BY RAND() LIMIT 1";
            return getUserEmailQuery(selectSql, joinRol);
    }
    private String getUserEmailQuery(String sql, String joinRol){
        String email = null;
        try(Connection connection = connectDatabase();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,joinRol);
            stmt.setString(2,navigationLink);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    email = rs.getString("emailUser");
                }
            }
        }catch (SQLException ex){
            handleSQLException(ex);
        }

        return email;
    }
    private void handleSQLException(SQLException ex) {
        System.err.println("SQL Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}
