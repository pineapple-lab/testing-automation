package SpaceLogik.pw.Compare;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class compareFuncionSave extends robotBaseSpaceLogik {

    @Test
    public void validacionSaveCompare(){
        nameComparison="pruebAutomatizada60-validacionSaveCompare";
        login();
        crearCompareTerm10();
        abrirCompare();
        guardarCompare();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        abrirCompare();
        page.focus("#root");
        Assertions.assertFalse(page.getByLabel("200 N LaSalle").isChecked());
    }
}
