package task_14;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

@Log4j
public class refactoringTask7WithLombok extends BaseTest {

    LoginPage loginPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    ProductPage productPage;

    @BeforeClass
    public void precondition(){
        loginPage = new LoginPage();
        basketPage = new BasketPage();
        checkoutPage = new CheckoutPage();
        productPage = new ProductPage();
    }


    @Test
    public void loginTest1() {
        loginPage
                .open()
                .enterUserName(properties.getProperty("standard_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        productPage
                .verifyPageTitle();
    }

    @Test
    public void loginTest2() {;
        loginPage
                .open()
                .enterUserName(properties.getProperty("blocked_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        productPage.verifyPageTitle();
    }

    @Test
    public void loginTest3() {
        loginPage
                .open()
                .enterUserName(properties.getProperty("problem_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        productPage.verifyPageTitle();
    }

    @Test
    public void loginTest4() {
        loginPage
                .open()
                .enterUserName(properties.getProperty("performance_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyBlockedUser();
    }

    @Test
    public void itemInCartTest() {
        loginPage
                .open()
                .enterUserName(properties.getProperty("standard_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .verifyBackPackInCart();
    }
    @Test
    public void removeItemFromCartTest(){
        loginPage
                .open()
                .enterUserName(properties.getProperty("standard_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
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
    public void paymentTest(){
        loginPage
                .open()
                .enterUserName(properties.getProperty("standard_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn();
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        checkoutPage
                .enterFirstName(properties.getProperty("firstname"))
                .enterLastName(properties.getProperty("lastname"))
                .enterZipCode(properties.getProperty("zipcode"))
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }
}
