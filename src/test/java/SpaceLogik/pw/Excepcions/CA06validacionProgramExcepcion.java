package SpaceLogik.pw.Excepcions;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA06validacionProgramExcepcion extends robotBaseSpaceLogik {

    @Test
    public void CA061validacionNombreVacioProgramExcepcion(){
        login();
        excepcionProgramNombreVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Program name can't be empty"));
    }
    @Test
    public void CA062validacionNombreVacioAutoProgramExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesAutoProgramFeliz();
        System.out.println("El caso de prueba CA062 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameRoomAutoProgram = nameRoomAutoProgram+".34-validacionNombreVacioAutoProgramExcepcion"+contador;
            login();
            excepcionAutoProgramNombreVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Program name is required"));
            System.out.println("El caso de prueba CA062 se ejecuto "+contador+" veces");
        }
    }
   /* @Test
    public void CA063validacionLevelVacioExcepcion(){
        iniciarVariablesAutoProgramFeliz();
        nameAutoProgram = "pruebAutomatizada35-validacionLevelVacioExcepcion";
        nameRoomAutoProgram = "pruebAutomatizada35-validacionLevelVacioExcepcion";
        login();
        excepcionProgramLevelVacio();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Construction and furniture levels are required"));
    }------------------------------------------------------------------------------------------------->ESTE CASO YA NO APLICA*/
    @Test
    public void CA064validacionRoomNameVacionExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesAutoProgramFeliz();
        System.out.println("El caso de prueba CA064 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase = nameRoomAutoProgram+".36-validacionRoomNameVacionExcepcion"+contador;
            login();
            excepcionProgramRoomNameVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Please select a name for the room"));
            System.out.println("El caso de prueba CA064 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA065validacionAreaListVacioExcepcion(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesAutoProgramFeliz();
        System.out.println("El caso de prueba CA065 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase = nameRoomAutoProgram+".37-validacionAreaListVacioExcepcion.Ejecuciones:"+contador;
            nameRoomAutoProgram=nameCase;
            login();
            excepcionProgramAreaListVacio();
            page.focus("#root");
            Assertions.assertTrue(page.isVisible("text=Add at least one employee area"));
            System.out.println("El caso de prueba CA065 se ejecuto "+contador+" veces");
        }
    }
}
