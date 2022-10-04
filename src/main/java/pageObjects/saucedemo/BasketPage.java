package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class BasketPage extends BasePage {
    private final By itemBackPack = By.id("item_4_title_link");
    private final By removeFromCartBtn = By.id("remove-sauce-labs-backpack");
    private final By cartBtn = By.id("shopping_cart_container");
    private final By checkoutBtn = By.id("checkout");

    public void verifyBackPackInCart(){
        Assert.assertEquals(getWebDriver().findElement(itemBackPack).getText(), "Sauce Labs Backpack");
    }
    public void clickRemoveFromCartBtn(){
        click(removeFromCartBtn);
    }
    public void verifyBackPackNotInCart(){
        Assert.assertEquals(getWebDriver().findElement(cartBtn).getText(), "");
    }
    public void clickCheckoutButton(){
        click(checkoutBtn);
    }
}
