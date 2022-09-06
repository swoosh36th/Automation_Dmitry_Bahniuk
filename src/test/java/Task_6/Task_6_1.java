package Task_6;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;

public class Task_6_1 {
    @BeforeTest
    public void precondition(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.xpath("//input[@value='Login']")).click();
        getWebDriver().findElement(By.xpath("//button[contains(@name,'bike-light')]")).click();
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
    }
    @Test
    public void test1(){
        WebElement element = getWebDriver().findElement(By.xpath("//div[contains(text(),'Light')]"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");

    }
    @Test
    public void test2(){
        WebElement element = getWebDriver().findElement(By.xpath("//div[text()='9.99']"));
        Assert.assertEquals(element.getText(),"$9.99");
    }
    @Test
    public void test3(){
        WebElement element = getWebDriver().findElement(By.xpath("//button[@data-test='checkout' and @id='checkout']"));
        Assert.assertEquals(element.getText(), "CHECKOUT");
    }
    @Test
    public void test4(){
        WebElement element = getWebDriver().findElement(By.xpath("//div[contains(@class,'price') and contains(text(),'$')]"));
        Assert.assertEquals(element.getText(),"$9.99");
    }
    @Test
    public void test5(){
        WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Bike')]//ancestor::a"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void test6(){
        WebElement element = getWebDriver().findElement(By.xpath("//div[contains(@class,'cart_i')]//descendant::a"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void test7(){
        WebElement element = getWebDriver().findElement(By.xpath("//div//following::a[contains(@id,'_0_')]"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void test8(){
        WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Bike')]//parent::a"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void test9(){
        WebElement element = getWebDriver().findElement(By.xpath("//div//preceding::a[contains(@id,'_0_')]"));
        Assert.assertEquals(element.getText(),"Sauce Labs Bike Light");
    }
    @Test
    public void test10() {
        WebElement element = getWebDriver().findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void test11(){
        WebElement element = getWebDriver().findElement(By.cssSelector("#checkout"));
        Assert.assertEquals(element.getText(), "CHECKOUT");
    }
    @Test
    public void test12(){
        WebElement element = getWebDriver().findElement(By.cssSelector(".btn.btn_secondary.btn_small"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test13(){
        WebElement element = getWebDriver().findElement(By.cssSelector(".item_pricebar .btn"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test14(){
        WebElement element = getWebDriver().findElement(By.cssSelector("div > a > div"));
        Assert.assertEquals(element.getText(), "Sauce Labs Bike Light");
    }
    @Test
    public void test15(){
        WebElement element = getWebDriver().findElement(By.cssSelector("div.inventory_item_price"));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void test16(){
        WebElement element = getWebDriver().findElement(By.cssSelector("[class=inventory_item_price]"));
        Assert.assertEquals(element.getText(), "$9.99");
    }
    @Test
    public void test17(){
        WebElement element = getWebDriver().findElement(By.cssSelector("[class~=btn_small]"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test18(){
        WebElement element = getWebDriver().findElement(By.cssSelector("[id|=remove-sauce]"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test19(){
        WebElement element = getWebDriver().findElement(By.cssSelector("button[data-test^=remove]"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test20(){
        WebElement element = getWebDriver().findElement(By.cssSelector("button[data-test$=light]"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test21(){
        WebElement element = getWebDriver().findElement(By.cssSelector("button[data-test*=bike]"));
        Assert.assertEquals(element.getText(), "REMOVE");
    }
    @Test
    public void test22(){
        WebElement element = getWebDriver().findElement(By.linkText("LinkedIn"));
        Assert.assertEquals(element.getText(), "LinkedIn");
    }@Test
    public void test23(){
        WebElement element = getWebDriver().findElement(By.partialLinkText("edIn"));
        Assert.assertEquals(element.getText(), "LinkedIn");
    }
    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }
}
