package InsumosArla;

import java.sql.*;

public class QueriesArla extends ContextArla {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testbdarla?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private Connection connectDatabase()throws SQLException{
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
    public void saveClient(String email, Boolean registerClient){
        String insertSql = "INSERT INTO clients (`emailUser`,`register`,`environment`) VALUES(?, ?, ?)";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setString(1,email);
            stmt.setBoolean(2,registerClient);
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
    public void savePractice(String savePracticeName){
        String insertSql = "INSERT INTO practice (`practiceName`) VALUES(?)";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setString(1,savePracticeName);
            stmt.executeUpdate();
        }catch(SQLException ex) {
            handleSQLException(ex);
        }
    }
    public void saveInvitation(String email, int rol, String firstName, String lastName){
        String getLastPracticeIdSql = "SELECT id FROM practice ORDER BY id DESC LIMIT 1";
        String insertSql = "INSERT INTO invitations (`idPractice`, `userEmail`, `register`, `userRol`, `firstName`, `lastName`) VALUES(?, ?, FALSE, ?, ?, ?)";
        try {Connection connection = connectDatabase();
            PreparedStatement getLastPracticeIdSmt = connection.prepareStatement(getLastPracticeIdSql);
            ResultSet resultSet = getLastPracticeIdSmt.executeQuery();
            resultSet.next();
            long lastPracticeid = resultSet.getLong("id");
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setLong(1,lastPracticeid);
            stmt.setString(2,email);
            stmt.setInt(3,rol);
            stmt.setString(4,firstName);
            stmt.setString(5,lastName);
            stmt.executeUpdate();
        }catch(SQLException ex) {
            handleSQLException(ex);
        }
    }
    public void updateRegisterInvitation(String email){
        String updateSql = "UPDATE invitations SET register = 1 WHERE userEmail = ?";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(updateSql);
            stmt.setString(1,email);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        System.out.println("Se actualizo correctamente el estado register\n" +
                "User: "+email+"\n");
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
    /*public String getInvitationEmail(int idPractice){
        String query = "SELECT userEmail, firstName, lastName FROM testbddocola.invitations WHERE idPractice = ? and register = 0 ORDER BY id ASC LIMIT 1";
        try(Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1,idPractice);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            userInvitation = resultSet.getString("userEmail");
            invitationFirstName = resultSet.getString("firstName");
            invitationLastName = resultSet.getString("lastName");
        }catch (SQLException ex) {
            handleSQLException(ex);
        }
        return userInvitation;
    }*/
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
