package SpaceLogik.pw;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class myDealFuncionEdit extends robotBaseSpaceLogik {

    @Test
    public void validacionEditLeaseTypeLocation(){
        iniciarVariablesEditMyDealLeaseTypeLocation();
        login();
        editarMyDealLeaseTypeLocation();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertTrue(page.getByLabel("NEW").isChecked());
        Assertions.assertTrue(page.getByLabel("Within 3 mile radius").isChecked());
        Assertions.assertTrue(page.getByLabel("Another address").isChecked());
    }
    @Test
    public void validacionEditOfficeSize(){
        iniciarVariablesEditMyDealOfficeSize();
        login();
        editarMyDealOfficeSize();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
        Assertions.assertTrue(page.getByLabel("Specific headcount").isChecked());
        Assertions.assertTrue(page.getByLabel("Adjust by seats").isChecked());
    }
    @Test
    public void validacionEditOccupancyAndSchedule(){
        login();
        editarMyDealOccupancyAndSchedule();
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
