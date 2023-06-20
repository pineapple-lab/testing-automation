package insumosPeppermint;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import org.jetbrains.kotlin.serialization.js.ast.JsAstProtoBuf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.List;
public class robotBasePeppermint extends consultasSQLCasosFallidos {
    public void iniciarTest(){
        shouldStopTest = false;
    }
    public void detenerTest(){
    shouldStopTest = true;
}
    public void serverStatus(){
        APIResponse response = page.request().get("https://peppermint-development.firebaseapp.com/");
        int statusCode = response.status();
        assert(response).ok();
        System.out.println("Server status: "+statusCode);
        System.out.println("-----------------------------------------------------------");
        printStream.println("Server status: "+statusCode);
        printStream.println("-----------------------------------------------------------");
    }
    public void iniciarContexto(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        printStream.println("\n-----------------------------------------------------------");
        printStream.println("Iniciando ejecucion....");
        printStream.println("-----------------------------------------------------------");
        launchBrowser();
        createContextAndPage();
    }
    public void iniciarNavegacion(){
        printStream.println("\nAmbiente: "+linkDeNavegacion+"\n");
        System.out.println("\nAmbiente: "+linkDeNavegacion+"\n");
        Keyboard kb = page.keyboard();
        kb.press("Control+KeyN");
        page.navigate(linkDeNavegacion);
    }
    public void imprimirCantidadDeEjecuciones (){
        if(ejecutar>1) {
            System.out.println("El caso se va a ejecutar " + ejecutar + " veces");
            printStream.println("El caso se va a ejecutar " + ejecutar + " veces");
        }else {
            System.out.println("El caso se va a ejecutar " + ejecutar + " vez");
            printStream.println("El caso se va a ejecutar " + ejecutar + " vez");
        }
    }
    public void imprimirCantidadDeCasosEjecutados (){
        if(contador>1) {
            System.out.println("El caso se ejecuto " + contador + " veces");
            printStream.println("El caso se ejecuto " + contador + " veces");
        }else {
            System.out.println("El caso se ejecuto " + contador + " vez");
            printStream.println("El caso se ejecuto " + contador + " vez");
        }
        int ejecucionesRestantes = ejecutar - contador;
        System.out.println("Ejecuciones restantes: "+ejecucionesRestantes);
        printStream.println("Ejecuciones restantes: "+ejecucionesRestantes);
        if(ejecucionesRestantes==0){
            System.out.println("-----------------------------------------------------------");
            System.out.println("Fin de la ejecucion");
            printStream.println("-----------------------------------------------------------");
            printStream.println("Fin de la ejecucion");
        }
        System.out.println("-----------------------------------------------------------\n");
        printStream.println("-----------------------------------------------------------\n");
    }
    public void imprimirCantidadDeCasosEjecutadosRegistroInviteguest (){
        if(contadorRegistro>1) {
            System.out.println("El caso se ejecuto " + contadorRegistro + " veces\n");
            printStream.println("El caso se ejecuto " + contadorRegistro + " veces\n");
        }else {
            System.out.println("El caso se ejecuto " + contadorRegistro + " vez\n");
            printStream.println("El caso se ejecuto " + contadorRegistro + " vez\n");
        }
        int ejecucionesRestantes = ejecutar - contadorRegistro;
        System.out.println("Ejecuciones restantes: "+ejecucionesRestantes);
        printStream.println("Ejecuciones restantes: "+ejecucionesRestantes);
    }
    public void buscarContenido(){
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search mat-form-field input");
        kb.insertText(searchingElement);
        kb.press("Enter");
        page.waitForSelector("tbody tr:first-child td:last-child button:last-child");
    }
    public void registrarUsuario(){
        Keyboard kb = page.keyboard();
        page.click("text=Begin your Membership");
        page.fill("mat-card-content > div > div:nth-of-type(1) app-mat-form-field input",firstName);
        page.fill("mat-card-content > div > div:nth-of-type(2) app-mat-form-field input",lastName);
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(1) input",emailRegistro);
        page.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        if(page.isEnabled("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(1)")==false){
            page.click("mat-calendar tbody tr:nth-of-type(1) td:nth-of-type(2)");
        }else{ page.click("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(1)");
        }
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input",passwordRegistro);
        page.click("text=Sign up with email");
        page.fill("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(1) app-mat-form-field input",cardholderName);
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
        page.waitForTimeout(1000);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
        page.waitForTimeout(1000);
        kb.insertText(cardNumber);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
        page.waitForTimeout(1000);
        kb.insertText(monthExpired);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
        page.waitForTimeout(2000);
        kb.insertText(cvv);
        page.click("text=Pay $15.00");
        page.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        page.click("text=Continue");
        page.click("mat-chip-list mat-chip:nth-of-type(1)");
        page.click("mat-chip-list mat-chip:nth-of-type(2)");
        page.click("mat-chip-list mat-chip:nth-of-type(3)");
        page.waitForTimeout(3000);
        page.click(".mat-horizontal-content-container button:nth-of-type(2)");
    }
    public void guardarUsuario(){
        try {
            String url = "jdbc:mysql://localhost:3306/testbdpeppermint?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            Connection CN = DriverManager.getConnection(url, username, password);
            String insertSql = "INSERT INTO usuariosautomaticos (`emailRegistro`,`ambiente`) " +
                    "VALUES('"+emailRegistro+"','"+linkDeNavegacion+"')";
            Statement stmt = CN.createStatement();
            stmt.executeUpdate(insertSql);
            CN.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void guardarEmailsDelLoop(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.inviteguest SET email = "+"'"+inviteGuestEmailLoop+"'"+" WHERE ID="+"'"+posicion+"'";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void guardarEmails(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            String query1 = "UPDATE testbdpeppermint.inviteguest SET email = "+"'"+inviteGuestEmail+"'"+" WHERE ID="+"'"+contador+"'";
            stm.executeUpdate(query1);
        }catch(Exception e){}
        sqlclose();
    }
    public void traerEmail(){
        try {
            sqlconectar();
            Statement stm = CN.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM testbdpeppermint.inviteguest WHERE ID = "+contadorRegistro+"");
            while(rs.next()){
                emailGuest =rs.getString(rs.findColumn("email"));
            }
        }catch(Exception e){}
        sqlclose();
    }
    public void login(){
        System.out.println("Iniciando login...");
        printStream.println("Iniciando login...");
        Keyboard kb = page.keyboard();
        if(page.isVisible(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input")==false) {
            page.click("text=Sign in");
        }
        page.waitForSelector("text=Login with Google");
        page.waitForSelector("text=Login with Facebook");
        page.waitForSelector("text=Login with Email");
        Assertions.assertTrue(page.isVisible("text=Login with Google"));
        Assertions.assertTrue(page.isVisible("text=Login with Facebook"));
        Assertions.assertTrue(page.isVisible("text=Login with Email"));
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(1) input");
        kb.insertText(emailLogin);
        page.focus(".bg-primary-contrast form > .mat-card-content app-mat-form-field:nth-of-type(2) input");
        kb.insertText(passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
        page.waitForSelector("text=Login Successfull!");
        Assertions.assertTrue(page.isVisible("text=Login Successfull!"));
        System.out.println("El login del usuario "+emailLogin+" se realizo con exito \n");
        printStream.println("El login del usuario "+emailLogin+" se realizo con exito \n");
    }
    public void logout(){
      page.click("text=My Stuff");
      page.click("text=Sign out");
      page.waitForTimeout(3000);
    }
    public void hacerSolicitudDeAmistad(){
        Keyboard kb = page.keyboard();
        page.waitForSelector("text=Begin your Membership");
        page.click("text=Begin your Membership");
        page.fill("mat-card-content > div > div:nth-of-type(1) app-mat-form-field input",firstName);
        page.fill("mat-card-content > div > div:nth-of-type(2) app-mat-form-field input",lastName);
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(1) input",emailRegistro);
        page.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        if(page.isEnabled("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(3)")==false){
            page.click("mat-calendar tbody tr:nth-of-type(1) td:nth-of-type(2)");
        }else{ page.click("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(3)");
        }
        page.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input",passwordRegistro);
        page.click("text=Sign up with email");
        page.fill("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(1) app-mat-form-field input",cardholderName);
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
        page.waitForSelector("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
        page.waitForTimeout(1000);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(1) iframe");
        page.waitForTimeout(1000);
        kb.insertText(cardNumber);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) input");
        page.waitForTimeout(1000);
        kb.insertText(monthExpired);
        page.focus("app-payment > div > div > mat-card .wrapper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) iframe");
        page.waitForTimeout(2000);
        kb.insertText(cvv);
        page.click("text=Pay $15.00");
        page.waitForSelector("text=Continue");
        page.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        page.click("text=Continue");
        page.click("mat-chip-list mat-chip:nth-of-type(1)");
        page.click("mat-chip-list mat-chip:nth-of-type(2)");
        page.click("mat-chip-list mat-chip:nth-of-type(3)");
        page.waitForTimeout(3000);
        page.click(".mat-horizontal-content-container button:nth-of-type(2)");
        page.click("app-header > mat-toolbar>div:nth-of-type(3) > div > span > button:nth-of-type(1)");
        page.click("app-header > mat-toolbar>div:nth-of-type(2) > mat-card-content > mat-form-field > div > div:nth-of-type(1) > div:nth-of-type(4)");
        kb.type(userSendFriends);
        kb.press("Enter");
        System.out.println("Enviando solicitud de amistad");
        printStream.println("Enviando solicitud de amistad");
        page.click("app-search-results > div > main > div > mat-tab-group > div app-friends-card button");
        page.waitForTimeout(2000);
        logout();
        printStream.println("Solicitud de amistad enviada");
    }
    public void aceptarsolicitudeDeAmistad(){
        emailLogin=emailAceptarSolicitudesDeAmistad;
        login();
        page.click("app-header > mat-toolbar>div:nth-of-type(3) > div > span > button:nth-of-type(3)");
        page.waitForTimeout(1000);
        System.out.println("Aceptando solicitudes de amistad");
        printStream.println("Aceptando solicitudes de amistad");
        for(contadorAceptarAmistad=0; contadorAceptarAmistad<ejecutar;contadorAceptarAmistad++) {
            int contadorInterno= contadorAceptarAmistad+1;
            page.waitForTimeout(1000);
            page.click("app-notification > div > div > div:nth-of-type(2) > div:nth-of-type("+contadorInterno+") button:nth-of-type(1)");
        }
    }
    public void guardarBookmark(){
        Keyboard kb = page.keyboard();
        emailLogin=emailUserMuchoContenido;
        login();
        page.waitForSelector("text=My workshops");
        page.navigate("http://localhost:4200/content/workshops");
        for (contador=0; contador<ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon"));
        }
        page.navigate("http://localhost:4200/content/articles");
        for (contador=0; contador<ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon"));
        }
        page.navigate("http://localhost:4200/content/techniques");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon"));
        }
        page.navigate("http://localhost:4200/content/clubs");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(1)");
            page.waitForSelector("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon");
            Assertions.assertTrue(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-bookmark-icon > div > mat-icon"));
        }
        logout();
    }
    public void recomendarUsuarios(){
        Keyboard kb = page.keyboard();
        if(page.isVisible("app-profile-description")==false) {
            page.waitForSelector("text=My workshops");
        }
        page.navigate("http://localhost:4200/user/friends");
        page.waitForSelector(".main-container > div > div:nth-of-type(4) > div > div:nth-of-type("+contador+") mat-card");
        page.click(".main-container > div > div:nth-of-type(4) > div > div:nth-of-type("+contador+") mat-card");
        page.waitForSelector("app-profile-description > div:nth-of-type(1) app-three-dots");
        page.click("app-profile-description > div:nth-of-type(1) app-three-dots");
        page.waitForSelector(".mat-menu-panel > div > button:nth-of-type(1)");
        page.waitForSelector(".mat-menu-panel > div > button:nth-of-type(2)");
        page.click(".mat-menu-panel > div > button:nth-of-type(1)");
        page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
        kb.insertText(userSendRecomendation);
        page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips mat-chip-list mat-chip");
        page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
        page.waitForSelector("text=Your recommendation has been successfully sent");
    }
    public void enviarRecomendacion(){
        Keyboard kb = page.keyboard();
        emailLogin=emailRecomendationSending;
        login();
        page.waitForSelector("text=My workshops");
        page.navigate("http://localhost:4200/content/workshops");
        for (contador=0; contador<ejecutar;contador++){
           int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            kb.insertText(userSendRecomendation);
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            page.waitForSelector("text=Your recommendation has been successfully sent");
            Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            System.out.println("\nRecomendaciones de workshops enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
            printStream.println("\nRecomendaciones de workshops enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
        }
        page.navigate("http://localhost:4200/content/articles");
        for (contador=0; contador<ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            kb.insertText(userSendRecomendation);
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            page.waitForSelector("text=Your recommendation has been successfully sent");
            Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            System.out.println("\nRecomendaciones de articles enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
            printStream.println("\nRecomendaciones de articles enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
        }
        page.navigate("http://localhost:4200/content/techniques");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            kb.insertText(userSendRecomendation);
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            page.waitForSelector("text=Your recommendation has been successfully sent");
            Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            System.out.println("\nRecomendaciones de techniques enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
            printStream.println("\nRecomendaciones de techniques enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
        }
        page.navigate("http://localhost:4200/content/clubs");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+") app-three-dots button");
            page.click(".mat-menu-panel button:nth-of-type(2)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(5) app-mat-recommendation-chips");
            kb.insertText(userSendRecomendation);
            page.waitForSelector(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.click(".cdk-overlay-connected-position-bounding-box .cdk-overlay-pane mat-option:nth-of-type(1)");
            page.waitForSelector("app-bookmark-invitation-popup > div > div:nth-of-type(5) mat-chip span b");
            page.click("app-bookmark-invitation-popup > div > div:nth-of-type(6) button");
            page.waitForSelector("text=Your recommendation has been successfully sent");
            Assertions.assertTrue(page.isVisible("text=Your recommendation has been successfully sent"));
            System.out.println("\nRecomendaciones de clubs enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
            printStream.println("\nRecomendaciones de clubs enviadas: "+contadorInterno+" Recomendaciones faltantes: "+ejecutar);
        }
        logout();
    }
    public void enviarInviteGuest(){
        Keyboard kb = page.keyboard();
        long timeStamp = Instant.now().toEpochMilli();
        inviteGuest="inviteguest";
        inviteGuestEmail ="inviteguest"+contador+timeStamp+"@mailinator.com";
        page.click("text=My Stuff");
        page.click("text=Account Settings");
        page.click("text=Membership");
        page.click("text=Invite guests");
        System.out.println("Enviando invite guest...");
        printStream.println("Enviando invite guest...");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(2) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
        page.waitForSelector("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2) input");
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(1)>div:nth-of-type(2) input");
        kb.insertText(inviteGuest);
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
        kb.insertText(inviteGuest);
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
        kb.type(inviteGuest);
        page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2) input");
        kb.insertText(inviteGuestEmail);
        guardarEmails();
        if(ejecutar>1){
            for(contador =1;contador<ejecutar;contador++) {
                long timeStampLoop = Instant.now().toEpochMilli();
                inviteGuestEmailLoop ="inviteguest"+contador+timeStampLoop+"@mailinator.com";
                posicion=contador+1;
                page.click("text=Add another");
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+posicion+")>div:nth-of-type(1)>div:nth-of-type(2) input");
                kb.insertText(inviteGuest);
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+posicion+")>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(1) input");
                kb.insertText(inviteGuest);
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+posicion+")>div:nth-of-type(2)>div:nth-of-type(1) app-mat-form-field:nth-of-type(2) input");
                kb.insertText(inviteGuest);
                page.focus("app-guest-invite mat-card mat-card-content:nth-of-type(2)>div:nth-of-type("+posicion+")>div:nth-of-type(2)>div:nth-of-type(2) input");
                kb.insertText(inviteGuestEmailLoop);
                guardarEmailsDelLoop();
            }
        }
        page.waitForTimeout(9000);
        if(contador==ejecutar){
            page.click("text=Send invites");
        }
        page.waitForSelector("text=Guest pass has been sent successfully");
        page.waitForTimeout(40000);
    }
    @Test
    public void registrarInviteGuest(){
        Keyboard kb = page.keyboard();
        inviteGuest = "invite guest";
        page.navigate("https://www.mailinator.com/v4/public/inboxes.jsp");
        page.waitForSelector("#inbox_field");
        page.fill("#inbox_field",emailGuest);
        page.waitForTimeout(900);
        page.click("#inbox_pane > div:nth-of-type(1)>div:nth-of-type(5) button");
        //page.waitForTimeout(1000);
        page.waitForSelector(".os-padding table tr:nth-of-type(1) td:has-text('invites')");
        page.click(".os-padding table tr");
        page.waitForSelector(".wrapper-message-tabs ul li:nth-of-type(5) a");
        page.click(".wrapper-message-tabs ul li:nth-of-type(5) a");
        page.waitForSelector("#pills-links-content table td:has-text('register') a");
        page.click("#pills-links-content table td:has-text('register') a");
        page.waitForTimeout(900);
        List<Page> pages = context.pages();
        Page nuevaPestana = pages.get(pages.size() - 1);
        nuevaPestana.bringToFront();
        System.out.println("Registrando invite guest...");
        printStream.println("Registrando invite guest...");
        nuevaPestana.click("mat-card-content > mat-form-field mat-datepicker-toggle button");
        if(nuevaPestana.isEnabled("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(1)")==false){
            nuevaPestana.click("mat-calendar tbody tr:nth-of-type(1) td:nth-of-type(2)");
        }else{ nuevaPestana.click("mat-calendar tbody tr:nth-of-type(2) td:nth-of-type(1)");
        }
        nuevaPestana.fill("mat-card-content > app-mat-form-field:nth-of-type(2) input","123123aA");
        nuevaPestana.waitForTimeout(900);
        nuevaPestana.click("text=Sign up with email");
        nuevaPestana.click("mat-selection-list > div:nth-of-type(1) mat-radio-button");
        nuevaPestana.click("text=Continue");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(1)");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(2)");
        nuevaPestana.click("mat-chip-list mat-chip:nth-of-type(3)");
        nuevaPestana.waitForTimeout(900);
        nuevaPestana.click(".mat-horizontal-content-container button:nth-of-type(2)");
        nuevaPestana.click("text=My stuff");
        nuevaPestana.click("text=Sign out");
        page.waitForTimeout(1000);
        nuevaPestana.close();
        kb.press("Alt+F4");
    }
    public void createTechnique(){
        System.out.println("Creando technique...");
        printStream.println("Creando technique...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(2)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));

        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1) app-upload-media").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleTechnique);
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");
        kb.insertText(descriptionTechnique);
        page.click(".container > div:nth-of-type(2) app-generic-selects");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorTechnique+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips input");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagTechnique+")");
        //page.click(".margin-box  app-generic-selects > div > div > p");
        page.waitForSelector(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryTechnique+")");
       // page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryTechnique+")");
        page.waitForSelector(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");
        page.focus("app-movement-form >div>div>div>div:nth-of-type(3) .margin-box app-text-box  div > div:nth-of-type(1)");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".margin-box app-generic-selects .size-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");//ESTO ES UNA CHANCHADA Y HAY QUE CAMBIARLO
       //page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicTechnique+")");
        page.waitForTimeout(1000);
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The technique was created successfully");
        Assertions.assertTrue(page.isVisible("text=The technique was created successfully"));
    }
    public void crearSegment(){
        System.out.println("Creando Segment...");
        printStream.println("Creando Segment...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("tapp-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(3)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        FileChooser fileChooser1 = page.waitForFileChooser(()->{
            page.locator(".image-container:nth-of-type(1) app-upload-media").click();
        });
        fileChooser1.setFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus("form>div>div>div:nth-of-type(2) >div:nth-of-type(1) input");
        kb.insertText(titleSegments);
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        kb.insertText(descriptionSegments);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorSegments+")");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips");
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagSegments+")");
        page.click("app-text-box quill-editor > div:nth-of-type(2)");
        kb.insertText(transcriptSegments);
        //page.click("text=+ Add category");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categorySegments+")");
        page.focus("form>div>div>div:nth-of-type(3) textArea");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categorySegments+")");
        page.click("form > div > div > div:nth-of-type(4) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicSegments+")");
        page.click("form > div > div > div:nth-of-type(5) > div > button:nth-of-type(1)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div:nth-of-type(1) > button:nth-of-type(1)");
        page.waitForSelector("text=Techniques added successfully");
        Assertions.assertTrue(page.isVisible("text=Techniques added successfully"));
        page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
        page.click("text=Publish");
        page.click(".mat-dialog-container div:nth-of-type(2) button");
        page.waitForSelector("text=The segment was created successfully");
        Assertions.assertTrue(page.isVisible("text=The segment was created successfully"));
    }
    public void crearLesson(){
        System.out.println("Creando Lesson...");
        printStream.println("Creando Lesson...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(4)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.click(".container > div:nth-of-type(4) button");
        page.click("tbody tr:first-child td:first-child label");
        page.click("app-mat-table > div:nth-of-type(1) > button");
        page.waitForSelector("text=Segments added successfully");
        Assertions.assertTrue(page.isVisible("text=Segments added successfully"));
        page.locator("app-upload-media input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleLesson);
        page.click(".container > div:nth-of-type(2) app-select-creator input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionLesson);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagLesson+")");
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryLesson+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicLesson+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicLesson+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicLesson+")");*/
        page.click("text=Publish");
        page.click(".mat-dialog-container div:nth-of-type(2) button");
        page.waitForSelector("text=The lesson was created successfully");
        Assertions.assertTrue(page.isVisible("text=Segments added successfully"));
    }
    public void crearWorkshop(){
            System.out.println("Creando Workshop...");
            printStream.println("Creando Workshop...");
            Keyboard kb = page.keyboard();
            if ((page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)")) == false) {
                page.click("text=My Stuff");
                page.click("text=Contact Us");
                page.click("text=My Stuff");
                page.click("text=Admin Area");
            }
            page.click("a:nth-of-type(5)");
            page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
            page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
            page.click(".ma-auto button");
            page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
            page.focus(".ng-star-inserted > app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-mat-form-field input");
            kb.insertText(titleWorkshop);
            page.click(".ng-star-inserted app-select-creator");
            page.click(".cdk-overlay-pane mat-option:nth-of-type(" + creatorWorkshop + ")");
            page.click(".ng-star-inserted > app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-text-box quill-editor  > div:nth-of-type(2)");
            kb.insertText(descriptionWorkshop);
            page.click(".ng-star-inserted .mat-chip-list-wrapper");
            page.click(".cdk-overlay-pane mat-option:nth-of-type(" + tagWorkshop + ")");
            //page.click(".ng-star-inserted app-generic-selects > div > div > p");
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(1) mat-form-field");
            page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(" + categoryWorkshop + ")");
            //page.click(".ng-star-inserted form > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
            //page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicWorkshop+")");
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(1) quill-editor > div:nth-of-type(2)");
            kb.insertText(targetAudienceWorkshop);
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) quill-editor > div:nth-of-type(2)");
            kb.insertText(learningObjectiveWorkshop);
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(3) quill-editor > div:nth-of-type(2)");
            kb.insertText(whatDoYouNeed);
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(4) quill-editor > div:nth-of-type(2)");
            kb.insertText(howItWorks);
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(2) > div:nth-of-type(1) > app-generic-selects .heigth-selects:nth-of-type(2) mat-form-field");
            page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(" + topicWorkshop + ")");
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(1)");
            page.click(".cdk-overlay-container mat-option:nth-of-type(" + purposeWorkshop + ")");
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(2)");
            page.click(".cdk-overlay-container mat-option:nth-of-type(" + skillsWorkshop + ")");
            page.click(".ng-star-inserted app-course-form > form > div > div:nth-of-type(3) > div:nth-of-type(2) > mat-form-field:nth-of-type(3)");
            page.click(".cdk-overlay-container mat-option:nth-of-type(" + physicalActvityWorkshop + ")");
            page.click("app-admin-top-bar > div button:nth-of-type(2)");
            page.click("form > div:nth-of-type(1) > div:nth-of-type(1) button");
            page.click("form > div:nth-of-type(1) > div:nth-of-type(2) button");
            page.click("form > div:nth-of-type(2) > div:nth-of-type(1) button");
            page.click("form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
            kb.insertText(questionWorkshop);
            page.click("form > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
            kb.insertText(answerWorkshop);
            page.click("form > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(1)");
            page.click(".cdk-overlay-container mat-option:nth-of-type(" + reviewerWorkshop + ")");
            page.click("form > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2)");
            kb.insertText(reviewWorkshop);
            page.locator(".ng-star-inserted app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
            page.click(".ma-auto button");
            page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
            page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2) app-generic-selects > div input");
            page.click(".cdk-overlay-container mat-option:nth-of-type(" + studentWorkshop + ")");
            page.click("form > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) mat-list mat-expansion-panel > div > div > div > div > div:nth-of-type(2) textarea");
            kb.insertText(descriptionWorkshop);
            page.click("form > div:nth-of-type(2) > div:nth-of-type(2) button:nth-of-type(1)");
            page.fill("mat-dialog-container input", addLinksWorkshop);
            page.click("mat-dialog-container div:nth-of-type(2) .material-popup button");
            page.locator("//*[@id=\"file\"]").setInputFiles(Paths.get(pathImage));
            page.click("app-admin-top-bar > div button:nth-of-type(2)");
            page.click("app-course-outlet-form app-course-lesson-form > button");
            page.click("app-course-outlet-form app-course-lesson-form > div:nth-of-type(2) button");
            page.click("mat-dialog-container tbody tr:first-child td:first-child mat-checkbox");
            page.click("app-mat-table > div:nth-of-type(1) > button");
            page.waitForSelector("text=Lessons added successfully");
            Assertions.assertTrue(page.isVisible("text=Lessons added successfully"));
            //page.click("app-drag-drop-sorting div:nth-of-type(2) mat-expansion-panel-header");
            page.click("text=+ Add activities");
            page.click(".cdk-overlay-container button:nth-of-type(1)");
            page.click("text=+ Add activities");
            page.click(".cdk-overlay-container button:nth-of-type(2)");
            page.click("app-course-lesson-form > div:nth-of-type(1)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(1)");
            page.click("app-course-lesson-form > div:nth-of-type(1)  > app-drag-drop-sorting  > mat-list > div:nth-of-type(2) > mat-expansion-panel > div >div>div> .ng-star-inserted > div:nth-of-type(4) > div:nth-of-type(2) mat-list > div:nth-of-type(2)");
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(1) mat-form-field input");
            kb.insertText(titleZoomWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(1) mat-form-field input");
            kb.insertText(deadlineWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) mat-form-field input");
            page.click(".clock-face__container > div:last-child button");
            page.click(".clock-face__container > div:last-child button");
            page.click(".mat-dialog-actions div:nth-of-type(2) button");
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(3) mat-form-field input");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(2) > div:nth-of-type(4) mat-form-field input");
            kb.insertText("1");
            page.fill("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(3) textarea", descriptionZoomWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(1)  mat-expansion-panel > div > div > div > div > div:nth-of-type(4) input");
            kb.insertText(zoomUrlWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(3) input");
            kb.insertText("2");
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
            kb.insertText(activitiesTitleWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
            kb.insertText(activitiesDescriptionWorkshop);
            page.locator("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(1) mat-expansion-panel > div >div>div>div input[type=file]").setInputFiles(Paths.get(pathVideo));
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(1) input");
            kb.insertText(syncUpTitleWorkshop);
            page.click("app-course-lesson-form > div:nth-of-type(1) > app-drag-drop-sorting > mat-list > div:nth-of-type(2) > .ng-star-inserted > div > div > div > div > div:nth-of-type(4) > div:nth-of-type(2) app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div >div>div>div>div:nth-of-type(2) textarea");
            kb.insertText(syncUpDescriptionWorkshop);
            page.click("app-admin-top-bar > div button:nth-of-type(2)");
            page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(1)");
            page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(2)");
            page.click("app-course-type-form >div>div>div>div mat-checkbox:nth-of-type(3)");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
            page.click("mat-calendar tbody tr:last-child td:last-child");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
            page.click(".cdk-overlay-pane mat-option:nth-of-type(" + instructorSoloWithInstructor + ")");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) .mat-checkbox-layout ");
            page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(2)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(2) app-mat-chips");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
            page.click("mat-calendar tbody tr:last-child td:last-child");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(2) mat-form-field");
            page.click(".cdk-overlay-pane mat-option:nth-of-type(" + instructorGroupWithInstructor + ")");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) .mat-checkbox-layout");
            page.waitForSelector("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div > div > div > div > div > div > div:nth-of-type(2) app-mat-chips");
            kb.press("ArrowDown");
            kb.press("Enter");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(1) mat-form-field input");
            kb.insertText(maxStudentsGroupWithInstructor);
            page.click("app-course-type-form >div>div>div>div:nth-of-type(3)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > div:nth-of-type(3) > div:nth-of-type(2) mat-form-field input");
            kb.insertText(optimalBuddyGroupGroupWithInstructor);
            page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(1) mat-form-field");
            page.click("mat-calendar tbody tr:last-child td:last-child");
            page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(1) > div:nth-of-type(2) input");
            kb.insertText(maxStudentsGroup);
            page.click("app-course-type-form >div>div>div>div:nth-of-type(4)  mat-expansion-panel > div > div .expansion-body > div:nth-of-type(1) .padding > div > .ng-star-inserted > div:nth-of-type(2)  input");
            kb.insertText(optimalBuddyGroup);
            page.click("text=Publish");//app-admin-top-bar > div button:nth-of-type(3)
            page.click("mat-dialog-container > div > div:nth-of-type(2) button");
            page.waitForSelector("text=The workshop was created successfully");
            Assertions.assertTrue(page.isVisible("text=The workshop was created successfully"));
        }
    public void enrollWorkshop(){
        page.waitForSelector("text=My workshops");
        page.navigate("http://localhost:4200/content/workshops");//ESTO ES UNA CHANCHADA HAY QUE REFACTORIZARLO
        page.waitForTimeout(12000);
        page.waitForSelector("app-all-cards .container > div:nth-of-type(2)");
        page.click("app-all-cards .container > div:nth-of-type(2)");
        System.out.println("Enrolando usuario");
        printStream.println("Enrolando usuario");
        page.click(".bg-primary-contrast div:nth-of-type(2) > div > mat-card > div > button");
        page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button");
        page.click(".mat-horizontal-content-container > div:nth-of-type(1) > div:nth-of-type(3) > button:nth-of-type(2)");
        page.click("app-guest-invite > div > div:nth-of-type(2) p");
        System.out.println("Enroll realizado con exito\n");
        printStream.println("Enroll realizado con exito\n");
    }
    public void unirUsuarioMuchosWorkshop(){
        Keyboard kb = page.keyboard();
        emailLogin=emailUserMuchoContenido;
        login();
        page.navigate("http://localhost:4200/content/workshops");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+2;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while (page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+")")==false){
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+")");
            page.waitForSelector(".bg-primary-contrast div:nth-of-type(2) > div > mat-card > div > button");
            page.click(".bg-primary-contrast div:nth-of-type(2) > div > mat-card > div > button");
            page.waitForSelector(".mat-horizontal-content-container mat-radio-group:nth-of-type(1) mat-radio-button");
            if(page.isVisible(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button")==true){
                page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(2) mat-radio-button");
            }else {
                page.click(".mat-horizontal-content-container mat-radio-group:nth-of-type(1) mat-radio-button");
            }
            page.click(".mat-horizontal-content-container > div:nth-of-type(1) > div:nth-of-type(3) > button:nth-of-type(2)");
            page.click("app-guest-invite > div > div:nth-of-type(2) p");
            page.click("app-breadcrumb ul li:nth-of-type(1) a");

        }
    }
    public void crearArticulo(){
        System.out.println("Creando Articulo...");
        printStream.println("Creando Articulo...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("a:nth-of-type(6)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field input");
        kb.insertText(titleArticle);
        page.click(".container > div:nth-of-type(1) app-generic-selects");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorArticle+")");
        page.focus(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        kb.insertText(descriptionArticle);
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        page.click(".container > div > div:nth-of-type(2) app-mat-chips input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1)  > div > app-mat-form-field:nth-of-type(1)");
        kb.insertText(estimatedReadTime);
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type(1)");
        //kb.press("Enter");
        //page.waitForSelector(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicArticle+")");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(1) > app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(1) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForTimeout(500);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicArticle+")");
        //kb.press("Enter");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("text=Add text");
        page.click("text=Add title");
        page.click("text=Add image");
        page.click("text=Add video");
        page.click("app-drag-drop-sorting mat-list > div:nth-of-type(1) quill-editor > div:nth-of-type(2)");
        page.waitForTimeout(500);
        kb.insertText(textContent);
        kb.press("Control+Shift+ArrowLeft");
        page.click("quill-editor > div:nth-of-type(1) button:nth-of-type(7)");
        page.click("tbody tr:first-child td:first-child mat-checkbox");
        page.click("app-mat-table > div > button");
        page.click("app-drag-drop-sorting mat-list > div:nth-of-type(2) mat-expansion-panel > div > div  mat-form-field");
        page.waitForTimeout(500);
        kb.insertText(contentTitle);
        kb.press("Tab");
        page.locator("app-upload-image input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.locator("//*[@id=\"video-file\"]").setInputFiles(Paths.get(pathVideo));
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The article was created successfully");
        Assertions.assertTrue(page.isVisible("text=The article was created successfully"));
    }
    public void createEvent(){
        System.out.println("Creando Evento...");
        printStream.println("Creando Evento...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("app-side-bar a:nth-of-type(7)");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(titleEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2) textarea");
        kb.insertText(descriptionEvent);
        page.focus("app-events-form > div > div > div:nth-of-type(2)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(1) input");
        kb.insertText(urlZoomEvent);
        page.click("app-events-form > div > div > div:nth-of-type(2) mat-chip-list input");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+clubEvent+")");
        page.click("app-events-form > div > div > div:nth-of-type(1)> div:nth-of-type(1) > div > app-mat-form-field:nth-of-type(2)");
        page.click("app-events-form > div > div > div:nth-of-type(2) mat-chip-list input");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+clubEvent+")");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) button");
        page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
        page.click("ngx-mat-timepicker tbody tr:nth-of-type(3) td:first-child button");
        page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        page.click("app-events-form > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) button");
        page.click(".mat-calendar-content tbody > tr:last-child > td:last-child");
        page.click("ngx-mat-datetime-content div:nth-of-type(2) button");
        page.click("app-events-form > div > div > .btn-radius-secondary > div:nth-of-type(2) > div:nth-of-type(3) > mat-form-field");
        kb.press("ArrowDown");
        kb.press("Enter");
        page.click("app-admin-top-bar > div button:nth-of-type(2)");
        page.click("mat-dialog-container div:nth-of-type(2) button:nth-of-type(1)");
        page.waitForSelector("text=The event was created successfully");
        Assertions.assertTrue(page.isVisible("text=The event was created successfully"));
    }
    public void deleteEvent(){
        System.out.println("Eliminando evento...");
        printStream.println("Eliminando evento...");
        Keyboard kb = page.keyboard();
        page.focus("app-paging-search input");
        kb.insertText(titleEvent);
        page.click("tbody tr:first-child td:last-child button:last-child");
        page.click("app-alert div > div:nth-of-type(3) button:nth-of-type(2)");
    }
    public void crearTaxonomy(){
        System.out.println("Creando Taxonomy...");
        printStream.println("Creando Taxonomy...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content taxonomy");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleCategory); //hardcode falta conexion con bd
        page.click("form mat-dialog-content .mat-button-wrapper");
        page.focus("form mat-dialog-content  .ng-star-inserted mat-form-field input");
        kb.insertText(titleTopic); //hardcode falta conexion con bd
        page.click("text=+ Add subtopic");
        page.click("mat-dialog-content > div:nth-of-type(2) .subTopic mat-form-field");
        kb.insertText(titleSubTopic);
        page.click("text=Save");
        page.waitForSelector("text=The category was created successfully");
        Assertions.assertTrue(page.isVisible("text=The category was created successfully"));
    }
    public void crearTag(){
        System.out.println("Creando Tag...");
        printStream.println("Creando Tag...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Configuration");
        page.click("text=Content tags");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.focus("mat-dialog-content input");
        kb.insertText(titleTag);
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.click("mat-dialog-content mat-form-field");
        kb.press("Enter");
        page.waitForSelector("mat-chip");
        page.click("mat-dialog-actions button:nth-of-type(2)");
        page.waitForSelector("text=The tag was created successfully");
        Assertions.assertTrue(page.isVisible("text=The tag was created successfully"));
    }
    public void joinClub(){
        if(page.isVisible("app-text-editor")==true) {
            page.waitForSelector("app-text-editor");
        }
        if(page.isVisible("text=My workshops")==true) {
            page.navigate("http://localhost:4200/content/clubs");
            page.waitForSelector("app-all-cards .container > div:nth-of-type(1)");
            page.click("app-all-cards .container > div:nth-of-type(1)");
        }
        page.click("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(3) > button");
        page.waitForSelector("text=The club was joined successfully");
        Assertions.assertTrue(page.isVisible("text=The club was joined successfully"));
    }
    public void unirUsuarioMuchosClub(){
        Keyboard kb = page.keyboard();
        emailLogin=emailUserMuchoContenido;
        login();
        page.navigate("http://localhost:4200/content/clubs");
        for (contador=0; contador <ejecutar;contador++){
            int contadorInterno = contador+1;
            page.waitForSelector("app-all-cards .container > div:nth-of-type(2) app-three-dots button");
            while(page.isVisible("app-all-cards .container > div:nth-of-type("+contadorInterno+")")==false) {
                kb.press("Control+End");
            }
            page.click("app-all-cards .container > div:nth-of-type("+contadorInterno+")");
            page.click("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(2) > button");
            page.waitForSelector("text=The club was joined successfully");
            Assertions.assertTrue(page.isVisible("text=The club was joined successfully"));
            page.click("app-breadcrumb ul li:nth-of-type(1) a");
            System.out.print("el usuario se ha unido a "+ contadorInterno+" de "+ejecutar+" clubs");
            printStream.println("el usuario se ha unido a "+ contadorInterno+" de "+ejecutar+" clubs");
        }
    }
    public void crearPostClub(){
        Keyboard kb = page.keyboard();
        long timeStamp = Instant.now().toEpochMilli();
        page.waitForSelector("app-text-editor");
        if(page.isVisible("text=My workshops")==true) {
            page.navigate("http://localhost:4200/content/clubs");
            page.waitForSelector("app-all-cards .container > div:nth-of-type(1)");
            page.click("app-all-cards .container > div:nth-of-type(1)");
        }
        page.waitForSelector("app-club-details > div > div > div:nth-of-type(1) > div > div > div:nth-of-type(3) > button");
        if(page.isVisible("app-text-editor")==false){
            joinClub();
        }
        System.out.println("\nCreando post\n");
        printStream.println("\nCreando post\n");
        page.focus("app-text-editor textarea");
        kb.insertText(timeStamp + "   :   " + textoParaPublicaciones);
        page.click("app-text-editor button:nth-of-type(4)");
    }
    public void crearClub(){
        System.out.println("Creando club...");
        printStream.println("Creando club...");
        Keyboard kb = page.keyboard();
        if( (page.isVisible("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)"))==false) {
            page.click("text=My Stuff");
            page.click("text=Contact Us");
            page.click("text=My Stuff");
            page.click("text=Admin Area");
        }
        page.click("text=Club management");
        page.click("app-mat-table > div:nth-of-type(1) div button:nth-of-type(1)");
        page.locator(".image-container:nth-of-type(1) input[type=file]").setInputFiles(Paths.get(pathImage));
        page.click(".ma-auto button");
        page.focus(".container > div:nth-of-type(2) app-mat-form-field input");
        kb.insertText(titleClub);
        page.click(".container > div:nth-of-type(2) app-generic-selects input");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+creatorClub+")");
        page.focus(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        kb.insertText(descriptionClub);
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-chips");
        page.waitForSelector(".cdk-overlay-pane");
        page.click(".cdk-overlay-pane mat-option:nth-of-type("+tagClub+")");
        //page.click(".container app-generic-selects > div > div > p");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(1) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+categoryClub+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForTimeout(500);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(1) app-mat-form-field textarea");
        page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(2) mat-form-field");
        page.waitForTimeout(500);
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+topicClub+")");
        /*page.click(".container > div:nth-of-type(3) > div:nth-of-type(2) app-generic-selects .size-generic-selects > div:nth-of-type(3) mat-form-field");
        page.click(".cdk-overlay-connected-position-bounding-box > div  mat-option:nth-of-type("+subtopicClub+")");*/
        page.click("text=Publish");
        page.click("mat-dialog-container > div > div:nth-of-type(2) button");
        page.waitForSelector("text=The club was created successfully");
        Assertions.assertTrue(page.isVisible("text=The club was created successfully"));
    }
}
