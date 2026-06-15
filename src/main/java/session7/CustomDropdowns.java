package session7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class CustomDropdowns {
    public static void main(String[] args) {

        //1. Click on the dropdown to open the options
        //2. Click on the desired option

        Playwright playwright = Playwright.create(); //one Time


        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();


        Page page = context.newPage();
        page.navigate("https://www.yatra.com/");

        selectOptionFromCustomDropdown(page, "Departure From", "Chennai");
        selectOptionFromCustomDropdown(page, "Going To", "Goa");
       // selectTravellers(page, 3, 5, 4);
        // 1. Locate and click the dropdown container to open it
        //Locator dropdown = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Departure From New Delhi inputbox"));
        //Locator dropdown = page.getByText("Departure From");
//        Locator dropdown = page.getByRole(AriaRole.BUTTON,
//                new Page.GetByRoleOptions().setName(Pattern.compile("Select items", Pattern.CASE_INSENSITIVE)));

        //dropdown.click();

        // 2. Locate and click your specific option from the listbox
        //Locator departureFromText = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Departure From"));
        //departureFromText.fill("BLR");
        //Locator departureFrom = page.getByRole(AriaRole.LISTITEM, new Page.GetByRoleOptions().setName("Kempegowda International"));
        //Locator departureFrom = page.locator(".MuiStack-root").filter(new Locator.FilterOptions().setHasText("BLR")).getByText("BLR");

//        Locator option = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Americano").setExact(true));
        //departureFrom.click();

    }

    public static void selectOptionFromCustomDropdown(Page page, String dropdownName,String optionToSelect) {
        //1. Click on the dropdown to open the options
        //2. Click on the desired option

        // 1. Locate and click the dropdown container to open it
        Locator dropdown = page.getByText(dropdownName);
        dropdown.click();

        // 2. Locate and click your specific option from the listbox
//        Locator option = page.getByRole(AriaRole.LISTITEM, new Page.GetByRoleOptions().setName(optionToSelect).setExact(true));
        Locator option = page.locator(".MuiStack-root")
                             .filter(new Locator.FilterOptions().setHasText(optionToSelect))
                             .getByTitle(optionToSelect);
        option.click();
    }

    public static void selectTravellers(Page page, int adults, int children, int infants) {
        //1. Click on the dropdown to open the options
        //2. Click on the desired option

        // 1. Locate and click the dropdown container to open it
        Locator dropdown = page.getByText("Travellers & Class");
        dropdown.click();

        // 2. Locate and click your specific option from the listbox
        //Locator adultOption = page.locator(".MuiBox-root").filter(new Locator.FilterOptions().setHasText("Adult")).getByRole(AriaRole.LISTITEM);

        //adultOption.nth(adults-1).click();


        Locator childrenOption = page.locator(".MuiBox-root").filter(new Locator.FilterOptions().setHasText("Child")).getByRole(AriaRole.LISTITEM);

        childrenOption.nth(children).click();


        Locator infantsOption = page.locator(".MuiBox-root").filter(new Locator.FilterOptions().setHasText("Infant")).getByRole(AriaRole.LISTITEM);

        //infantsOption.nth(infants).click();


    }

}
