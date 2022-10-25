package task_13;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.CheckoutPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import pageObjects.saucedemo.entity.CheckOut;
import pageObjects.saucedemo.entity.Login;

public class valueObjectTest extends BaseTest {
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
    public void valueObject(String url, String standard_user, String password, String firstname, String lastname, String zipcode) {
        loginPage
                .open(url);
        Login login = new Login() {{
            setUsername(standard_user);
            setPassword(password);
        }};
        loginPage
                .standardEnterData(login);
        productPage
                .clickAddToCartBackPack()
                .clickToCart();
        basketPage
                .clickCheckoutButton();
        CheckOut checkOut = new CheckOut() {{
            setFirstName(firstname);
            setLastName(lastname);
            setZipCode(zipcode);
        }};
        checkoutPage
                .enterData(checkOut)
                .clickContinueBtn()
                .clickFinishBtn()
                .verifyCheckout();
    }
}
