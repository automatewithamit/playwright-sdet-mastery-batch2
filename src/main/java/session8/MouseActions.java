package session8;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

import java.awt.*;

public class MouseActions {
        public static void main(String[] args) {
            Playwright playwright = Playwright.create(); //one Time

            Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context = browser.newContext();

            Page page = context.newPage();
//            performdragToA(page);
//
//            page.waitForTimeout(2000);
//            performdragToB(page);
            performMouseMove(page);
            //performMouseHover(page);

            //performRightClick(page); // Right-click on the first image
            //performDoubleClick(page); // Double-click on the button



             // Move mouse to specific coordinates


        }
    public static void performMouseMove(Page page){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println("Width : " + width);
        System.out.println("Height : " + height);
        page.mouse().move(1000, 100,new Mouse.MoveOptions().setSteps(10));
        page.mouse().click(1000, 100);

    }
        public static void performdragToB(Page page) {
            //page.navigate("https://the-internet.herokuapp.com/drag_and_drop");
            //Drag the element from source to target
            Locator source = page.locator("#column-a");
            Locator target = page.locator("#column-b");
            // Example of performing drag and drop
            source.dragTo(target);
        }
    public static void performdragToA(Page page) {
        page.navigate("https://the-internet.herokuapp.com/drag_and_drop");
        //Drag the element from source to target
        Locator source = page.locator("#column-a");
        Locator target = page.locator("#column-b");
        // Example of performing drag and drop
        target.dragTo(source);
    }
        public static void performDoubleClick(Page page) {
            page.navigate("https://the-internet.herokuapp.com/double_click");
            //Double-click on the button to trigger the event
            Locator element = page.locator("#double-click");
            // Example of performing double-click
            element.dblclick(new Locator.DblclickOptions().setButton(MouseButton.LEFT));
        }
        public static void performRightClick(Page page) {
            page.navigate("https://the-internet.herokuapp.com/context_menu");
            //Right-click on the box to trigger the context menu
            Locator element = page.locator("#hot-spot");
            // Example of performing right-click
            element.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
        }
        public static void performMouseHover(Page page) {
            page.navigate("https://the-internet.herokuapp.com/hovers");

            //Hover over the first image
            Locator firstImage = page.locator(".figure").nth(0);
            firstImage.hover();
            // Example of performing mouse hover
            //Click on the "View profile" link that appears after hovering
            firstImage.hover();
            firstImage.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("View profile")).click();
        }

}
