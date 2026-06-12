package practice_session_locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class MobileTestUsingCodeGen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setDeviceScaleFactor(3)
                    .setHasTouch(true)
                    .setIsMobile(true)
                    .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.4 Mobile/15E148 Safari/604.1")
                    .setViewportSize(390, 664));
            Page page = context.newPage();
            page.navigate("https://www.yatra.com/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Support")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flights Flights")).click();
            page.getByText("After Booking").click();
            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Support Center")).click();

        }
    }
}
