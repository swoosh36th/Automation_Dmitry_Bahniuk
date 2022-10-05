package lecture8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class lecture8_1 extends BaseTest{
    @Test
    public void login(){
        //Время ожидания можно переопределять и в самих тестах, если это вдруг потребуется(не явное ожидание)
        //getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
        new LoginPage()
                .open()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
        new ProductPage()
                .verifyPageTitle();
    }
}
