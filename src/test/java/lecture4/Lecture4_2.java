package lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lecture4_2 {

    WebDriver driver;

    @BeforeTest
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void test1() {
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@value='Continue']"));
        zipCode.sendKeys("1111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = driver.findElement(By.name("zip_code"));
        Assert.assertTrue(updatedZipCode.isDisplayed());
    }

    @Test
    public void test2() {
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys("11111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(updatedZipCode.isDisplayed());
    }

    @Test
    public void test3() {
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys("111111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = driver.findElement(By.name("zip_code"));
        Assert.assertTrue(updatedZipCode.isDisplayed());
    }

    @AfterTest
    public void postconditions(){
        driver.close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
