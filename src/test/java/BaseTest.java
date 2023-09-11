import framework.browser.Browser;
import framework.utils.PropertiesManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static services.ConfigVariables.*;
import static services.Files.*;
import static services.Paths.*;

public class BaseTest {

    private String modelForTestingUrl = PropertiesManager.
            getValue(CONFIG_PROPERTIES_PATHS.getPath(), (CONFIG_PROPERTIES.getFile()), (MODEL_FOR_TESTING_URL.getVariable()));

    @BeforeTest
    protected void setup() {
        Browser.setMaximizeWindow();
        Browser.timeouts();
        Browser.openUrl(modelForTestingUrl);
    }

    @AfterTest
    protected void quit() {
        Browser.quit();
    }
}
