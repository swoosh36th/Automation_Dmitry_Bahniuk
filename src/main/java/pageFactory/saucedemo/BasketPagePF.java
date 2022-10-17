package pageFactory.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class BasketPagePF extends BasePage {
    @FindBy(id = "item_4_title_link")
    WebElement itemBackPack;

    @FindBy(id = "item_0_title_link")
    WebElement itemBikeLight;

    @FindBy(id = "item_1_title_link")
    WebElement itemBoltTShirt;

    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackPackFromCartBtn;

    @FindBy(how = How.XPATH, using = "(//button[text()='Remove'])[1]")
    WebElement topRemoveBtn;

    public BasketPagePF(){
        PageFactory.initElements(driver, this);
    }

    public BasketPagePF verifyBackPackInCart(){
        Assert.assertEquals(getText(itemBackPack), "Sauce Labs Backpack");
        return this;
    }

    public BasketPagePF verifyBoltTShirtInCart(){
        Assert.assertEquals(getText(itemBoltTShirt), "Sauce Labs Bolt T-Shirt");
        return this;
    }

    public BasketPagePF clickRemoveFromCartBtn() {
        click(removeBackPackFromCartBtn);
        return this;
    }

    public BasketPagePF verifyItemInCart(WebElement webElement, String itemName){
        Assert.assertEquals(getText(webElement), itemName);
        return this;
    }

}
