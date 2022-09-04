package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By blockedUser = By.xpath("//h3[@data-test]");
        public LoginPage open(){
            getWebDriver().get("https://www.saucedemo.com/");
            return this;
        }
        public LoginPage enterUserName(String username){
            enter(this.username, username);
            return this;
        }
        public LoginPage enterPassword(String password){
            enter(this.password, password);
            return this;
        }
        public LoginPage clickLoginBtn(){
            click(loginBtn);
            return this;
        }
        public void verifyBlockedUser(){
            Assert.assertEquals(getWebDriver().findElement(blockedUser).getText(), "Epic sadface: Sorry, this user has been locked out.");
        }

}


