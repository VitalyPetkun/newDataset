package steps;

import org.testng.Assert;
import pages.MainPage;

import java.io.File;

public class MainPageSteps {

    private static MainPage mainPage = new MainPage();

    private MainPageSteps() {}

    public static void clickOpenImageBtn() {
        mainPage.clickOpenImageBtn();
    }

    public static void clickCloseImageBtn() {
        mainPage.clickCloseImageBtn();
    }

    public static String getSrcImage() {
        return mainPage.getSrcImage();
    }

    public static File getImage(String format) {
        return mainPage.getImage(format);
    }

    public static void assertIsOpenPage() {
        Assert.assertTrue(mainPage.isFormOpen(), "Page don't open");
    }

}
