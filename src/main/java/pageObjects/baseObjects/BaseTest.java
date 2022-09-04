package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static driver.SimpleDriver.closeWebDriver;

public abstract class BaseTest {
    @BeforeTest
    public void preconditions(){
        System.out.println("I started new webDriver!");
        new SimpleDriver();
    }
    @AfterTest
    public void postconditions(){
        System.out.println("I closed webDriver!");
        closeWebDriver();
    }
}
