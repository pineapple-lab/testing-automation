package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA013listingFuncionEditSpaceInfo extends robotBaseSpaceLogik {
    @Test
    public void CA0131validacionEditarListingBuildingRsf(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingRsf();
        System.out.println("El caso de preuba CA0131 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            login();
            editarListingBuildingRsf();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarBuildingRsf();
            page.focus(".Toastify__toast-body");
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0131 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0132validacionCrearSingleSuiteListingSpace(){

        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingRsf();
        System.out.println("El caso de preuba CA0131 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            login();
            iniciarVariablesListingSingleSuite();
            crearListingSingleSuiteSpace();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Suite created successfully"));
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            System.out.println("El caso CA0131 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0133validacionEliminarSingleSuiteSpace(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarBuildingRsf();
        System.out.println("El caso de prueba se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            login();
            iniciarVariablesListingSingleSuite();
            System.out.println(suiteNumberListingSpaceBuildin);
            crearListingSingleSuiteSpace();
            eliminarSingleSuiteSpace();
            assertions = "text= Suite "+suiteNumberListingSpaceBuildin+" deleted";
            page.focus(".Toastify__toast-body");
            page.waitForSelector("text=Suite "+suiteNumberListingSpaceBuildin+" deleted");
            Assertions.assertTrue(page.isVisible(assertions));
            Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
            System.out.println("El caso CA0131 se ejecuto "+counter+" veces");
        }
    }
    @Test
    public void CA0134validacionEditSingleSuiteSpace(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditarSingleSuite();
        System.out.println("El caso de preuba CA0134 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=suiteDescriptionListingSingleSuite+".97validacionEditSingleSuiteSpace.executionDetails:"+counter;
            suiteNumberListingSpaceBuildin=String.valueOf(counter);
            login();
            crearListingSingleSuiteSpace();
            editarListingSingleSuiteSpace();
            page.focus("#root");
            assertions="text=Suite edited successfully";
            sqlGuardarCasoSiFallaEditarBuildingSingleSuite();
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus("#root");
            assertions="text=Changes saved successfully";//
            sqlGuardarCasoSiFallaEditarBuildingSingleSuite();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0134 se ejecuto "+counter+" veces");
        }
    }
}
