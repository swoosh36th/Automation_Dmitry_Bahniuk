package task_13;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPagePF;
import pageObjects.baseObjects.BaseTest;

public class pageFactoryTest extends BaseTest {
    LoginPagePF loginPagePF;

    @BeforeClass
    public void precondition(){
        loginPagePF = new LoginPagePF();
    }

    @Parameters({"url", "blocked_user", "password"})
    @Test
    public void pageFactory(String url, String blocked_user, String password){
        loginPagePF
                .open(url)
                .enterUserName(blocked_user)
                .enterPassword(password)
                .clickLoginBtn()
                .verifyBlockedUser();
    }
}
