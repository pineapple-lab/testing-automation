package SpaceLogik.pw.Program;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA018programFuncionEdit extends robotBaseSpaceLogik {


        @Test
        public void CA0181validacionAddRoom(){
        iniciarVariablesAutoProgramFeliz();
        Keyboard kb = page.keyboard();
        nameCase=nameRoomAutoProgram+"24-validacionAddRoom";
        assertions="text="+nameCase;
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible(assertions));
        page.focus(".my-programs-header input");
        kb.insertText(nameCase);
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0182validacionDeleteRoom() {
        Keyboard kb = page.keyboard();
        nameCase = "pruebAutomatizada25-validacionProgramDeleteRoom";
        login();
        crearPrograma();
        page.focus("tbody");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada25-validacionProgramDeleteRoom"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada25-validacionProgramDeleteRoom");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        eliminarRoom();
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertFalse(page.isVisible("text=Coat Closet"));
    }
    @Test
    public void CA0183validacionEditRoomOptions(){
        System.out.println("Iniciando caso de prueba...");
        Keyboard kb = page.keyboard();
        iniciarVariablesEditRoom();
        iniciarVariablesAutoProgramFeliz();
        nameProgram = "pruebAutomatizada";
        System.out.println("El caso CA0183 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameRoomAutoProgram+".26-validacionEditRoomOptions.Ejecuciones:"+contador;
            login();
            crearPrograma();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Program created successfully"));
            assertions="text="+nameCase;
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus(".my-programs-header input");
            kb.insertText(nameCase);
            crearRoom();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Room created successfully"));
            guardarRoom();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Coat Closet"));
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            editarRoomOptions();
            page.focus("#root");
            assertions = "text=" + employeAreaTypesProgram;
            sqlGuardarCasoSiFallaEditarRoomProgram();
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus(".program-room-list-table tbody tr td:nth-of-type(3)");
            assertions = "text=" + quantityRoomOptionsProgram;
            sqlGuardarCasoSiFallaEditarRoomProgram();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0183 se ejecuto "+contador+ " veces");
        }
    }
    @Test
    public void CA0184validacionEditSpacePlan(){
        Keyboard kb = page.keyboard();
        nameCase="pruebAutomatizada27-validacionEditSpacePlan";
        commentsRoomDetails="validacionEditSpacePlanRoomDetails";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada27-validacionEditSpacePlan"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada27-validacionEditSpacePlan");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus(".program-room-list-table-container table");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarSpacePlanRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        page.click(".program-room-detail-areas-container button:nth-of-type(1)");
        page.click(".program-room-detail-areas-container button:nth-of-type(2)");
        page.focus(".space-plan-comment-container textarea");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada27-validacionEditSpacePlan"));
    }
    @Test
    public void CA0185validacionEditarConstructionLevel(){
        Keyboard kb = page.keyboard();
        nameCase="pruebAutomatizada28-validacionEditarConstructionLevel";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        page.focus("tbody");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada28-validacionEditarConstructionLevel"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada28-validacionEditarConstructionLevel");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus(".program-room-list-table-container table");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarConstructionLevelRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0186validacionEditarUpgradeOptions(){
        Keyboard kb = page.keyboard();
        nameCase="pruebAutomatizada29-validacionEditarUpgradeOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada29-validacionEditarUpgradeOptions"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada29-validacionEditarUpgradeOptions");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus(".program-room-list-table-container table");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarUpgradeOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0187validacionEditarAlacarteOptions(){
        Keyboard kb = page.keyboard();
        nameCase="pruebAutomatizada30-validacionEditarAlacarteOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada30-validacionEditarAlacarteOptions"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada30-validacionEditarAlacarteOptions");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus(".program-room-list-table-container table");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarAlacarteOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0188validacionEdicionCompleta(){
        System.out.println("Iniciando caso de prueba....");
        Keyboard kb = page.keyboard();
        iniciarVariablesEditRoom();
        iniciarVariablesAutoProgramFeliz();
        System.out.println("El caso de prueba CA0188 se va a ejecutar "+ejecutar +" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameRoomAutoProgram+".31-validacionEdicionCompleta.Ejecuciones:"+contador;
            commentsRoomDetails=nameCase;
            login();
            crearPrograma();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Program created successfully"));
            assertions="text="+nameCase;
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus(".my-programs-header input");
            kb.insertText(nameCase);
            crearRoom();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Room created successfully"));
            guardarRoom();
            page.focus(".program-room-list-table-container table");
            Assertions.assertTrue(page.isVisible("text=Coat Closet"));
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            editarRoomOptions();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Workstations"));
            assertions="text="+quantityRoomOptionsProgram;
            Assertions.assertTrue(page.isVisible(assertions));
            editarSpacePlanRoomDetails();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            page.click(".program-room-detail-areas-container button:nth-of-type(1)");
            page.click(".program-room-detail-areas-container button:nth-of-type(2)");
            page.focus(".space-plan-comment-container textarea");
            Assertions.assertTrue(page.isVisible(assertions));
            editarConstructionLevelRoomDetails();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            //editarUpgradeOptionsRoomDetails();
            page.focus("#root");
            //Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            editarAlacarteOptionsRoomDetails();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            System.out.println("El caso de prueba CA0188 se ejecuto "+contador+" veces");
        }
    }
}
