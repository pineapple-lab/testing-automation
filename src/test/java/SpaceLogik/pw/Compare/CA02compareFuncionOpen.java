package SpaceLogik.pw.Compare;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA02compareFuncionOpen extends robotBaseSpaceLogik {

    @Test
   public void CA021validacionOpenCompare(){
       nameComparison="pruebAutomatizada59-validacionOpenCompare";
       login();
       crearCompareTerm5();
       abrirCompare();
       page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Comparison: pruebAutomatizada59-validacionOpenCompare"));
   }
}
