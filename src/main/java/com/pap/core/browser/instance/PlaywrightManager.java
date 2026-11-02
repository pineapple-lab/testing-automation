package com.pap.core.browser.instance;
import com.microsoft.playwright.*;
import com.pap.core.config.ConfigReader;
import com.pap.core.browser.factory.BrowserFactory;
import com.pap.core.browser.factory.BrowserType;
public class PlaywrightManager {
    private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();

    public static void initBrowser(){
        String browserTypeStr = ConfigReader.getProperty("browser");
        if(browserTypeStr == null){
            browserTypeStr = "CHROMIUM";
        }
        BrowserType type = BrowserType.valueOf(browserTypeStr.toUpperCase());

        Playwright playwright = Playwright.create();
        PLAYWRIGHT_THREAD_LOCAL.set(playwright);

        Browser browser = BrowserFactory.getBrowser(playwright, type);
        BROWSER_THREAD_LOCAL.set(browser);

        BrowserContext context = browser.newContext();
        CONTEXT_THREAD_LOCAL.set(context);

        Page page = context.newPage();
        PAGE_THREAD_LOCAL.set(page);
    }

    public static Page getPage(){
        return PAGE_THREAD_LOCAL.get();
    }
    public static void quit() {
        if (PAGE_THREAD_LOCAL.get() != null) {
            PAGE_THREAD_LOCAL.get().close();
            PAGE_THREAD_LOCAL.remove();
        }
        if (CONTEXT_THREAD_LOCAL.get() != null) {
            CONTEXT_THREAD_LOCAL.get().close();
            CONTEXT_THREAD_LOCAL.remove();
        }
        if (BROWSER_THREAD_LOCAL.get() != null) {
            BROWSER_THREAD_LOCAL.get().close();
            BROWSER_THREAD_LOCAL.remove();
        }
        if (PLAYWRIGHT_THREAD_LOCAL.get() != null) {
            PLAYWRIGHT_THREAD_LOCAL.get().close();
            PLAYWRIGHT_THREAD_LOCAL.remove();
        }
    }
}
