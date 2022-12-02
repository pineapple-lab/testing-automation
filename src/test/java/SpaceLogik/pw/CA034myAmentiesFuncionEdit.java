package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA034myAmentiesFuncionEdit extends robotBaseSpaceLogik {
    @Test
    public void CA0341validacionEditMyAmenities(){
        login();
        editarMyAmenities();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
