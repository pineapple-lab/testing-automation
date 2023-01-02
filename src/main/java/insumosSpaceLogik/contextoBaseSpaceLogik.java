package insumosSpaceLogik;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class contextoBaseSpaceLogik extends variablesIniciadasSpaceLogik {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    @BeforeAll
    static void launchBrowser() {
        System.out.println("Iniciando contexto...");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1050));
    }

    @BeforeEach
    public void createContextAndPage() {
        System.out.println("Iniciando navegador...");
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1280, 768);
    }

    @AfterEach
    void closeContext() {
        System.out.println("Cerrando navegador...");
        context.close();
    }
    @AfterAll
    static void closeBrowser() {
        System.out.println("Cerrando contexto...");
        playwright.close();
    }
}

