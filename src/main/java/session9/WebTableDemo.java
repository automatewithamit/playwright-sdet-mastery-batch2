package session9;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class WebTableDemo {

    static Page page =null;


    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); //one Time

        Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext();

        page = context.newPage();

//        checkRowByCompanyName("Selenium");
//        getPriceOfBook("Master In Selenium");
        clickEditButton("alden@example.com");
    }

    public static void getRoles(){//assignment
        page.navigate("https://vinothqaacademy.com/webtable/");

        //Get all the Role Names from Table Project Details
    }

    public static void clickEditButton(String email){

        page.navigate("https://www.tutorialspoint.com/selenium/practice/webtables.php");

        Locator row = page.getByRole(AriaRole.ROW);
        System.out.println("Row Count : " + row.count());
        Locator emailRow = row.filter(new Locator.FilterOptions().setHasText(email));
        System.out.println("Row Count : " + emailRow.count());
        Locator priceCell = emailRow.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("delete"));
        System.out.println("Cells Count : " + priceCell.count());
        priceCell.last().click();

        System.out.println("email edit "+ email + "Clicked" );
    }

    public static void getPriceOfBook(String bookName){

        page.navigate("https://testautomationpractice.blogspot.com/");

        Locator row = page.getByRole(AriaRole.ROW);
        System.out.println("Row Count : " + row.count());
        Locator bookRow = row.filter(new Locator.FilterOptions().setHasText(bookName));
        System.out.println("Company Row Count : " + bookRow.count());
        Locator priceCell = bookRow.getByRole(AriaRole.CELL).nth(3);
        System.out.println("Cells Count : " + priceCell.count());

        System.out.println("Price of Book "+bookName + " is "+priceCell.innerText() );
    }


    public static void checkRowByCompanyName(String company){

        page.navigate("https://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
//        Locator checkbox = page.getByRole(AriaRole.ROW)
//                                .filter(new Locator.FilterOptions().setHasText(company))
//                                .getByRole(AriaRole.CHECKBOX);

        Locator row = page.locator("//tr");
        //Locator row = page.getByRole(AriaRole.ROW);
        System.out.println("Row Count : " + row.count());
        Locator companyRow = row.filter(new Locator.FilterOptions().setHasText(company));
        System.out.println("Company Row Count : " + companyRow.count());
        Locator companyRowCheckbox = companyRow.getByRole(AriaRole.CHECKBOX);
        companyRowCheckbox.click();
        Locator knowMoreLink = companyRow.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Know More"));
        knowMoreLink.click();
    }


}
