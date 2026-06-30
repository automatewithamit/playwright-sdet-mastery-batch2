package practiceset;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Practice {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time
Browser driver =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = driver.newContext();


        Page page = context.newPage();
        page.navigate("https://unrivaled-chaja-1d0f13.netlify.app");
        Locator dynamicActionLaunch = page.locator("#challenge-dynamic").getByRole(AriaRole.LINK,new Locator.GetByRoleOptions().setName("Launch Challenge"));
        dynamicActionLaunch.click();
        Locator startLoadingAction = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start Loading Action"));

        startLoadingAction.click();
        Locator asyncOutput = page.locator("#async-output");
        String outputText = asyncOutput.innerText();
        System.out.println(outputText);
        page.close();
        context.close();
        playwright.close();

    }
}
