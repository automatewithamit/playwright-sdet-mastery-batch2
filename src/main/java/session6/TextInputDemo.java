package session6;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class TextInputDemo {
    //1. Identify the WebElement
    //2. Perform the action (click, check, uncheck)


    public static void main(String[] args) {

        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();

        //page.navigate("https://parabank.parasoft.com/parabank/index.htm");
        //page.navigate("https://automationexercise.com/products");
        //1. Identify the WebElement
        //Locator userNameTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username").setExact(false));
        //Locator searchTextBox = page.getByPlaceholder("Search Product");
        //searchTextBox.fill("john", new Locator.FillOptions().setTimeout(5000));

        page.navigate("https://practice-automation.com/form-fields/");

        Locator name = page.getByTestId("name-input");

        name.fill("John Doe");
        name.pressSequentially("This is a test", new Locator.PressSequentiallyOptions().setDelay(100));
        name.press("ControlOrMeta+A");





    }

}
