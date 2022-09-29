package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class BasketPage extends BasePage {
    private final By itemBackPack = By.id("item_4_title_link");
    private final By itemBikeLight = By.id("item_0_title_link");
    private final By itemBoltTShirt = By.id("item_1_title_link");
    private final By removeBackPackFromCartBtn = By.id("remove-sauce-labs-backpack");
    private final By cartBtn = By.id("shopping_cart_container");
    private final By checkoutBtn = By.id("checkout");
    private final By topRemoveBtn = By.xpath("(//button[text()='Remove'])[1]");

    public void verifyBackPackInCart() {
        Assert.assertEquals(getWebDriver().findElement(itemBackPack).getText(), "Sauce Labs Backpack");
    }

    public void verifyBikeLightInCart() {
        Assert.assertEquals(getWebDriver().findElement(itemBikeLight).getText(), "Sauce Labs Bike Light");
    }

    public void verifyBoltTShirtInCart() {
        Assert.assertEquals(getWebDriver().findElement(itemBoltTShirt).getText(), "Sauce Labs Bolt T-Shirt");
    }

    public void verifyThreeItemsInCart() {
        Assert.assertEquals(getWebDriver().findElement(itemBackPack).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(getWebDriver().findElement(itemBikeLight).getText(), "Sauce Labs Bike Light");
        Assert.assertEquals(getWebDriver().findElement(itemBoltTShirt).getText(), "Sauce Labs Bolt T-Shirt");
    }

    public void clickRemoveFromCartBtn() {
        click(removeBackPackFromCartBtn);
    }

    public void clickCheckoutButton() {
        click(checkoutBtn);
    }
    public void deleteThreeItemsFromCart(){
        for(int i=0; i<3;i++){
            click(topRemoveBtn);
        }
    }
    public void verifyNoItemsInCart(){
        Assert.assertEquals(getWebDriver().findElement(cartBtn).getText(), "");
    }
    public BasketPage verifyItemInCart(String locator, String itemName){
        Assert.assertEquals(driver.findElement(By.id(locator)).getText(), itemName);
        return this;
    }
}
