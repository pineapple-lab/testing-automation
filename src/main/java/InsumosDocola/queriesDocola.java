package InsumosDocola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class queriesDocola extends contextBaseDocola{
    public void saveUser(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbddocola?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "INSERT INTO users (`emailUser`) " +
                    "VALUES('"+emailRegister+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
