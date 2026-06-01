package session3;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;

public class LaunchPersistentContextOptionsConcept {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        java.nio.file.Path userDataDir = Paths.get("user-profile-data");
        BrowserContext context = playwright.chromium()
                                            .launchPersistentContext(userDataDir, new BrowserType.LaunchPersistentContextOptions()
                                            .setHeadless(false)
                                            .setSlowMo(500)
                                            .setChannel("chrome")
                                            .setArgs(Arrays.asList("--start-maximized", "--disable-notifications"))
                                            .setTimeout(30000));


        Page page =  context.newPage();
        page.navigate("https://www.yatra.com");


    }

}
