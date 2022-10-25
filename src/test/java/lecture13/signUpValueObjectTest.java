package lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUp;
import pageObjects.moodpanda.entity.SignUpBuilder;

public class signUpValueObjectTest extends BaseTest {
    @Parameters({"url", "email", "password"})
    @Test
    public void loginTest(String url, String email, String password) {
        new HomePage()
                .open(url);
        new NavigationPage()
                .clickSignUpBtn();

        SignUp signUp = new SignUp(){{
            setEmail(email);
            setCheckbox(true);
            setFirstName("First");
            setLastName("Last");
            setPassword(password);

        }};

        new SignUpPage()
                .enterData(signUp);
    }
    @Test
    public void loginTestBuilder(String url, String email, String password) {
        new HomePage()
                .open(url);
        new NavigationPage()
                .clickSignUpBtn();

        SignUpBuilder signUp = new SignUpBuilder.Builder()
                .withEmail(email)
                .withFirstName("First name")
                .withLastName("S")
                .withCheckbox(false)
                .build();

        new SignUpPage()
                .enterData(signUp);
    }
}
