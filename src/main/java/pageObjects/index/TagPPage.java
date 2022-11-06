package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class TagPPage extends BasePage {
    private final By text = By.xpath("(//p)[6]");

    public TagPPage verifyTextFromTagP() {
        log.debug("Get and verify text");
        Assert.assertEquals(getText(text), "This is a paragraph.");
        return this;
    }
}
