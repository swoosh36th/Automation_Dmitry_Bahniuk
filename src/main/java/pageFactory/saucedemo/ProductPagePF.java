package pageFactory.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverManager.getDriver;

public class ProductPagePF extends BasePage {
    @FindBy(xpath = "//span[@class='title']")
    WebElement title;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackPackBtn;
    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addToCartBikeLightBtn;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartBoltTShirtBtn;
    @FindBy(xpath = "//button[text()='Add to cart'])[1]")
    WebElement topAddToCartBtn;

    private By getElementProduct(String productName){
        return By.xpath("//*[@class = 'inventory_item_name' and text()='"+ productName + "']ancestor::div[@class='inventory_item']");
    }
    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement((SearchContext) By.tagName("button"));
    }
    public ProductPagePF(){
        verifyPageUri();
        PageFactory.initElements(driver, this);
    }
    public ProductPagePF verifyPageUri(){
        Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory.html"));
        return this;
    }
    public ProductPagePF verifyPageTitle(){
        Assert.assertEquals(getText(title), "PRODUCTS");
        return this;
    }
    public ProductPagePF clickAddToCartBackPack(){
        click(addToCartBackPackBtn);
        return this;
    }
    public ProductPagePF clickToCart(){
        click(cartBtn);
        return this;
    }
    public ProductPagePF clickAddToCartBikeLight(){
        click(addToCartBikeLightBtn);
        return this;
    }
    public ProductPagePF clickAddToCartBoltTShirt(){
        click(addToCartBoltTShirtBtn);
        return this;
    }
    public ProductPagePF addTopItemToCart(){
        click(topAddToCartBtn);
        return this;
    }
    public ProductPagePF addItemToCart(String locator){
        click(By.id(locator));
        return this;
    }

    public ProductPagePF addProductToBasket(String productName) {
        click(getAddToCartBtn(productName));
        return this;
    }

}
