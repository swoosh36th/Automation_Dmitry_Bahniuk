package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObjects.baseObjects.BasePage;

public class FramesPage extends BasePage {
    private By clickLink(String linkText) {
        return By.linkText(linkText);
    }
    private By iFrame = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");
    private By boldText = By.cssSelector("[aria-label='Bold']");
    public FramesPage clickFrameLink(String linkText){
        click(clickLink(linkText));
        return this;
    }
    public FramesPage switchToFrame(){
        driver.switchTo().frame(driver.findElement(iFrame));
        return this;
    }
    public FramesPage enterText(String text){
        enter(textArea, text, Keys.chord(Keys.CONTROL, "a"));
        return this;
    }
    public FramesPage unSwitchFrame(){
        driver.switchTo().defaultContent();
        return this;
    }
    public FramesPage clickTextBold(){
        click(boldText);
        return this;
    }
}
