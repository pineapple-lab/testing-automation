package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class myPreferencesFuncionEdit extends robotBaseSpaceLogik {

    @Test
    public void validacionEditConstructionQualityDefault(){
        login();
        editarMyPreferencesConstructionQualityDefault();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));

    }
    @Test
    public void validacionEditFurnitureQualityDefault(){
        login();
        editarMyPreferencesFurnitureQualityDefault();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void vaildacionEditFinancialDefaults(){
        login();
        editarMyPreferenceFinancialDefaults();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void validacionEditYourIndustry(){
        login();
        editarMyPreferencesYourIndustry();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
