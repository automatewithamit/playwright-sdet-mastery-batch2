package session10;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class IFrameDemo {


    //How Selenium handles iFrame
    //1. identify iFrame using any locator
    //2. Switch to the iFrame using swithTo method in selenium
    //3. Identify the element you want some action on
    //4. Perform action on element
    //5. Switch Context back to default content

    //How Playwright handles iFrame
    //1. identify iFrame using any locator
    //2. Identify the element you want some action on
    //3. Perform action on element
//    page.frameLocator("#payment-frame")
//            .locator("#cardNumber")
//    .fill("4111111111111111");

    static Page page =null;


    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        page = context.newPage();
        clickDownloadButtonInIFrame();

    }
    public static void clickDownloadButtonInIFrame(){
        page.navigate("https://practice-automation.com/iframes/");

        Frame frameLocator = page.frameByUrl("https://www.selenium.dev/");
        Locator downloadButtonInsideIframe = frameLocator.getByRole(AriaRole.LINK, new Frame.GetByRoleOptions().setName("Downloads"));
        downloadButtonInsideIframe.click();
        Locator homeButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
        homeButton.click();
    }
    public static void enterTextInIFrame(){
        page.navigate("https://demo.automationtesting.in/Frames.html");

        FrameLocator frameLocator = page.frameLocator("#singleframe");
        Locator textBoxInsideIFrame = frameLocator.getByRole(AriaRole.TEXTBOX);

        textBoxInsideIFrame.fill("This is a Text box");
        Locator iFrameInsideIFrameButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Iframe with in an Iframe"));
        iFrameInsideIFrameButton.click();
    }



}
