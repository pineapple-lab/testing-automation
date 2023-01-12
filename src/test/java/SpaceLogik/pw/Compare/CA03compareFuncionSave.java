package SpaceLogik.pw.Compare;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CA03compareFuncionSave extends robotBaseSpaceLogik {

    @Test
    public void CA031validacionSaveCompare(){
        nameComparison="pruebAutomatizada60-validacionSaveCompare";
        login();
        crearCompareTerm10();
        abrirCompare();
        guardarCompare();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        abrirCompare();
        page.focus(".building-list-component table");
        Assertions.assertFalse(page.getByLabel("150 N. Michigan Ave").isChecked());
    }
}
