package session9;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadDemo {
    static Page page =null;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        page = context.newPage();
        Path filePath = Paths.get("/Users/amittripathi/Downloads/Copy of white (1).png");

        uploadFile(filePath);

    }

    public static void uploadAssignmentFile(){//Assignment
        page.navigate("https://qa-automation-practice.netlify.app/file-upload.html");
        //write code to upload a file

    }



    public static void uploadFile(Path filepath){
        page.navigate("https://practice.expandtesting.com/upload");
        Locator fileUpload = page.getByTestId("file-input");

        fileUpload.setInputFiles(filepath);

    }
}
