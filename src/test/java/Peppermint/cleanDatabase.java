package Peppermint;
import com.microsoft.playwright.Keyboard;
import insumosPeppermint.methodsPeppermint;
import org.junit.jupiter.api.Test;
import java.sql.Statement;
public class cleanDatabase extends methodsPeppermint {
    @Test
    public void limpiarUserBD(){
        Keyboard kb = page.keyboard();
        execute=383;
        navigationLink="http://localhost:4200/user/plans/";
        for(counter=0; counter<=execute;counter++){
            startNavigation();
            startVariablesLoginDeleteUser();
            if(login()){
                continue;
            }
            System.out.println("executionDetails:"+counter+"\\"+execute+"\n");
            page.waitForSelector("text= My workshops");
            page.waitForTimeout(1000);
            if (page.isVisible("mat-dialog-container > app-expired-popup")) {
                kb.press("Escape");
                try {
                    sqlconectar();
                    Statement stm = CN.createStatement();
                    stm.executeUpdate("DELETE FROM testbdpeppermint.usuariosautomaticos WHERE id= '"+idUsuario+"'");
                    System.out.println("Usuario borrado:");
                    System.out.println("id: "+idUsuario);
                    System.out.println("Email: "+emailLogin);
                    userDeleted++;
                    stm.executeUpdate("INSERT INTO usuariossinmembresia (`emailUser`) " +
                            "VALUES('"+emailLogin+"')");
                } catch (Exception e) {
                    sqlclose();
                }
                System.out.println("Cantidad borrados: "+userDeleted+"\n");
            }
            if(page.isVisible("text= My workshops")){
                logout();
            }
        }
        System.out.println("Cantidad total borrados: "+userDeleted+"\n");
    }
}
