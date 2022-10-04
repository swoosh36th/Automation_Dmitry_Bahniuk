package task_6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task_6_2 {
    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.xpath("//input[@value='Login']")).click();
    }
    @Test
    public void aboveTest(){
        WebElement element = getWebDriver().findElement(with(By.tagName("div")).above(By.xpath("//div[contains(text(),'Water-resistant')]")));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void belowTest(){
        WebElement element = getWebDriver().findElement(with(By.tagName("div")).below(By.xpath("//div[contains(text(),'Water-resistant')]")));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void toRightOfTest(){
        WebElement element = getWebDriver().findElement(with(By.tagName("div")).toRightOf(By.id("item_0_img_link")));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void toLeftOfTest(){
        WebElement element = getWebDriver().findElement(with(By.className("inventory_item_price")).toLeftOf(By.id("add-to-cart-sauce-labs-bike-light")));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void nearTest(){
        WebElement element = getWebDriver().findElement(with(By.className("inventory_item_price")).near(By.id("item_0_img_link")));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }
}
