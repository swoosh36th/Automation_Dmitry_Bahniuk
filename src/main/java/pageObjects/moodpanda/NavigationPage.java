package pageObjects.moodpanda;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class NavigationPage extends BasePage {
    private final By signUpBtn =By.partialLinkText("Sign Up");

    public NavigationPage clickSignUpBtn() {
        click(signUpBtn);
        return this;
    }


}
