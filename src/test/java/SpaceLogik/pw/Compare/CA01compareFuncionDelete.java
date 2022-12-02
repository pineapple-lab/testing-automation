package SpaceLogik.pw.Compare;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA01compareFuncionDelete extends robotBaseSpaceLogik {
    @Test
    public void CA011validacionDeleteCompare(){
        nameComparison ="pruebAutomatizada58-validacionDeleteCompare";
        login();
        crearCompareTerm7();
        borrarCompare();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison deleted successfully"));
        page.focus("#root");
        Assertions.assertFalse(page.isVisible("text=pruebAutomatizada58-validacionDeleteCompare"));
    }
}
