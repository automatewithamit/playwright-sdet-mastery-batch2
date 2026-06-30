import com.microsoft.playwright.*;

public class BasePage {
    public Page getPage() {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        return page;
    }
}
