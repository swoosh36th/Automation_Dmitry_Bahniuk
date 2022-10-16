package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DropDownPage1 extends BasePage {
    private final By dropdown = By.id("dropdown");
    private final By title = By.tagName("h3");

    public DropDownPage1 verifyPageTitle(String text) {
        Assert.assertEquals(getText(title), text);
        return this;
    }

    public DropDownPage1 select(Integer index) {
        super.select(dropdown, index);
        return this;
    }

    public DropDownPage1 verifySelectedValue(String value) {
        Select select = new Select(findElement(dropdown));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), value);
        return this;
    }
}
