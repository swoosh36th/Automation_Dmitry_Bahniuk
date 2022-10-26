package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverManager.getDriver;
@Log4j
public class ImagePage extends BasePage {
    private final By turtleImg = By.xpath("//img");

    public ImagePage verifyImageIsDisplayed() {
        log.debug("Verify turtle image is displayed");
        Assert.assertTrue(getDriver().findElement(turtleImg).isDisplayed());
        return this;
    }
}
