package com.teoria;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Descargas extends ScriptBase{

    @Test
    public void downloadTestWithHandler(){
        page.navigate(home);

        page.onDownload(download -> {
            System.out.println(download.path());
            download.saveAs(Paths.get(new File("C:\\Users\\PineappleHP3\\Desktop\\dev\\downloaded.zip").toURI()));

        });

        page.click("text=Download ZIP");

    }

    @Test
    public void downloadTestWithWaitForEvent(){
        page.navigate(home);

        Download download = page.waitForDownload(() -> {
           page.click("text=Download ZIP");
        });

        Path path = download.path();
        System.out.println(path);
    }

    @BeforeEach
    @Override
    protected void createContextAndPage(){
        browser = playwright.chromium().launch();
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));

        page = context.newPage();
        page.setViewportSize(1920, 2000);
    }
    @Test
    public void downloadHeadTest(){
        page.navigate(home);
        Download download = page.waitForDownload(
                ()-> page.click("text=Download")
        );

        System.out.println(download.path());
        download.saveAs(Paths.get(new File("C:\\Users\\PineappleHP3\\Desktop\\dev\\downloaded.zip").toURI()));

    }
}
