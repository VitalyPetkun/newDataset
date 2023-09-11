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

    public static void openFileFromDialogWindow(String path, String fileName) {
        SmartLogger.logInfo("Selecting a file to upload");
        try {
            Thread.sleep(SLEEP_TIME);
            Robot robot = new Robot();
            StringSelection stringSelection = new StringSelection(path.concat(fileName));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException | AWTException e) {
            SmartLogger.logError("Robot not create");
        }
    }
}
