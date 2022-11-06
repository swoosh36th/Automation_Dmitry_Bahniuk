package task_7;

import org.testng.annotations.BeforeClass;
import pageObjects.baseObjects.BaseTest;
import org.testng.annotations.Test;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Task_7 extends BaseTest {
    LoginPage loginPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        basketPage = new BasketPage();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void loginTest1() {
        loginPage
                .open()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage
                .verifyPageTitle();
    }

    @Test
    public void loginTest2() {
        loginPage
                .open()
                .enterUserName("problem_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }

    @Test
    public void loginTest3() {
        loginPage
                .open()
                .enterUserName("performance_glitch_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }

    @Test
    public void loginTest4() {
        loginPage
                .open()
                .enterUserName("locked_out_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .verifyBlockedUser();
    }

    @Test
    public void itemInCartTest() {
        loginPage
                .open()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .verifyBackPackInCart();
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .open()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .verifyBackPackInCart();
        basketPage
                .clickRemoveFromCartBtn();
        basketPage
                .verifyNoItemsInCart();
    }

    @Test
    public void paymentTest() {
        loginPage
                .open()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        checkoutPage
                .enterFirstName("Dmitry")
                .enterLastName("Ivanov")
                .enterZipCode("220000")
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }
}
