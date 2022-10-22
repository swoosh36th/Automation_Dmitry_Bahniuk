package lecture13;

import org.testng.annotations.Test;
import pageFactory.moodpanda.HomePage;
import pageFactory.moodpanda.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class loginPageFactoryTest extends BaseTest {

    @Test
    public void loginTest() {
        new HomePage()
                .open()
                .clickGetStarted();
        new LoginPage()
                .enterEmail(properties.getProperty("email"))
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyErrorMessage("Your email or password is wrong");
    }
}
