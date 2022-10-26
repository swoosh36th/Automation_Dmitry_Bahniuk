package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import static driver.DriverManager.getDriver;
@Log4j
public class SelectElementPage extends BasePage {

    @FindBy(xpath = "(//input[@type='submit'])[3]")
    WebElement sendBtn;

    @FindBy(id = "cars")
    WebElement selectCars;

    public SelectElementPage(){
        PageFactory.initElements(driver, this);
    }

    public SelectElementPage selectAudi() {
        select(selectCars, "audi");
        return this;
    }

    public SelectElementPage clickSendBtn() {
        click(sendBtn);
        return this;
    }

    public SelectElementPage verifyAudiIsSelect() {
        log.debug("Get and verify value from URL - Audi");
        Assert.assertTrue(getDriver().getCurrentUrl().contains("audi"));
        return this;
    }
}
