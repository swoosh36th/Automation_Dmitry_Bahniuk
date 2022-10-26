package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;

public class DynamicControlsPage extends BasePage{
    private By checkbox = By.xpath("//input[@type='checkbox']");
    private By removeBtn = By.xpath("//button[text()='Remove']");
    private By inputField = By.xpath("//form/input");
    private By edBtn = By.xpath("//button[@onclick='swapInput()']");
    private By enabledMsg = By.xpath("//form/p");
    private By goneMsg = By.id("message");

    public DynamicControlsPage clickCheckBox(){
        click(checkbox);
        return this;
    }
    public DynamicControlsPage clickRemoveBtn(){
        click(removeBtn);
        return this;
    }
    public DynamicControlsPage waitForText(){
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        return this;
    }
    public DynamicControlsPage verifyThatRemoveDone(){
        Assert.assertEquals(getText(goneMsg), "It's gone!");
        return this;
    }
    public boolean verifyCheckboxMissing(){
       try{
           return driver.findElement(checkbox).isDisplayed();
       }catch (NoSuchElementException e){
           return true;
       }
    }
    public DynamicControlsPage verifyInputDisable(){
        Assert.assertFalse(driver.findElement(inputField).isEnabled());
        return this;
    }
    public DynamicControlsPage clickEdBtn(){
        click(edBtn);
        return this;
    }
    public DynamicControlsPage verifyThatInputIsEnabled(){
        Assert.assertEquals(getText(enabledMsg),"It's enabled!");
        return this;
    }
    public DynamicControlsPage verifyInputEnable(){
        Assert.assertTrue(driver.findElement(inputField).isEnabled());
        return this;
    }
}
