package framework.utils;

import framework.services.ConfigVariables;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static framework.services.Files.*;
import static framework.services.Paths.*;

public class CooperationWithDialogWindow {

    private static final int SLEEP_TIME = Integer.parseInt(PropertiesManager.
            getValue(FRAMEWORK_RESOURCES_PATH.getPath(), FRAMEWORK_CONFIG.getFile(),
                    ConfigVariables.SLEEP_TIME.getVariables()));

    private CooperationWithDialogWindow() {
    }

    public static void openFileFromDialogWindow(String filePath) {
        SmartLogger.logInfo("Select a file to load");
        try {
            Robot robot = new Robot();
            StringSelection stringSelection = new StringSelection(System.getProperty("user.dir").concat(filePath));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            Thread.sleep(SLEEP_TIME);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException | AWTException e) {
            SmartLogger.logError("Robot not create");
        }
    }
}
