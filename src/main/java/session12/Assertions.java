package session12;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class Assertions {

    // If Page is Displayed
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        Page page = browser.newPage();
        //Locator Assertions
        assertThat(page.locator("#message")).hasText("Enter username");
        assertThat(page.locator("#message")).hasAttribute("title","message");
        //page Assertions
        page.navigate("https://yatra.com");
        assertThat(page).hasTitle("Yatra");
        assertThat(page).hasURL("https://www.yatra.com");
        //State Assertions
        assertThat(page.locator("#login")).isDisabled();

        //Negative Assertions
        assertThat(page.locator("#submit")).not().isDisabled();
        //Assertion Timeout

        assertThat(page.locator("#login")).hasText("Submit",new LocatorAssertions.HasTextOptions().setTimeout(60000));


        assertThat(page.locator(".spinner")).isHidden();

        //Auto Retry
        PlaywrightAssertions.setDefaultAssertionTimeout(8000);//

    }

}
