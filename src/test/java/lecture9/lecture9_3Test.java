package lecture9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class lecture9_3Test extends BaseTest{
    @Parameters("url")
    @BeforeMethod
    public void preconditions(String url){
        new LoginPage()
                .open(url);
    }
    @Test(dataProvider = "login data")
    public void login(@Optional("") String username, String password){
        new LoginPage()
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginBtn();
    }
    @DataProvider(name = "login data")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }
}
