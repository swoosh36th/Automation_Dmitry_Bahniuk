package task_9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class task9_3Test extends BaseTest {
    @Parameters("url")
    @BeforeMethod()
    public void preconditions(String url) {
        new LoginPage()
                .open(url)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
    }
    @Test(dataProvider = "item data")
    public void addItemToCartTest(String locatorInProductPage, String locatorInBasketPage, String itemName){
        new ProductPage()
                .addItemToCart(locatorInProductPage)
                .clickToCart();
        new BasketPage()
                .verifyItemInCart(locatorInBasketPage, itemName);
    }

    @DataProvider(name = "item data")
    public Object[][] getData(){
        return new Object[][]{
                {"add-to-cart-sauce-labs-backpack", "item_4_title_link", "Sauce Labs Backpack"},
                {"add-to-cart-sauce-labs-bike-light", "item_0_title_link", "Sauce Labs Bike Light"},
                {"add-to-cart-sauce-labs-bolt-t-shirt", "item_1_title_link", "Sauce Labs Bolt T-Shirt"},
        };
    }
}
