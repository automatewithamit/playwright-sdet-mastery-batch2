package practice_session_locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class AutomationExcercise {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            var browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
            var context = browser.newContext();
            var page = context.newPage();
            page.navigate("https://automationexercise.com/products");
               // clickOnProducts(page);
            //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("KIDS").setExact(false)).click();
                clickByProductName(page, "Blue Top");

    }
    public static void clickByProductName(Page page, String productName) {
//        Locator addToCartButton =page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("cart").setExact(false));
//        System.out.println("Cart button Count: " + addToCartButton.count());
//        page.locator("product-image-wrapper",new Page.LocatorOptions().setHasText(productName))
//                .locator(addToCartButton)
//                .click();
//         page.locator(".product-image-wrapper")
//                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("cart").setExact(false))
//                .click();
        //System.out.println("Total products: " + count);
        Locator addToCartBtn = page.locator(".product-image-wrapper")
                .filter(new Locator.FilterOptions().setHasText("Blue Top"))
                .getByText("Add to cart").first();
        addToCartBtn.click();

    }

    public static void clickOnProducts(Page page) {
        //page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("WOMEN").setExact(false)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products").setExact(false)).click();
//        Locator closeButton = page.getByText("Close");
//
//        if(closeButton.isVisible()){
//            closeButton.click();
//        }
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Women").setExact(false)).click();





        // Code for login test
    }
}

