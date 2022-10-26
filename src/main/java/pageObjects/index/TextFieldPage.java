package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverManager.getDriver;
@Log4j
public class TextFieldPage extends BasePage {
    private final By firstName = By.id("fname");
    private final By lastName = By.id("lname");
    private final By submitBtn = By.xpath("(//input[@type='submit'])[1]");

    public TextFieldPage clickSubmitBtn() {
        click(submitBtn);
        return this;
    }

    public TextFieldPage enterFirstName(String firstName) {
        enter(this.firstName, firstName);
        return this;
    }

    public TextFieldPage enterLastName(String lastName) {
        enter(this.lastName, lastName);
        return this;
    }

    public TextFieldPage verifyEnterData() {
        log.debug("Get and verify URL");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("fname=Jack&lname=Petrov"));
        return this;
    }
}
