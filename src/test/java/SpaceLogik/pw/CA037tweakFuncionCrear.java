package SpaceLogik.pw;


import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA037tweakFuncionCrear extends robotBaseSpaceLogik {
    @Test
    public void CA0371validacionCrearTweak(){
        System.out.println("Iniciando caso de prueba...");
        Keyboard kb = page.keyboard();
        iniciarVariablesAutoProgramFeliz();
        iniciarVariablesTweakFeliz();
        iniciarVariablesEditRoom();
        System.out.println("El caso CA0371 se va a execute "+execute+" veces");
        for(counter=1;counter<=execute;counter++) {
            nameCase=nameRoomAutoProgram+".37-validacionCrearTweak.Ejecuciones:"+counter;
            selectProgramTweak=nameCase;
            programNameTweak=nameCase;
            System.out.println(nameCase);
            login();
            crearPrograma();
            page.focus(".my-programs-header input");
            kb.insertText(programNameTweak);
            page.waitForSelector("text="+nameCase);
            crearRoom();
            editarRoomOptions();
            crearTweak();
            page.focus("#root");
            assertions = "text=Changes saved successfully";//
            sqlGuardarCasoSiFallaCrearTweak();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0371 se ejecuto "+counter+" veces");
        }
    }
}
