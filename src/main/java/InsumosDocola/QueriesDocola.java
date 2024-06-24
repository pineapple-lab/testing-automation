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
            String insertSql = "INSERT INTO users (`emailUser`,`rol`,`ambiente`) " +
                    "VALUES('"+email+"','"+joinRol+"','"+linkNavigation+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateUndefinedUser(String email) {
        try {
            connectDatabase();
            String insertSql = "UPDATE undefinedusers SET emailUser ='" + email + "' WHERE rol = '"+joinRol+"' AND ambiente = '"+linkNavigation+"'";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getEmailUser(String joinRol){
        try {
            if(joinRol == null){
                joinRol = "Content provider";
            }
            System.out.println(joinRol);
            connectDatabase();
            stm=CN.createStatement();
            if(linkNavigation=="http://localhost:4200/") {
                rs = stm.executeQuery("SELECT * FROM testbddocola.users WHERE rol = '" + joinRol + "' and ambiente = '"+linkNavigation+"' ORDER BY RAND() LIMIT 1");
            }
            if(linkNavigation=="https://docolasandbox.web.app/"){
                rs = stm.executeQuery("SELECT * FROM testbddocola.users WHERE rol = '" + joinRol + "' and ambiente = '"+linkNavigation+"' ORDER BY RAND() LIMIT 1");
            }
            while(rs.next()) {
                email = rs.getString(rs.findColumn("emailUser"));
            }
            CN.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return email;
    }
    public String getUndefinedUser(String joinRol){
        try {
            if(joinRol == null){
                joinRol = "Content provider";
            }
            System.out.println("Rol: "+joinRol);
            connectDatabase();
            stm=CN.createStatement();
            if(linkNavigation=="http://localhost:4200/") {
                rs = stm.executeQuery("SELECT * FROM testbddocola.undefinedusers WHERE rol = '" + joinRol + "' and ambiente = '"+linkNavigation+"' ORDER BY RAND() LIMIT 1");
            }
            if(linkNavigation=="https://docolasandbox.web.app/"){
                rs = stm.executeQuery("SELECT * FROM testbddocola.undefinedusers WHERE rol = '" + joinRol + "' and ambiente = '"+linkNavigation+"' ORDER BY RAND() LIMIT 1");
            }
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
