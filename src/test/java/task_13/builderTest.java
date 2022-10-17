package task_13;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.entity.CheckOutBuilder;
import pageObjects.saucedemo.entity.LoginBuilder;

public class builderTest {
    LoginPage loginPage;
    ProductPage productPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        basketPage = new BasketPage();
        checkoutPage = new CheckoutPage();
    }

    @Parameters({"url", "standard_user", "password", "firstname", "lastname", "zipcode"})
    @Test
    public void builder(String url, String standard_user, String password, String firstname, String lastname, String zipcode) {
        loginPage
                .open(url);
        LoginBuilder login = new LoginBuilder.Builder()
                .withUserName(standard_user)
                .withPassword(password)
                .build();
        loginPage
                .standardEnterData(login);
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        CheckOutBuilder checkOut = new CheckOutBuilder.Builder()
                .withFirstName(firstname)
                .withLastName(lastname)
                .withZipCode(zipcode)
                .build();
        checkoutPage
                .enterData(checkOut)
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }
}
