package session8;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class KeyboardActions {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/key_presses");

        //Type text into the input field
        Locator inputBox = page.getByRole(AriaRole.TEXTBOX);

        inputBox.type("Hello,", new Locator.TypeOptions().setDelay(500)); // Adding delay between keystrokes for better visibility
        inputBox.pressSequentially("New , Playwright!", new Locator.PressSequentiallyOptions().setDelay(100)); // Type the text sequentially with a delay
        //Press Enter key
//        inputBox.press("Enter");
//
//        //Press Tab key to move to the next field
//        inputBox.press("Tab");
       inputBox.press("ArrowUp");
       inputBox.press("ArrowDown");
         inputBox.press("ArrowLeft");
            inputBox.press("ArrowRight");

////        //Type text in the next field
//        inputBox.press("Enter");

        System.out.println(inputBox.inputValue());
        System.out.println("Attribute ID" + inputBox.getAttribute("id"));
//
//        //Press Shift + Tab to go back to the previous field
//        inputBox.press("Shift+Tab");
//
//        //Press Ctrl + A to select all text in the input field
//        inputBox.press("Control+A");
//
//        //Press Ctrl + C to copy the selected text
//        inputBox.press("Control+C");
//
//        //Press Ctrl + V to paste the copied text into the next field
//        inputBox.press("Control+V");

        page.keyboard().press("Control+V", new Keyboard.PressOptions().setDelay(100)); // Adding delay to ensure the paste action is registered



    }
}
