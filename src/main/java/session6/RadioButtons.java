package session6;

import com.microsoft.playwright.*;

public class RadioButtons {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();



//        page.navigate("https://practice-automation.com/form-fields/");
//
//        Locator redRadioButton = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Red"));
//        redRadioButton.setChecked(true);
//        Locator blueRadioButton = page.getByLabel("Blue").nth(1);
//        blueRadioButton.setChecked(true);
        page.navigate("https://yatra.com/");
        Locator roundTrip = page.getByLabel("Round Trip").first();
        roundTrip.check();



    }
}
