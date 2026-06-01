package session2;

import com.microsoft.playwright.*;

public class PlaywrightConcepts {


    public static void main(String[] args) {


        Playwright playwright = Playwright.create(); //one Time

        //Browser browser =  playwright.chromium().launch();
        //headless mode is by default true, to run in headed mode we need to set headless to false
        Browser driver =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //equivalent to below line
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new ChromeDriver();
        BrowserContext context1 = driver.newContext();


        Page page1 = context1.newPage();

        page1.navigate("https://www.google.com");
        Locator searchBox= page1.locator("[aria-label='Search']");
        searchBox.fill("Playwright");
        searchBox.press("Enter");


        BrowserContext context2 = driver.newContext();

        Page page2 = context2.newPage();
        page2.navigate("https://www.yatra.com");


        //context1.close();
        //driver.close();
        //playwright.close();



//
//        driver.navigate().to("https://www.google.com");
//        driver.quit();
    }
}
