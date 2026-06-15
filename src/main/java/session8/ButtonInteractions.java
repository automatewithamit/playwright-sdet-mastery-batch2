package session8;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;

public class ButtonInteractions {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        page.navigate("https://practice-automation.com/");
        getButtonNames(page);

    }
    public static void getButtonNames(Page page){
        List<String> linkNames = new ArrayList<>();
        Locator links = page.locator(".wp-element-button");
        System.out.println("Total Buttons : "+ links.count());
       for (int i = 0; i < links.count();   i++) {
            String buttonName = links.nth(i).innerText();
            System.out.println(buttonName);
        }
    }
}
