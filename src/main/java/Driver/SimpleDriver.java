package Driver;

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
        }
    }
    public static WebDriver getWebDriver() {
        return webDriver;
    }
    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
//  private static void setWebDriver() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver(getChromeOptions());
//        webDriver = driver;
//    }
}

