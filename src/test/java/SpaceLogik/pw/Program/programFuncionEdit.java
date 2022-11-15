package SpaceLogik.pw.Program;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class programFuncionEdit extends robotBaseSpaceLogik {

        @Test
        public void validacionAddRoom(){
        nameProgram="pruebAutomatizada24-validacionAddRoom";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada24-validacionAddRoom"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionDeleteRoom() {
        nameProgram = "pruebAutomatizada25-validacionDeleteRoom";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada25-validacionDeleteRoom"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        eliminarRoom();
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertFalse(page.isVisible("text=Conference Room"));
    }
    @Test
    public void ValidacionEditRoomOptions(){
        iniciarVariablesEditRoom();
        nameProgram = "pruebAutomatizada26-validacionEditRoomOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada26-validacionEditRoomOptions"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarRoomOptions();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Workstations"));
        Assertions.assertTrue(page.isVisible("text=50"));
    }
    @Test
    public void validacionEditSpacePlan(){
        nameProgram="pruebAutomatizada27-validacionEditSpacePlan";
        commentsRoomDetails="validacionEditSpacePlanRoomDetails";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada27-validacionEditSpacePlan"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
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
    public void validacionEditarConstructionLevel(){
        nameProgram="pruebAutomatizada28-validacionEditarConstructionLevel";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada28-validacionEditarConstructionLevel"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarConstructionLevelRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditarUpgradeOptions(){
        nameProgram="pruebAutomatizada29-validacionEditarUpgradeOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada29-validacionEditarUpgradeOptions"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarUpgradeOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditarAlacarteOptions(){
        nameProgram="pruebAutomatizada30-validacionEditarAlacarteOptions";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada30-validacionEditarAlacarteOptions"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        editarAlacarteOptionsRoomDetails();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    public void validacionEdicionCompleta(){
        iniciarVariablesEditRoom();
        nameProgram = "pruebAutomatizada31-validacionEdicionCompleta";
        login();
        crearPrograma();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program created successfully"));
        Assertions.assertTrue(page.isVisible("text=pruebAutomatizada31-validacionEdicionCompleta"));
        crearRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Room created successfully"));
        guardarRoom();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Conference Room"));
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
