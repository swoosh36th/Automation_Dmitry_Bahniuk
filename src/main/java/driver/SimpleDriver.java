package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleDriver {
    private static WebDriver webDriver;

    {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            //Вторая реализация
            //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            //Третяя реализация
            //WebDriverManager.getInstance("chrome").setup();
            webDriver = new ChromeDriver(getChromeOptions());
            //Время ожидания
            //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
            //webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
    }
    public static WebDriver getWebDriver() {
        return webDriver;
    }
    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(getChromeOptions());
        webDriver = driver;
    }
    public static void closeWebDriver(){
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}

