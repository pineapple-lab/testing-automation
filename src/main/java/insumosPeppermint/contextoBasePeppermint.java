package insumosPeppermint;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class contextoBasePeppermint extends variablesIniciadasPeppermint {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(0.1).setChannel("chrome"));//

    }
    @BeforeEach
    public void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1366, 768);
    }
    @AfterEach
    public void closeContext(){ context.close(); }
    @AfterAll
    public static void closeBrowser(){ playwright.close();
    }
}
