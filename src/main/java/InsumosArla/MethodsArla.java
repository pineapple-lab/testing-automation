package InsumosArla;

import InsumosDocola.SelectorsDocola;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;
import javaslang.match.generator.Generator;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class MethodsArla extends ContextArla{
    GeneratorArla generate = new GeneratorArla();

    public void startContextAndNavigation(){
        startContext();
        startNavigation();
    }

    private void startContext(){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Iniciando ejecucion....");
        System.out.println("-----------------------------------------------------------");
        /*outputStream.println("\n-----------------------------------------------------------");
        outputStream.println("Iniciando ejecucion....");
        outputStream.println("-----------------------------------------------------------");*/
        initializePlaywright();
        setupContextAndPage();
    }
    private void startNavigation(){
        page.navigate(navigationLink);
        System.out.println("Ambiente: "+navigationLink+"\n");
    }
    public void startTest(){

        stopTest = false;
    }
    public void stopTest(){

        stopTest = true;
    }
    public void login(){
        page.navigate(navigationLink);
        page.fill(SelectorsArla.USERNAME_INPUT,username);
        page.fill(SelectorsArla.PASSWORD_INPUT, password);
        page.click(SelectorsArla.LOGIN_BUTTON);
    }
    public void uploadVideo(){
        page.click(SelectorsArla.MEDIA_LIBRARY_MENU);
        page.click(SelectorsArla.MEDIA_LIBRARY_UPLOAD_BUTTON);
        page.locator(SelectorsArla.UPLOAD_VIDEO_INPUT).setInputFiles(Paths.get(generate.generateVideo()));
        page.click(SelectorsArla.UPLOAD_VIDEO_ADD_LENGUAGE);
        page.click(SelectorsArla.UPLOAD_VIDEO_SELECT_LENGUAGE);
        page.click(SelectorsArla.UPLOAD_VIDEO_SAVE_BUTTON);

    }
    public void waitForToast(String expectedMessage) {
        Locator toast = page.locator(SelectorsArla.APP_TOASTERS); // Ajusta el selector según el HTML real

        // Espera indefinidamente hasta que el toast aparezca
        try {
            toast.waitFor(); // Espera hasta que el toast esté presente
            String actualText = toast.innerText().trim(); // Obtiene el texto visible sin espacios extra
            System.out.println(actualText); // Depuración
            Assertions.assertEquals(expectedMessage, actualText, "El mensaje de confirmación no coincide.");
        } catch (TimeoutError e) {
            throw new AssertionError("El mensaje esperado no apareció: " + expectedMessage);
        }
    }
}
