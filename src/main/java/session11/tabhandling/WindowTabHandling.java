package session11.tabhandling;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class WindowTabHandling {
    //Set<String> windows = driver.getWindowHandles();

        //driver.switchTo().window(windowId);
//        Page popup = page.waitForPopup(() -> {
//            page.locator("#open").click();
//        });
        static BrowserContext context;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));
        context = browser.newContext();
        Page page = context.newPage();
        handleNewWindow_scenario4(page);
        //handleNewWindow_scenario3(page);
        //handleNewTab_scenario2(page);
        //handleNewTab(page);

    }
    public static void handleNewWindow_scenario4(Page page){
        page.navigate("https://demo.automationtesting.in/Windows.html");
        context.onPage(newPage -> {
            System.out.println("New Page Opened with URL : "+ newPage.url());
        });
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Open New Seperate Windows")).click();
        Page seleniumWindow = page.waitForPopup(() -> {

            page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName( "click")).click();

        });
        seleniumWindow.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Downloads")).click();
        System.out.println(seleniumWindow.title());
        page.bringToFront();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Open New Tabbed Windows")).click();
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName( "click")).click();
        System.out.println(page.title());
        System.out.println("No. of Pages Opened : "+context.pages().stream().count());


    }

    public static void handleNewWindow_scenario3(Page page){
        page.navigate("https://demo.automationtesting.in/Windows.html");
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Open New Seperate Windows")).click();
        Page seleniumWindow = page.waitForPopup(() -> {

            page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName( "click")).click();

        });
        seleniumWindow.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Downloads")).click();
        System.out.println(seleniumWindow.title());
        page.bringToFront();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Open New Tabbed Windows")).click();
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName( "click")).click();
        System.out.println(page.title());
        System.out.println("No. of Pages Opened : "+context.pages().stream().count());


    }
    public static void handleNewTab_scenario2(Page page){
        page.navigate("https://demo.automationtesting.in/Windows.html");
        Page finalPage = page;
        Page seleniumPage = page.waitForPopup(() -> {
            finalPage.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("click")).click();
        });
        seleniumPage.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Downloads")).click();
        System.out.println(seleniumPage.title());
        page.bringToFront();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Open New Seperate Windows")).click();


        page.close();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName( "Documentation")).click();
        System.out.println(page.title());

    }

    public static void handleNewTab(Page page){
        page.navigate("https://the-internet.herokuapp.com/windows");

        Page newPage = page.waitForPopup(() -> {

            page.getByText("Click Here").click();
        });

        newPage.waitForLoadState();

        System.out.println(newPage.title());

        String heading = newPage.locator("h3").textContent();

        System.out.println(heading);
        //newPage.close();
    }
}
