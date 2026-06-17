package session9;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadDemo {
    static Page page =null;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        page = context.newPage();
        //Path filePath = Paths.get("/Users/amittripathi/Downloads/Copy of white (1).png");
        downloadFile();


    }
    public static void downloadAssignmentFile(){//
        page.navigate("https://testautomationpractice.blogspot.com/");
        //write a method to download and save the file




    }

    public static void downloadFile(){
        page.navigate("https://demo.automationtesting.in/FileDownload.html");
        //If we want to increase download timeout
        Page.WaitForDownloadOptions option = new Page.WaitForDownloadOptions().setTimeout(600000);

        Download download = page.waitForDownload(option,() -> {
            // Perform the action that initiates download
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Download")).click();
        });

        String fileName = download.suggestedFilename();
        download.saveAs(Paths.get("/Users/amittripathi/Documents/" + fileName));




    }
}
