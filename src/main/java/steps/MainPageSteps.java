package steps;

import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {

    private static MainPage mainPage = new MainPage();

    private MainPageSteps() {}

    public static void clickOpenImageBtn() {
        mainPage.clickOpenImageBtn();
    }

    public static String getSrcImage() {
        return mainPage.getSrcImage();
    }

    public static void assertIsOpenPage() {
        Assert.assertTrue(mainPage.isFormOpen(), "Page don't open");
    }

}
