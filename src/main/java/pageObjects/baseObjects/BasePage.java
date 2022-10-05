package pageObjects.baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;

public abstract class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    protected BasePage(){
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        actions = new Actions(driver);
    }
    protected void enter(WebElement webElement, String enterData){
        System.out.println("I enter :: " + enterData + ", by web element :: " + webElement);
        webElement.clear();
        webElement.sendKeys(enterData);
    }
    protected void enter(By locator, CharSequence... enterData){
        System.out.println("I enter :: " + enterData + ", by locator :: " + locator);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        driver.findElement(locator).sendKeys(enterData);
    }
    protected void click(WebElement webElement){
        System.out.println("I'm click by :: " + webElement);
        webElement.click();
    }
    protected void click(By locator){
        System.out.println("I'm click by :: " + locator);
        driver.findElement(locator).click();
    }
    protected String getText(WebElement webElement){
        System.out.println("I'm get text by  :: " + webElement);
        return webElement.getText();
    }
    protected String getText(By locator){
        System.out.println("I'm get text by  :: " + locator);
        return driver.findElement(locator).getText();
    }
}
