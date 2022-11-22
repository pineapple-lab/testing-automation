package SpaceLogik.pw;

import com.insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class myAmentiesFuncionEdit extends robotBaseSpaceLogik {
    @Test
    public void validacionEditMyAmenities(){
        login();
        editarMyAmenities();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
