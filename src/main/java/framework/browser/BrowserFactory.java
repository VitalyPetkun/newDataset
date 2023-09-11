package framework.browser;

import framework.services.ConfigVariables;
import framework.services.Files;
import framework.services.Paths;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import framework.utils.PropertiesManager;

public class BrowserFactory {

    private static final String BROWSER_NAME = PropertiesManager
            .getValue(
                    Paths.FRAMEWORK_RESOURCES_PATH.getPath(),
                    Files.FRAMEWORK_CONFIG.getFile(),
                    ConfigVariables.BROWSER_NAME.getVariables()
            );

    public static WebDriver factoryMethod() throws Exception {
        WebDriver driver;
        switch (BROWSER_NAME) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                throw new Exception("Incorrect browser's name.");
        }

        return driver;
    }
}
