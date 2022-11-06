package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j

public class ButtonPage extends BasePage {
    private final By clickMeBtn = By.xpath("//input[@type='button']");

    public ButtonPage clickClickMeBtn() {
        clickWithoutVerifyClickable(clickMeBtn);
        return this;
    }

    public ButtonPage verifyAlertMsg() {
        log.debug("Get and verify text from alert");
        Assert.assertEquals(driver.switchTo().alert().getText(),"Hello World!");

        return this;
    }

    public ButtonPage closeAlert() {
        log.debug("Close alert");
        driver.switchTo().alert().accept();
        return this;
    }
}
