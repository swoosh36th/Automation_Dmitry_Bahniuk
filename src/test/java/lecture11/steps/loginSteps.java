package lecture11.steps;

import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.LoginPage;

public class loginSteps extends BasePage {
    LoginPage loginPage = new LoginPage();
    public loginSteps login(String username, String password){
        loginPage
                .open()
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginBtn();
        return this;
    }
}
