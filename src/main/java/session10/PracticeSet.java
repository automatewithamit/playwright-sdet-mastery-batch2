package session10;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class PracticeSet {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time
        Browser driver =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = driver.newContext();


        Page page = context.newPage();
        page.navigate("https://unrivaled-chaja-1d0f13.netlify.app");

        navigateTo(page,"Frames & Windows");
    }

    public static void navigateTo(Page page,String name){
        Locator launch = page.locator("#challenge-dynamic").getByRole(AriaRole.LINK,new Locator.GetByRoleOptions().setName(name));
        launch.click();
    }
}
