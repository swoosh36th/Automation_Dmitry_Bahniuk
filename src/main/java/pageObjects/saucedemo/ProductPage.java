package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage extends BasePage {
    private final By title = By.xpath("//span[@class='title']");
    private final By addToCartBackPackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBtn = By.id("shopping_cart_container");

    private By getElementProduct(String productName){
        return By.xpath("//*[@class = 'inventory_item_name' and text()='"+ productName + "']ancestor::div[@class='inventory_item']");
    }
    public ProductPage(){
        verifyPageUri();
    }
    public void verifyPageUri(){
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("inventory.html"));
    }
    public void verifyPageTitle(){
        Assert.assertEquals(getWebDriver().findElement(title).getText() , "PRODUCTS");
    }
    public ProductPage clickAddToCartBackPack(){
        click(addToCartBackPackBtn);
        return this;
    }
    public ProductPage clickToCart(){
        click(cartBtn);
        return this;
    }
}
