package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DropdownListPage extends BasePage {
    private By dropDown = By.id("dropdown");
    private Select selectOption = new Select(driver.findElement(dropDown));

    public DropdownListPage selectOption1ByValue(){
        selectOption.selectByValue("1");
        return this;
    }
    public DropdownListPage verifySelectOption(){
        Assert.assertEquals(driver.findElement(dropDown).getAttribute("value"), "1");
        return this;
    }
    public DropdownListPage selectOption1ByName(){
        selectOption.selectByVisibleText("Option 1");
        return this;
    }
}
