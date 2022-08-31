package Task_5;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static Driver.SimpleDriver.getWebDriver;

public class Task_5 {

    @BeforeTest
    public void precondition() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @BeforeMethod
    public void before() {
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void test1() {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "7");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "3");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "1000");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "100");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "10");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "500");
        Select selectRoom = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectRoom.selectByValue("tow");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "300");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "10");
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div span[id]"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        });
        List<String> expectedData = new ArrayList<>() {{
            add("20.80 м2.");
            add("211 шт.");
            add("22 шт.");
            add("11000 руб.");
            add("9 шт.");
            add("12 шт.");
            add("");
        }};
        Assert.assertEquals(actualData, expectedData);
    }
    @Test
    public void test2() {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "4");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "4");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "1500");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "250");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "20");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "350");
        Select selectRoom = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectRoom.selectByValue("toh");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "450");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "10");
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div span[id]"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        });
        List<String> expectedData = new ArrayList<>() {{
            add("15.84 м2.");
            add("44 шт.");
            add("3 шт.");
            add("7875 руб.");
            add("16 шт.");
            add("4 шт.");
            add("");
        }};
        Assert.assertEquals(actualData, expectedData);
    }
    @Test
    public void test3() {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "15");
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "10");
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "980");
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "130");
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "9");
        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "80");
        Select selectRoom = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectRoom.selectByValue("tow");
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "490");
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "15");
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div span[id]"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        });
        List<String> expectedData = new ArrayList<>() {{
            add("149.50 м2.");
            add("1194 шт.");
            add("133 шт.");
            add("12199 руб.");
            add("3 шт.");
            add("39 шт.");
            add("");
        }};
        Assert.assertEquals(actualData, expectedData);
    }

   @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }
}
