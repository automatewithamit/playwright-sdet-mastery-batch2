package session5;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightLocatorMethods {
    public static void main(String[] args) {
        //Playwright Locator Methods:
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser
                .NewContextOptions()
                .setViewportSize(1280, 720));
        context.setDefaultTimeout(10000);

        Page page =  context.newPage();
        page.navigate("https://www.yatra.com");
        //GetByRole
        Locator loginButton = page.locator("//div[text()='Login / Signup']");
        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search").setExact(true));
        Locator editButton = page.getByRole(AriaRole.ROW)
                                   .getByText("bala kumar")
                                   .getByRole(AriaRole.BUTTON,new Locator.GetByRoleOptions().setName("Edit"));


        //GetByText
        //it resolves all the trailing and preceding white spaces and also normalizes the inner text of the element by replacing multiple consecutive white spaces with a single space.
        page.getByText("Welcome, John", new Page.GetByTextOptions().setExact(true));
        //GetByLabel
        //GetByPlaceholder
        page.getByPlaceholder("Enter Your Email", new Page.GetByPlaceholderOptions().setExact(true));
        //GetByAltText

        //GetByTestId

        //GetByTitle

        //Locator loginButton = page.getByText("Login / Signup");


    }
}
