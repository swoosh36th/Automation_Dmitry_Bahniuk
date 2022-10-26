package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class DynamicLoadingPage extends BasePage{
    private final By startBtn = By.id("start");
    private final By loading = By.id("loading");
    private final By finish = By.id("finish");

    private By getByLink(String textLink) {
        return By.partialLinkText(textLink);
    }

    public DynamicLoadingPage clickOnExample(String text){
        click(getByLink(text));
        return this;
    }

    public DynamicLoadingPage clickOnStartBtn(){
        click(startBtn);
        return this;
    }
    public String pageIsLoaded(){
        return getText(finish);
    }
}
