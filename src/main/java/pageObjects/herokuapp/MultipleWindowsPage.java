package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class MultipleWindowsPage extends BasePage {


    private By getByLink(String textLink) {
        return By.partialLinkText(textLink);
    }

    public MultipleWindowsPage clickOnLink(String text) {
        click(getByLink(text));
        return this;
    }

    public MultipleWindowsPage switchToOldTab() {
               return this;
    }
}
