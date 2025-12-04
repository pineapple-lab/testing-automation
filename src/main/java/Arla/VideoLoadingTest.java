package Arla;
import InsumosArla.SelectorsArla;
import InsumosArla.TestCaseArla;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VideoLoadingTest extends TestCaseArla {
    String[] usersList = {
            "franstudent", "franstudentrp", "test1-arla", "test2-arla", "test3-arla", "test4-arla", "test5-arla", "test6-arla", "test7-arla", "test8-arla",
            "test9-arla", "test10-arla", "test11-arla", "test12-arla", "test13-arla", "test14-arla", "test15-arla", "test16-arla", "test17-arla", "test18-arla",
            "test19-arla", "test20-arla", "test21-arla", "test22-arla", "test23-arla", "test24-arla", "test25-arla", "test26-arla", "test27-arla", "test28-arla",
            "test29-arla", "test30-arla", "test31-arla", "test32-arla", "test33-arla", "test35-arla", "test36-arla", "test37-arla", "test38-arla", "test39-arla",
            "test40-arla", "test41-arla", "test42-arla", "test43-arla", "test44-arla", "test45-arla", "test46-arla", "test47-arla", "test48-arla", "test49-arla",
            "test50-arla"
    };
    int executionDetails = 15;
    int executionCounter;
    @Test
    public void TestVideoLoading50users() {
        ExecutorService executor = Executors.newFixedThreadPool(15);
        List<Future<?>> futures = new ArrayList<>();
        for (executionCounter = 0; executionCounter < executionDetails; executionCounter++) {
            final int userIndex = executionCounter % usersList.length;
            Future<?> future = executor.submit(() -> {
                try (Playwright playwright = Playwright.create()) {
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                    BrowserContext context = browser.newContext();
                    Page page = context.newPage();
                    String username = usersList[userIndex];
                    System.out.println("Usuario: " + username);
                    page.navigate("https://arla-cms-dev.web.app/login");
                    page.waitForSelector(SelectorsArla.LOGIN_USERNAME_INPUT);
                    page.fill(SelectorsArla.LOGIN_USERNAME_INPUT, username);
                    page.waitForSelector(SelectorsArla.LOGIN_PASSWORD_INPUT);
                    page.fill(SelectorsArla.LOGIN_PASSWORD_INPUT, "123123aA.");
                    page.click(SelectorsArla.LOGIN_BUTTON);
                    page.waitForSelector(SelectorsArla.COURSE_MENU_BUTTON);
                    page.navigate("https://arla-cms-dev.web.app/my-courses/chapter-view/901421/101696");
                    page.waitForSelector(SelectorsArla.PLAY_VIDEO_BUTTON);
                    page.click(SelectorsArla.PLAY_VIDEO_BUTTON);
                    page.waitForTimeout(5000);
                    browser.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            futures.add(future);
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}