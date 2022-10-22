package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.entity.CheckOut;
import pageObjects.saucedemo.entity.CheckOutBuilder;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueBtn = By.xpath("(//div/input)[4]");
    private final By finishBtn = By.id("finish");
    private final By completeCheckOut = By.className("complete-header");
    private final By checkoutStep1Passed = By.xpath("//div/span");
    public CheckoutPage enterFirstName(String firstName) {
        enter(this.firstName, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        enter(this.lastName, lastName);
        return this;
    }

    public CheckoutPage enterZipCode(String zipCode) {
        enter(this.zipCode, zipCode);
        return this;
    }

    public CheckoutPage clickContinueBtn() {
        click(continueBtn);
        return this;
    }
    public CheckoutPage clickFinishBtn(){
        click(finishBtn);
        return this;
    }
    public CheckoutPage verifyCheckout(){
        Assert.assertEquals(getText(completeCheckOut), "THANK YOU FOR YOUR ORDER");
        return this;
    }

    public CheckoutPage verifyCheckoutStep1Passed() {
        Assert.assertEquals(getText(checkoutStep1Passed), "Checkout: Overview");
        return this;
    }

    public CheckoutPage enterData(CheckOut checkOut){
        enterFirstName(checkOut.getFirstName());
        enterLastName(checkOut.getLastName());
        enterZipCode(checkOut.getZipCode());
        clickContinueBtn();
        return this;
    }
    public CheckoutPage enterData(CheckOutBuilder checkOutBuilder){
        enterFirstName(checkOutBuilder.getFirstName());
        enterLastName(checkOutBuilder.getLastName());
        enterZipCode(checkOutBuilder.getZipCode());
        clickContinueBtn();
        return this;
    }
}
