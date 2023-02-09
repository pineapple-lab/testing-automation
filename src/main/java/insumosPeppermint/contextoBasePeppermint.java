package insumosPeppermint;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class contextoBasePeppermint extends variablesIniciadasPeppermint {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1).setChannel("chrome"));//


    }
    @BeforeEach
    public void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1366, 768);

    }
    @AfterEach
    void closeContext(){ context.close(); }
    @AfterAll
    static void closeBrowser(){ playwright.close();
    }
}
