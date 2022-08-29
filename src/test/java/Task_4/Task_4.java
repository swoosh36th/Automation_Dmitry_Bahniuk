package Task_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_4 {
    WebDriver driver;
    WebElement field;
    WebElement searchButton;
    WebElement link;

    @BeforeTest
    public void preconditions(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void before(){
        driver.get("https://www.google.by/");
    }

    @Test
    public void googleTest1(){
        //Системная переменная web driver
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //Размер открываемого окна
        //driver.manage().window().maximize();
        //Открытие страницы по адресу
        //driver.get("https://www.google.by/");
        //Поиск элемента по имени
        field = driver.findElement(By.name("q"));
        //Клик по элементу
        field.click();
        //Ввод значения в элемент(поле)
        field.sendKeys("Hello, World!");
        //Поиск элемента по xpath
        searchButton = driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b"));
        //Клик по кнопке(searchButton)
        searchButton.click();
        link = driver.findElement(By.cssSelector("#rso > .MjjYud:nth-child(1) .LC20lb"));
    }
    @Test
    public void googleTest2(){
        field = driver.findElement(By.name("q"));
        field.clear();
        field.click();
        field.sendKeys("///***///");
        searchButton = driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b"));
        searchButton.click();
        link = driver.findElement(By.name("q"));
    }
}
