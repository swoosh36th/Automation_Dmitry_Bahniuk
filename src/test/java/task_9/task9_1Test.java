package task_9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class task9_1Test extends BaseTest {
    @Parameters("url")
    @BeforeMethod
    public void precondition(String url) {
        new LoginPage()
                .open(url);
    }

    @Test(priority = 1)
    public void loginTest1() {
        new LoginPage()
                .enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 2, dataProvider = "login data")
    public void loginTest2(String username, String password) {
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginBtn()
                .verifyWrongData();
    }

    @DataProvider(name = "login data")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "1234567"},
                {"user", "secret_sauce"},
                {"user_wrong", "password_wrong"}
        };
    }
}
