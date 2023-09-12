import framework.utils.CooperationWithDialogWindow;
import framework.utils.PropertiesManager;
import framework.utils.SmartLogger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.ConfigVariables;
import steps.MainPageSteps;

import static services.Paths.*;
import static services.Files.*;

public class GetNewDataset extends BaseTest {

    private final String IMAGES_NUMBER = PropertiesManager.getValue(CONFIG_PROPERTIES_PATHS.getPath(),
            (CONFIG_PROPERTIES.getFile()), (ConfigVariables.IMAGES_NUMBER.getVariable()));
    private final String IMAGE_FORMAT = PropertiesManager.getValue(CONFIG_PROPERTIES_PATHS.getPath(),
            (CONFIG_PROPERTIES.getFile()), (ConfigVariables.IMAGE_FORMAT.getVariable()));
    private final String IMAGE_PATH = DATASET.getPath().concat(IMAGE.getFile());
    private final String NEW_IMAGE_PATH = NEW_DATASET.getPath();

    private int step = 0;

    @DataProvider(name = "imageNumber")
    public Object[][] getImagesNumber() {
        int number = Integer.parseInt(IMAGES_NUMBER);
        Object[][] objects = new Object[number][1];
        for (int i = 1; i <= number; i++) {
            objects[i - 1][0] = String.valueOf(i);
        }
        return objects;
    }

    @Test(dataProvider = "imageNumber")
    public void getNewDataset(String imageNumber) {
        step = 0;
        MainPageSteps.assertIsOpenPage();

        SmartLogger.logStep(++step, "Click 'Open image'");
        MainPageSteps.clickOpenImageBtn();

        SmartLogger.logStep(++step, "Select image");
        CooperationWithDialogWindow.openFileFromDialogWindow(IMAGE_PATH.concat(imageNumber).concat(IMAGE_FORMAT));

        SmartLogger.logStep(++step, "Take and save screenshot");
        PropertiesManager.saveFile(MainPageSteps.getImage(IMAGE_FORMAT),
                NEW_IMAGE_PATH.concat(imageNumber).concat(IMAGE_FORMAT));

        SmartLogger.logStep(++step, "Click 'Close image'");
        MainPageSteps.clickCloseImageBtn();
    }
}
