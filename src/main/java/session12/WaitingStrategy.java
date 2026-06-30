package session12;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.util.concurrent.atomic.AtomicBoolean;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class WaitingStrategy {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        Page page = browser.newPage();

        Locator locator = page.locator("#id");

        locator.click(new Locator.ClickOptions().setTimeout(20000));

        locator.fill("", new Locator.FillOptions().setTimeout(3000));

        page.waitForTimeout(5000); //This is like Thread.sleep

        page.waitForLoadState(LoadState.DOMCONTENTLOADED); //default time out is 30 sec
        page.waitForLoadState(LoadState.DOMCONTENTLOADED, new Page.WaitForLoadStateOptions().setTimeout(70000)); //now timeout increased to 70 sec
        page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(70000));
        page.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions().setTimeout(70000));
        page.setDefaultTimeout(160000); //Global Time out Wait  | this is similar to implicit wait in selenium


        //Ajax Request
        //DOM Rendering
        //Animation
        //Loading Spinner
        //Button become Click
        page.waitForDownload(()-> new Page.WaitForDownloadOptions().setTimeout(7000));
        page.waitForPopup(() -> new Page.WaitForPopupOptions().setTimeout(60000));
        AtomicBoolean flag = new AtomicBoolean(false);

        page.waitForCondition(() -> flag.get());

        locator.isVisible(new Locator.IsVisibleOptions().setTimeout(4000));
        assertThat(page).hasTitle("");
        assertThat(page.locator(".spinner")).isHidden();


        //Default Timeout -> 30 sec
        //page.setDefaultTimeout(160000); //Sets bew Global Time out
        //new Locator.FillOptions().setTimeout(3000)
        //Conditional Waits - Popup, Download new Page.WaitForPopupOptions().setTimeout(60000)
        //page.waitForCondition(() -> flag.get()); condition should resolve to (true/false)
    }


}
