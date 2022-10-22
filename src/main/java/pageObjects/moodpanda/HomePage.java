package pageObjects.moodpanda;

import org.openqa.selenium.By;

public class HomePage extends MoodPandaBasePage {

    private final By getStartedBtn = By.partialLinkText("Get started");
    private final By title = By.cssSelector("[class^=container] > p[class^='title ']");


    public HomePage open() {
        load();
        isPageOpened();
        return this;
    }

    public HomePage clickGetStarted() {
        click(getStartedBtn);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityElement(title);
        verifyElementClickable(getStartedBtn);
    }
}
