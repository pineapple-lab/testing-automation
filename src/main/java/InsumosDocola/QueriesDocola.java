package InsumosDocola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class QueriesDocola extends ContextBaseDocola{
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
    public void saveUser(String email){
        try {
            connectDatabase();
            String insertSql = "INSERT INTO users (`emailUser`,`rol`) " +
                    "VALUES('"+email+"','"+joinRol+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getEmailUser(String joinRol){
        try {
            if(joinRol == null){
                joinRol = "Clinician";
            }
            System.out.println(joinRol);
            connectDatabase();
            stm=CN.createStatement();
            rs = stm.executeQuery("SELECT * FROM testbddocola.users WHERE rol = '"+joinRol+"' ORDER BY RAND() LIMIT 1");
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
