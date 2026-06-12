package session7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class AJAXLoad {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");

        Locator ajaxButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Load AJAX Content"));
        ajaxButton.click();
        Locator ajaxContent = page.locator("#ajaxContent p");

        ajaxContent.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));

        page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(10000));

        String content = ajaxContent.innerText(new Locator.InnerTextOptions().setTimeout(5000));
        System.out.println(content);
        System.out.println("End");

    }
}
