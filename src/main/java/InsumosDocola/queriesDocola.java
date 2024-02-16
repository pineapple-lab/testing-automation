package InsumosDocola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class queriesDocola extends contextBaseDocola{
    Connection CN;
    Statement stm;
    ResultSet rs;
    public void connectDatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbddocola?serverTimezone=UTC";
            String userName = "root";
            String password = "root";
            CN = DriverManager.getConnection(url, userName, password);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void saveUser(){
        try {
            connectDatabase();
            String insertSql = "INSERT INTO users (`emailUser`) " +
                    "VALUES('"+email+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getEmailUser(){
        try {
            connectDatabase();
            stm=CN.createStatement();
            rs = stm.executeQuery("SELECT * FROM testbddocola.users ORDER BY RAND() LIMIT 1");
            while(rs.next()) {
                email = rs.getString(rs.findColumn("emailUser"));
            }
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return email;
    }
}
