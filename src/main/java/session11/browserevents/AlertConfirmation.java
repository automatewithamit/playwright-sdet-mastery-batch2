package session11.browserevents;

import com.microsoft.playwright.*;

public class AlertConfirmation {


    public static void main(String[] args) {

       Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));

        Page page = browser.newPage();

            //page.navigate("https://testpages.eviltester.com/pages/basics/alerts-javascript/");


            //page.locator("text=Show alert box").click();
            clickAlertBox(page);

        }
    public static void clickAlertBox(Page page) {
        page.navigate("https://demoqa.com/alerts");

        page.onDialog(dialog -> {
            if (dialog.message().contains("delete")) {

                dialog.dismiss();
            }
            else if (dialog.type().equals("prompt")){

            }
            else {
            dialog.accept();
            System.out.println("This is Java Script Text " + dialog.message());}
        });
        page.locator("#alertButton").click();
    }

    }

