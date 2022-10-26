package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class TagAPage extends BasePage {
    private final By link = By.partialLinkText("W3Schools");

    public TagAPage clickLink() {
        click(link);
        return this;
    }

    public TagAPage verifyOpenNewPage() {
        log.debug("Get and verify URL");
        Assert.assertEquals(getPageUrl(), "https://www.w3schools.com/");
        return this;
    }
}
