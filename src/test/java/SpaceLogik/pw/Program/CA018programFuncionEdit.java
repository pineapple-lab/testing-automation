package SpaceLogik.pw.Program;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA018programFuncionEdit extends robotBaseSpaceLogik {


        @Test
        public void CA0181validacionAddRoom(){
        Keyboard kb = page.keyboard();
        nameProgram="pruebAutomatizada24-validacionAddRoom";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada24-validacionAddRoom"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada24-validacionAddRoom");
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
        nameProgram = "pruebAutomatizada25-validacionDeleteRoom";
        login();
        crearPrograma();
        page.focus("tbody");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada25-validacionDeleteRoom"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada25-validacionDeleteRoom");
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
        Keyboard kb = page.keyboard();
        iniciarVariablesEditRoom();
        nameProgram = "pruebAutomatizada26-validacionEditRoomOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada26-validacionEditRoomOptions"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada26-validacionEditRoomOptions");
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Coat Closet"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarRoomOptions();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Workstations"));
        Assertions.assertTrue(page.isVisible("text=50"));
    }
    @Test
    public void CA0184validacionEditSpacePlan(){
        Keyboard kb = page.keyboard();
        nameProgram="pruebAutomatizada27-validacionEditSpacePlan";
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
        nameProgram="pruebAutomatizada28-validacionEditarConstructionLevel";
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
        nameProgram="pruebAutomatizada29-validacionEditarUpgradeOptions";
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
        nameProgram="pruebAutomatizada30-validacionEditarAlacarteOptions";
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
        Keyboard kb = page.keyboard();
        iniciarVariablesEditRoom();
        nameProgram = "pruebAutomatizada31-validacionEdicionCompleta";
        commentsRoomDetails = "pruebAutomatizada31-validacionEdicionCompleta";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada31-validacionEdicionCompleta"));
        page.focus(".my-programs-header input");
        kb.insertText("pruebAutomatizada31-validacionEdicionCompleta");
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
        Assertions.assertTrue(page.isVisible("text=50"));
        editarSpacePlanRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        page.click(".program-room-detail-areas-container button:nth-of-type(1)");
        page.click(".program-room-detail-areas-container button:nth-of-type(2)");
        page.focus(".space-plan-comment-container textarea");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada31-validacionEdicionCompleta"));
        editarConstructionLevelRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarUpgradeOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarAlacarteOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
