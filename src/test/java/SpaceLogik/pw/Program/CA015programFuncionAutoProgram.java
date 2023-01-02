package SpaceLogik.pw.Program;


import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CA015programFuncionAutoProgram extends robotBaseSpaceLogik {

    @Test
    public void CA0151validacionCrearAutoProgram(){
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesAutoProgramFeliz();
        System.out.println("El caso CA0151 se va a ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase=nameRoomAutoProgram+".32-validacionCrearAutoProgram.Ejecuciones:"+contador;
            login();
            crearAutoProgram();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaCrearAutoProgram();
            assertTrue(page.isVisible(assertions));
            page.focus("#root");
            assertions = "text="+nameCase;
            sqlGuardarCasoSiFallaCrearAutoProgram();
            assertTrue(page.isVisible(assertions));
            page.click(".app-sidebar__inner > div > ul > li:nth-of-type(3)");
            page.click("text=Programs");
            page.focus("#root");
            sqlGuardarCasoSiFallaCrearAutoProgram();
            assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0151 se ejecuto " +contador+" veces");
        }
    }
}
