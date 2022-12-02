package SpaceLogik.pw.Compare;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA04compareFuncionSaveAs extends robotBaseSpaceLogik {

    @Test
    public void CA041validacionSaveAsComparisonTerm3(){
        nameComparison="pruebAutomatizada52-validacionSaveAsComparisonTerm3";
        login();
        crearCompareTerm3();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada52-validacionSaveAsComparisonTerm3"));
    }
    @Test
    public void CA042validacionSaveAsComparisonTerm5(){
        nameComparison="pruebAutomatizada53-validacionSaveAsComparisonTerm5";
        login();
        crearCompareTerm5();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada53-validacionSaveAsComparisonTerm5"));
    }
    @Test
    public void CA043validacionSaveAsComparisonTerm7(){
        nameComparison="pruebAutomatizada54-validacionSaveAsComparisonTerm7";
        login();
        crearCompareTerm7();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada54-validacionSaveAsComparisonTerm7"));
    }
    @Test
    public void CA044validacionSaveAsComparisonTerm10(){
        nameComparison="pruebAutomatizada55-validacionSaveAsComparisonTerm10";
        login();
        crearCompareTerm10();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada55-validacionSaveAsComparisonTerm10"));
    }
    @Test
    public void CA045validacionSaveAsComparisonTerm12(){
        nameComparison="pruebAutomatizada56-validacionSaveAsComparisonTerm12";
        login();
        crearCompareTerm12();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada56-validacionSaveAsComparisonTerm12"));
    }
    @Test
    public void CA046validacionSaveAsComparisonTerm15(){
        nameComparison="pruebAutomatizada57-validacionSaveAsComparisonTerm15";
        login();
        crearCompareTerm15();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison saved successfully"));
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada57-validacionSaveAsComparisonTerm15"));
    }
}
