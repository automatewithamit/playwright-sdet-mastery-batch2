package session10;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class IFrameInsideIFrameDemo {
    static Page page =null;


    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        page = context.newPage();
        enterTextInsideNestedIFrame();


    }

    public static void enterTextInsideNestedIFrame(){
        page.navigate("https://demo.automationtesting.in/Frames.html");
        Locator iFrameInsideIFrameButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Iframe with in an Iframe"));
        iFrameInsideIFrameButton.click();
        Frame outerIFrame = page.frameByUrl("https://demo.automationtesting.in/MultipleFrames.html");
        System.out.println("Number of Inner IFrames : "+ outerIFrame.childFrames().stream().count());
        Frame innerFrame = outerIFrame.childFrames().get(0);
        Locator textBoxInsideIFrame = innerFrame.getByRole(AriaRole.TEXTBOX);

        textBoxInsideIFrame.fill("This is a Text box");

        Locator singleIFrameButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Single Iframe"));
        singleIFrameButton.click();

    }

}
