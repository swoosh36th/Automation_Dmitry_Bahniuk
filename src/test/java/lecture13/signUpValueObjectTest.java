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
    @Parameters()
    @Test
    public void loginTest() {
        new HomePage()
                .open();
        new NavigationPage()
                .clickSignUpBtn();

        SignUp signUp = new SignUp(){{
            setFirstName("First");
            setLastName("Last");
            setEmail(properties.getProperty("email"));
            setPassword(properties.getProperty("password"));
            setCheckbox(true);

        }};

        new SignUpPage()
                .enterData(signUp);
    }
    @Test
    public void loginTestBuilder() {
        new HomePage()
                .open();
        new NavigationPage()
                .clickSignUpBtn();

        SignUpBuilder signUp = new SignUpBuilder.Builder()
                .withFirstName("First name")
                .withLastName("S")
                .withEmail(properties.getProperty("email"))
                .withPassword(properties.getProperty("password"))
                .withCheckbox(false)
                .build();

        new SignUpPage()
                .enterData(signUp);
    }
}
