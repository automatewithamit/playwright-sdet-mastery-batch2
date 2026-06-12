package session6;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckBoxes {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();
        page.navigate("https://practice-automation.com/form-fields/");



        Locator waterCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Water"));
        waterCheckBox.check();
        waterCheckBox.check();
        waterCheckBox.uncheck();

        waterCheckBox.check();


        page.navigate("https://playwright.dev/docs/input");
        Locator gettingStarted = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Getting Started"));

        gettingStarted.click();

        Locator playwrightTest = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Playwright Test"));
        playwrightTest.click();
        if(playwrightTest.getAttribute("aria-expanded").equals("false")){
            System.out.println("The section is collapsed. Expanding it now...");
            playwrightTest.click();
        } else {
            System.out.println("The section is already expanded.");
        }



    }



}
