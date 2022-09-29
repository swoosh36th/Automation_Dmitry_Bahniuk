package task_9;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class task9_2Test extends BaseTest {
    @Parameters("url")
    @BeforeClass()
    public void precondition(String url) {
        new LoginPage()
                .open(url)
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
    }

    @Test(invocationCount = 3, priority = 1)
    public void addItemToCartTest() {
        new ProductPage()
                .addTopItemToCart();
    }

    @Test(dependsOnMethods = "addItemToCartTest", priority = 2)
    public void deleteItemsFromCartTest() {
        new BasketPage()
                .verifyThreeItemsInCart();
        new BasketPage()
                .deleteThreeItemsFromCart();
        new BasketPage()
                .verifyNoItemsInCart();
    }
}
