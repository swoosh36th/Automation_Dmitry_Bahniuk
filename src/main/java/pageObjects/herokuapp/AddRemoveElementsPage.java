package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class AddRemoveElementsPage extends BasePage {
    private By addElementBtn = By.xpath("(//button)[1]");
    private By deleteBtn1 = By.xpath("(//button)[2]");
    private By deleteBtn6 = By.xpath("(//button)[7]");

    public AddRemoveElementsPage clickAddElementButton() {
        click(addElementBtn);
        return this;
    }

    public AddRemoveElementsPage verifyAddOneDeleteBtn() {
        Assert.assertTrue(driver.findElement(deleteBtn1).isDisplayed());
        return this;
    }

    public AddRemoveElementsPage verifyAddSixDeleteBtn() {
        Assert.assertTrue(driver.findElement(deleteBtn6).isDisplayed());
        return this;
    }

    public AddRemoveElementsPage clickDeleteBtn() {
        click(deleteBtn1);
        return this;
    }

    public AddRemoveElementsPage addSixDeleteBtn() {
        for (int i = 0; i < 6; i++) {
            clickAddElementButton();
        }
        return this;
    }

    public AddRemoveElementsPage removeDeleteBtn() {
        for (int i = 0; i < 6; i++) {
            clickDeleteBtn();
        }
        return this;
    }

    public boolean verifyDeleteBtnMissing() {
        try {
            return driver.findElement(deleteBtn1).isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
