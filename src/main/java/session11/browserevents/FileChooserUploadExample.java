package session11.browserevents;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChooserUploadExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

//            // Navigate to a sample file upload page
//            page.navigate("https://the-internet.herokuapp.com/upload");
//
//            // --- Approach 1: Using setInputFiles directly ---
//            // The element with id 'file-upload' is the input tag
           Path filePath = Paths.get("src/test/resources/testfile.txt");
//            page.setInputFiles("#file-upload", filePath);
//            page.click("#file-submit");
//
//            // Verify upload
//            System.out.println("Uploaded with setInputFiles: " + page.locator("h3").textContent());

            // --- Approach 2: Using waitForFileChooser ---
            page.navigate("https://the-internet.herokuapp.com/upload"); // Reset for second approach

            FileChooser fileChooser = page.waitForFileChooser(() -> {
                page.locator("#file-upload").click(); // Clicks to open the native chooser
            });

            fileChooser.setFiles(filePath);
            page.click("#file-submit");

            System.out.println("Uploaded with FileChooser: " + page.locator("h3").textContent());


        }
    }
