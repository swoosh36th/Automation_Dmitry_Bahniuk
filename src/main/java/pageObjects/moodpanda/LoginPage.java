package pageObjects.moodpanda;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends MoodPandaBasePage {

    By email = By.cssSelector("[type='text']");
    By password = By.cssSelector("[type='password']");
    By loginBtn = By.xpath("//button[@class]");
    By notification = By.cssSelector("[class^=notification]");

    public LoginPage() {
        isPageOpened();
    }

    public LoginPage enterPassword(String password){
        enter(this.password, password);
        return this;
    }

    public LoginPage enterEmail(String email){
        enter(this.email, email);
        return this;
    }

    public LoginPage clickLoginBtn(){
        click(loginBtn);
        return this;
    }

    public LoginPage verifyErrorMessage(String message) {
        Assert.assertEquals(getText(notification), message);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityElement(email);
    }
}
