package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverManager.getDriver;

@Log4j
public class CheckboxPage extends BasePage {
    private final By bikeCheckbox = By.id("vehicle1");
    private final By carCheckbox = By.id("vehicle2");
    private final By boatCheckbox = By.id("vehicle3");
    private final By summitBtn = By.xpath("(//input[@type='submit'])[2]");

    public CheckboxPage clickBikeCheckBox() {
        click(bikeCheckbox);
        return this;
    }

    public CheckboxPage clickCarCheckBox() {
        click(carCheckbox);
        return this;
    }

    public CheckboxPage clickBoatCheckBox() {
        click(boatCheckbox);
        return this;
    }

    public CheckboxPage clickSubmitBtn() {
        click(summitBtn);
        return this;
    }

    public CheckboxPage verifyBikeCheckboxIsSelect() {
        log.debug("Get and verify text from URL - Bike");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("Bike"));
        return this;
    }

    public CheckboxPage verifyCarCheckboxIsSelect() {
        log.debug("Get and verify text from URL - Car");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("Car"));
        return this;
    }

    public CheckboxPage verifyBoatCheckboxIsSelect() {
        log.debug("Get and verify text from URL - Boat");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("Boat"));
        return this;
    }
}
