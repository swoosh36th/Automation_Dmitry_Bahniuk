package pageObjects.index;

import org.openqa.selenium.support.PageFactory;
import pageObjects.baseObjects.BasePage;

public class NavigationPage extends BasePage {

    public NavigationPage() {
        PageFactory.initElements(driver, this);
    }

    public NavigationPage open() {
        load();
        return this;
    }
}
