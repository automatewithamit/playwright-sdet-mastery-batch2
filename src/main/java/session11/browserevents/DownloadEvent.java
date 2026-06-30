package session11.browserevents;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadEvent {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://demo.automationtesting.in/FileDownload.html");

        Download download = page.waitForDownload(()->{
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Download")).click();
                }
        );
        String homeDir = System.getProperty("user.home");
        Path downloadPath = Paths.get(homeDir,"Download",download.suggestedFilename());
        download.saveAs(downloadPath);




    }
}
