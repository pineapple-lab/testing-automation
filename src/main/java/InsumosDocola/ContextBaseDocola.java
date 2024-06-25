package InsumosDocola;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
/**
 * Clase base para manejar el contexto del navegador utilizando Playwright.
 * Configura el navegador y el contexto de la página antes de cada prueba, y limpia después de cada ejecución.
 */
public class ContextBaseDocola extends VariablesDocola {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    @BeforeAll
    static void initializePlaywright(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(0.1)
                .setChannel("chrome"));
    }
    @BeforeEach
    public void setupContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
        configurePageViewPort(page);
    }
    @AfterEach
    public void cleanupContext(){
        context.close();
        printExecutionEndMessage();
    }
    @AfterAll
    public static void teardownPlaywright(){
        playwright.close();
    }
    /**
     * Configura el tamaño de la ventana de la página.
     * @param page La página a configurar.
     */
    private void configurePageViewPort(Page page){
        page.setViewportSize(1920, 1080);
    }
    private void printExecutionEndMessage(){
        String endMessage = """
            \n-----------------------------------------------------------
            Fin de la ejecucion....
            -----------------------------------------------------------
            """;
        System.out.println(endMessage);
    }
}
