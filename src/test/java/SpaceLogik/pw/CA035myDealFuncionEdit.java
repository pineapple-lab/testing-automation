package SpaceLogik.pw;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA035myDealFuncionEdit extends robotBaseSpaceLogik {

    @Test
    public void CA0351validacionEditLeaseTypeLocation(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditMyDealLeaseTypeLocation();
        System.out.println("El caso CA0351 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarMyDealLeaseTypeLocation();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarMyDealLeaseTypeLocation();
            Assertions.assertTrue(page.isVisible(assertions));
            Assertions.assertTrue(page.getByLabel("NEW").isChecked());
            Assertions.assertTrue(page.getByLabel("Within 3 mile radius").isChecked());
            Assertions.assertTrue(page.getByLabel("Another address").isChecked());
            System.out.println("El caso CA0351 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0352validacionEditOfficeSize(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesEditMyDealOfficeSize();
        System.out.println("El caso CA0352 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            login();
            editarMyDealOfficeSize();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaEditarMyDealOfficeSize();
            Assertions.assertTrue(page.isVisible(assertions));
            Assertions.assertTrue(page.getByLabel("REPLACE").isChecked());
            System.out.println("El caso CA0352 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0353validacionEditOccupancyAndSchedule(){
        login();
        editarMyDealOccupancyAndSchedule();
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }
}
