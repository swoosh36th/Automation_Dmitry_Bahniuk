package task_10;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class task10 extends BaseTest {
    @Parameters("url")
    @BeforeMethod
    public void precondition(@Optional ("https://www.saucedemo.com/") String url){
        new LoginPage()
                .open(url);
    }
    @Test
    public void loginTest1(){
        new LoginPage()
                .enterUserName(System.getProperty("username"))
                .enterPassword(System.getProperty("password"))
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
}
