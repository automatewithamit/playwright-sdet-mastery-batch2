package session3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class ContextOptionsDemo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1280, 720));
        context.setDefaultTimeout(10000); // Set default timeout for all actions in this context

    }
}
