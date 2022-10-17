package pageFactory.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class LoginPagePF extends BasePage {
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//h3[@data-test]")
    WebElement blockedUser;

    public LoginPagePF() {
        PageFactory.initElements(driver, this);
    }

    public LoginPagePF open() {
        load("https://www.saucedemo.com/");
        return this;
    }

    public LoginPagePF open(String url) {
        driver.get(url);
        return this;
    }

    public LoginPagePF enterUserName(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPagePF enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPagePF clickLoginBtn() {
        click(loginBtn);
        return this;
    }

    public LoginPagePF verifyThatLoginPageIsClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) loginBtn));
        return this;

    }

    public LoginPagePF verifyBlockedUser() {
        Assert.assertEquals(getText(blockedUser),
                "Epic sadface: Sorry, this user has been locked out.");
        return this;
    }

    public LoginPagePF verifyWrongData() {
        Assert.assertEquals(getText(blockedUser),
                "Epic sadface: Username and password do not match any user in this service");
        return this;
    }
}


