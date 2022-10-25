package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class BasketPage extends BasePage {
    private final By itemBackPack = By.id("item_4_title_link");
    private final By itemBikeLight = By.id("item_0_title_link");
    private final By itemBoltTShirt = By.id("item_1_title_link");
    private final By removeBackPackFromCartBtn = By.id("remove-sauce-labs-backpack");
    private final By cartBtn = By.id("shopping_cart_container");
    private final By checkoutBtn = By.id("checkout");
    private final By topRemoveBtn = By.xpath("(//button[text()='Remove'])[1]");

    public BasketPage verifyBackPackInCart() {
        Assert.assertEquals(getText(itemBackPack), "Sauce Labs Backpack");
        return this;
    }

    public BasketPage verifyBikeLightInCart() {
        Assert.assertEquals(getText(itemBikeLight), "Sauce Labs Bike Light");
        return this;
    }

    public BasketPage verifyBoltTShirtInCart() {
        Assert.assertEquals(getText(itemBoltTShirt), "Sauce Labs Bolt T-Shirt");
        return this;
    }

    public BasketPage verifyThreeItemsInCart() {
        Assert.assertEquals(getText(itemBackPack), "Sauce Labs Backpack");
        Assert.assertEquals(getText(itemBikeLight), "Sauce Labs Bike Light");
        Assert.assertEquals(getText(itemBoltTShirt), "Sauce Labs Bolt T-Shirt");
        return this;
    }

    public BasketPage clickRemoveFromCartBtn() {
        click(removeBackPackFromCartBtn);
        return this;
    }

    public BasketPage clickCheckoutButton() {
        click(checkoutBtn);
        return this;
    }
    public BasketPage deleteThreeItemsFromCart(){
        for(int i=0; i<3;i++){
            click(topRemoveBtn);
        }
        return this;
    }
    public BasketPage verifyNoItemsInCart(){
        Assert.assertEquals(getText(cartBtn), "");
        return this;
    }
    public BasketPage verifyItemInCart(String locator, String itemName){
        Assert.assertEquals(driver.findElement(By.id(locator)).getText(), itemName);
        return this;

    }
}
