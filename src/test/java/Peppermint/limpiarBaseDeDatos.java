package Peppermint;

import com.microsoft.playwright.Keyboard;
import insumosPeppermint.robotBasePeppermint;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;

public class limpiarBaseDeDatos extends robotBasePeppermint {
    @Test
    public void limpiarUserBD(){
        Keyboard kb = page.keyboard();
        ejecutar=94;
        linkDeNavegacion="http://localhost:4200/user/plans";

        for(contador=0; contador<=ejecutar;contador++){
            iniciarNavegacion();
            iniciarVariablesLoginBorrarUsuarios();
            if(login()){
                continue;
            }
            System.out.println("ejecuciones:"+contador+"\\"+ejecutar+"\n");
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
                    userBorrados++;
                } catch (Exception e) {
                    sqlclose();
                }
                System.out.println("Cantidad borrados: "+userBorrados+"\n");
            }
            if(page.isVisible("text= My workshops")){
                logout();
            }
        }
        System.out.println("Cantidad total borrados: "+userBorrados+"\n");
    }
}
