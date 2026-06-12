package session7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class SelectDropdowns {


    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();
        page.navigate("https://practice.expandtesting.com/dropdown");
        //Select by value
        Locator selectDrowpdown = page.locator("#dropdown");
        //selectDrowpdown.selectOption("2");
        //selectDrowpdown.selectOption("Option 1");
        //selectDrowpdown.selectOption(new SelectOption().setLabel("Option 2"));
        selectDrowpdown.selectOption(new SelectOption().setIndex(1));

    }
}
