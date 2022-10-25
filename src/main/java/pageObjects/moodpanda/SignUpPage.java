package pageObjects.moodpanda;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
import pageObjects.moodpanda.entity.SignUp;
import pageObjects.moodpanda.entity.SignUpBuilder;

public class SignUpPage extends BasePage {
    private final By firstName = By.cssSelector("[placeholder='Your first name']");
    private final By lastName = By.cssSelector("[placeholder='e.g. 'S'']");
    private final By email = By.cssSelector("[placeholder='Your email address']");
    private final By password = By.cssSelector("[type='password']");
    private final By checkBox = By.cssSelector("[type='checkbox']");
    private final By signUpBtn = By.xpath("//*[@class='box']//button");

    public SignUpPage enterFirstName(String firstName) {
        enter(this.firstName, firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        enter(this.lastName, lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        enter(this.email, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public SignUpPage clickCheckBox() {
        click(checkBox);
        return this;
    }

    public SignUpPage clickSignUpBtn() {
        click(signUpBtn);
        return this;
    }

    public SignUpPage enterData(String firstName, String lastName, String email, String password, Boolean checkbox) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        if(checkbox) clickCheckBox();
        clickSignUpBtn();
        return this;
    }

    public SignUpPage enterData(SignUp signUp) {
        enterFirstName(signUp.getFirstName());
        enterLastName(signUp.getLastName());
        enterEmail(signUp.getEmail());
        enterPassword(signUp.getPassword());
        if(signUp.getCheckbox()) clickCheckBox();
        clickSignUpBtn();
        return this;
    }

    public SignUpPage enterData(SignUpBuilder signUpBuilder) {
        enterFirstName(signUpBuilder.getFirstName());
        enterLastName(signUpBuilder.getLastName());
        enterEmail(signUpBuilder.getEmail());
        enterPassword(signUpBuilder.getPassword());
        if(signUpBuilder.getCheckbox()) clickCheckBox();
        clickSignUpBtn();
        return this;
    }
}
