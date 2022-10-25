package task_14;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPagePF;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.entity.CheckOut;
import pageObjects.saucedemo.entity.CheckOutBuilder;
import pageObjects.saucedemo.entity.Login;
import pageObjects.saucedemo.entity.LoginBuilder;

public class refactoringTask13WithLombok extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    LoginPagePF loginPagePF;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        basketPage = new BasketPage();
        checkoutPage = new CheckoutPage();
        loginPagePF = new LoginPagePF();
    }

    @Test(testName = "Value Object Test with Lombok")
    public void valueObjectTest() {
        loginPage
                .open();
        Login login = new Login() {{
            setUsername(properties.getProperty("standard_user"));
            setPassword(properties.getProperty("password"));
        }};
        loginPage
                .standardEnterData(login);
        new ProductPage()
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        CheckOut checkOut = new CheckOut() {{
            setFirstName(properties.getProperty("firstname"));
            setLastName(properties.getProperty("lastname"));
            setZipCode(properties.getProperty("zipcode"));
        }};
        checkoutPage
                .enterData(checkOut)
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }

    @Test(testName = "Page Factory Test with Lombok")
    public void pageFactoryTest() {
        loginPagePF
                .open()
                .enterUserName(properties.getProperty("blocked_user"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyBlockedUser();
    }

    @Test(testName = "Builder Test with Builder from LomBok")
    public void builder_Test() {
        loginPage
                .open();
        LoginBuilder login = new LoginBuilder.LoginBuilder_Lombok()
                .withUsername(properties.getProperty("standard_user"))
                .withPassword(properties.getProperty("password"))
                .create();
        loginPage
                .standardEnterData(login);
        new ProductPage()
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        CheckOutBuilder checkOut = new CheckOutBuilder.CheckOutBuilder_Lombok()
                .withFirstName(properties.getProperty("firstname"))
                .withLastName(properties.getProperty("lastname"))
                .withZipCode(properties.getProperty("zipcode"))
                .create();
        checkoutPage
                .enterData(checkOut)
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }
}
