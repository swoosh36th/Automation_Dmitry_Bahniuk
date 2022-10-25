package lecture13;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.LoginPage;

public class loginComponentTest extends BaseTest {

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
