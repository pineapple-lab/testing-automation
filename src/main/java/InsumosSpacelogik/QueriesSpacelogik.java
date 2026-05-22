package InsumosSpacelogik;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueriesSpacelogik {private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testbdspacelogik?serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private Connection connectDatabase()throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
    public void saveUser(String guru, String recompanie, String environment){
        String insertSql = "INSERT INTO users (`guru`,`re_companie`,`environment`,`passwordConfig`) VALUES(?, ?, ?,false)";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setString(1,guru);
            stmt.setString(2,recompanie);
            stmt.setString(3,environment);
            stmt.executeUpdate();
            System.out.println("Guru guardado con exito");
        }catch(SQLException ex) {
            handleSQLException(ex);
        }
    }
    public void saveUserRecompanie(String email, String environment){
        String insertSql = "INSERT INTO recompanieusers (`email`,`environment`) VALUES(?, ?)";
        try {Connection connection = connectDatabase();
            PreparedStatement stmt = connection.prepareStatement(insertSql);
            stmt.setString(1,email);
            stmt.setString(2,environment);
            stmt.executeUpdate();
            System.out.println("Recomanie guardado con exito");
        }catch(SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoPasswordConfigUser(String environment) {
        String query = "SELECT guru, environment FROM users WHERE passwordConfig = false and environment = '"+environment+"' LIMIT 1";
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updatePassword(String guru) {
        String updateSql = "UPDATE users SET passwordConfig = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contraseña actualizada para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoOnboardingCompleteUser(String environment) {
        String query = "SELECT guru, environment FROM users WHERE onboardingComplete = false and environment = '"+environment+"' LIMIT 1";
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updateOnboarding(String guru) {
        String updateSql = "UPDATE users SET onboardingComplete = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Onboarding actualizado para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoCreditComplete(String environment) {
        String query = "SELECT guru, environment FROM users WHERE creditsComplete = false and environment = '"+environment+"' LIMIT 1";
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updateCredit(String guru) {
        String updateSql = "UPDATE users SET creditsComplete = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Creditos comprados para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoClientAndLocationComplete(String environment) {
        String query = "SELECT guru, environment FROM users WHERE clientCreate = false and environment = '"+environment+"' LIMIT 1";
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updateClientAndLocation(String guru) {
        String updateSql = "UPDATE users SET clientCreate = true,locationCreate = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente y location creada para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoLocationActivate(String environment) {
        String query = "SELECT guru, environment FROM users WHERE locationActivate = false and environment = '"+environment+"' LIMIT 1";
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updateLocationActivate(String guru) {
        String updateSql = "UPDATE users SET locationActivate = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Location activada para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    public Map<String, String> getNoProgramCreate(String environment) {
        String query = "SELECT guru, environment FROM users WHERE programCreate = false and environment = '" +environment + "' LIMIT 1";
        System.out.println(environment);
        Map<String, String> user = new HashMap<>();

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                user.put("guru", rs.getString("guru"));
                user.put("environment", rs.getString("environment"));
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
        return user;
    }
    public void updateProgram(String guru) {
        String updateSql = "UPDATE users SET programCreate = true WHERE guru = ?";

        try (Connection connection = connectDatabase();
             PreparedStatement stmt = connection.prepareStatement(updateSql)) {

            stmt.setString(1, guru);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Program creado para: " + guru);
            }
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }
    /*public void updateUndefinedUser(String email) {
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
    public String getUndefinedUser(String joinRol){
        if(joinRol == null){
            joinRol = "Content provider";
        }
        String selectSql = "SELECT * FROM testbddocola.undefinedusers WHERE rol = ? and ambiente = ? ORDER BY RAND() LIMIT 1";
        return getUserEmailQuery(selectSql, joinRol);
    }
    public String getInvitationEmail(int idPractice){
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
    }
   */
    private void handleSQLException(SQLException ex) {
        System.err.println("SQL Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}
