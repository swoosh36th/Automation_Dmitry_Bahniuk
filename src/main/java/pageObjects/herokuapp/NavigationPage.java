package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class NavigationPage extends BasePage{
    private By getByLink(String textLink){
        return By.partialLinkText(textLink);
    }

    public NavigationPage open(){
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }


    public void navigateTo(NavigationItem navigationItem){
        click(getByLink(navigationItem.getItem()));
    }

}
