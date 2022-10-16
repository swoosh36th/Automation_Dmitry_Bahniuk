package lecture11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class loginTest extends BaseTest {
    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password){
        get(LoginPage.class)
                .open()
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
}
