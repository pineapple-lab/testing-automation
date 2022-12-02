package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA036myPreferencesFuncionEdit extends robotBaseSpaceLogik {

    @Test
    public void CA0361validacionEditConstructionQualityDefault(){
        login();
        editarMyPreferencesConstructionQualityDefault();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));

    }
    @Test
    public void CA0362validacionEditFurnitureQualityDefault(){
        login();
        editarMyPreferencesFurnitureQualityDefault();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0363vaildacionEditFinancialDefaults(){
        login();
        editarMyPreferenceFinancialDefaults();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
    @Test
    public void CA0364validacionEditYourIndustry(){
        login();
        editarMyPreferencesYourIndustry();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
