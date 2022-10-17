package lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class loginComponentTest extends BaseTest {

    @Parameters({"url", "email", "password"})
    @Test
    public void loginTest(String url, String email, String password) {
        new HomePage()
                .open(url)
                .clickGetStarted();
        new LoginPage()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginBtn()
                .verifyErrorMessage("Your email or password is wrong");
    }
}
