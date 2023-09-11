package framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver driver;

    private Browser() {
        try {
            driver = BrowserFactory.factoryMethod();
        } catch (Exception ex) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new Browser();
        }

        return driver;
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static void quit() {
        getDriver().quit();
        driver = null;
    }

    public static void refresh() {
        getDriver().navigate().refresh();
    }

    public static void setMaximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void timeouts() {
        getDriver().manage().timeouts();
    }
}
