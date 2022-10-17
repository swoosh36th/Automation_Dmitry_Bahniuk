package pageFactory.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class CheckoutPagePF extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement zipCode;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(id = "finish")
    WebElement finishBtn;
    @FindBy(className = "complete-header")
    WebElement completeHeader;

    public CheckoutPagePF() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutPagePF enterFirstName(String firstName) {
        enter(this.firstName, firstName);
        return this;
    }

    public CheckoutPagePF enterLastName(String lastName) {
        enter(this.lastName, lastName);
        return this;
    }

    public CheckoutPagePF enterZipCode(String zipCode) {
        enter(this.zipCode, zipCode);
        return this;
    }

    public CheckoutPagePF clickContinueBtn() {
        click(continueBtn);
        return this;
    }

    public CheckoutPagePF clickFinishBtn() {
        click(finishBtn);
        return this;
    }

    public CheckoutPagePF verifyCheckout() {
        Assert.assertEquals(getText(completeHeader), "THANK YOU FOR YOUR ORDER");
        return this;
    }
}
