package practice_session_automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class FormsAndInputs {



    static Page page;
    static String FORMS_CARDS = "Forms & Inputs";
    static String ALERTS_CARDS = "Alerts & Dialogs";
    static String TABLES_CARDS = "Tables & Pagination";
    static String ECOM_CARDS = "2. E-commerce Checkout";



    public static void main(String[] args) {
        getPage().navigate("https://unrivaled-chaja-1d0f13.netlify.app/");
        clickLaunchChallenge(ECOM_CARDS);

    }

//    public static fillUpForm(){
//
//    }
    public static Page getPage(){
        if(page !=null){
            return page;
        }
        else {
            page = initializePlaywright();
        }
        return page;
    }

    public static Page initializePlaywright(){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        return browserContext.newPage();
    }


    public static void clickLaunchChallenge(String cardName){
        Locator cards = getPage().locator(".card");
        Locator card = cards.filter(new Locator.FilterOptions().setHasText(cardName));

        Locator launchChallenge = card.getByRole(AriaRole.LINK);
        launchChallenge.click();

        //getPage().locator("#challenge-inputs").getByRole(AriaRole.LINK,new Locator.GetByRoleOptions().setName("Launch Challenge"));
    }


}
