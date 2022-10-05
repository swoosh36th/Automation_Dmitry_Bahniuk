package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    {
        if (webDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            webDriver.set(new ChromeDriver(getChromeOptions()));
            //Вторая реализация
            //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            //Третяя реализация
            //WebDriverManager.getInstance("chrome").setup();
            //Время ожидания
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            webDriver.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
        }
    }
    public static WebDriver getWebDriver(){
        return webDriver.get();
    }
    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(getChromeOptions());
        webDriver.set(driver);
    }
    public static void closeWebDriver(){
        if (webDriver.get() != null) {
            webDriver.get().close();
            webDriver.get().quit();
            webDriver = null;
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}

