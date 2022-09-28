package task_9;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class Task_9Test extends BaseTest {
    @Test
    public void loginTest1(){
        new LoginPage()
                .open()
                .enterUserName("dfvgb")
                .enterPassword("dfg")
                .clickLoginBtn();
    }
}
