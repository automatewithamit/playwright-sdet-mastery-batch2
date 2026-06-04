package session4;

import com.microsoft.playwright.*;

import java.util.logging.Logger;

public class LocatorsDemo {
    public static void main(String[] args) {

        // 1. CSS Selector
        // 2. XPath
        // 3. Text Selector
        // 4. Role Selector
        // 5. Test ID Selector
        // 6. Data Attribute Selector
        // 7. Label Selector
        // 8. Placeholder Selector
        // 9. Alt Text Selector
        // 10. Title Selector

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser
                .NewContextOptions()
                .setViewportSize(1280, 720));
        context.setDefaultTimeout(10000);

        Page page =  context.newPage();
        page.navigate("https://www.yatra.com");

        Locator loginButton = page.locator("//div[text()='Login / Signup']");




        // WebElement loginButton = driver.findElement(By.XPath("//div[text()='Login / Signup']"));
//        try {
            //click(loginButton);

            loginButton.click();
            //Three Things Click does:
            // 1. Wait for the element to be visible and enabled (clickable)
            // 2. Scroll the element into view if it's not already visible
            // 3. Perform the click action
            //waits for maximum 30 seconds for the element to be visible and enabled (clickable)
            // before performing the click action. If the element is not clickable within the timeout period,
            // it will throw a TimeoutException.

            loginButton.dblclick();
//        }catch (StaleElementReferenceException e){
//            // Handle the exception, maybe by re-locating the element
//            loginButton = page.locator("//div[text()='Login / Signup']");
//            loginButton.click();
//        }
        int count = 4;

        System.out.println("Number of login options: " );
    }

//    public static void click(Locator locator){
//        try {
//            Logger.getGlobal().info("Attempting to click the locator: " + locator);
//            locator.click();
//        }catch (StaleElementReferenceException e){
//            // Handle the exception, maybe by re-locating the element
//            locator.click();
//        }

    }


