package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage extends BasePage {
    private final By title = By.xpath("//span[@class='title']");
    private final By addToCartBackPackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBtn = By.id("shopping_cart_container");
    private final By addToCartBikeLightBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCartBoltTShirtBtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By topAddToCartBtn = By.xpath("(//button[text()='Add to cart'])[1]");

    private By getElementProduct(String productName) {
        return By.xpath("//*[@class = 'inventory_item_name' and text()='" + productName + "']ancestor::div[@class='inventory_item']");
    }

    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement((SearchContext) By.tagName("button"));
    }

    public ProductPage verifyPageUri() {
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("inventory.html"));
        return this;
    }

    public ProductPage verifyPageTitle() {
        Assert.assertEquals(getWebDriver().findElement(title).getText(), "PRODUCTS");
        return this;
    }

    public ProductPage clickAddToCartBackPack() {
        click(addToCartBackPackBtn);
        return this;
    }

    public ProductPage clickToCart() {
        click(cartBtn);
        return this;
    }

    public ProductPage clickAddToCartBikeLight() {
        click(addToCartBikeLightBtn);
        return this;
    }

    public ProductPage clickAddToCartBoltTShirt() {
        click(addToCartBoltTShirtBtn);
        return this;
    }

    public ProductPage addTopItemToCart() {
        click(topAddToCartBtn);
        return this;
    }

    public ProductPage addItemToCart(String locator) {
        click(By.id(locator));
        return this;
    }

    public ProductPage addProductToBasket(String productName) {
        click(getAddToCartBtn(productName));
        return this;
    }
}
