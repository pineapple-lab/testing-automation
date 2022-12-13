package testEnConstruccionPeppermint;

import java.sql.*;

public class conexionsql {
    public static void main(String[] args) {
        conexionbd();
    }

    public static void conexionbd(){
        String url = "jdbc:mysql://localhost:3306/contacts?serverTimezone=UTC";
        String username = "root";
        String password = "TsG972003308-";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next()){
                System.out.println(resultSet.getString("person_id")+"/"+resultSet.getString("person_first_name")+"/"+resultSet.getString("person_last_name"));
            }
            connection.close();
            statement.close();
            resultSet.close();
        }catch (SQLException e) { e.printStackTrace(); }
    }
}
