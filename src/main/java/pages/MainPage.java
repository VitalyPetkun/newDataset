package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private static String UNIQ_ELEMENT = "//div[@class='header']";
    private static Button OPEN_IMAGE_BTN = new Button(
            By.xpath("//input[@accept='video/*']//preceding::button"), "Open Image button");
    private static Label IMAGE = new Label(By.xpath("//div[@class='content']/img"), "New image");
    private static String SRC_ATTRIBUTE = "src";

    public MainPage() {
        super(new Label(By.xpath(UNIQ_ELEMENT), "Header main page"), "uniq element Main page");
    }

    public void clickOpenImageBtn() {
        OPEN_IMAGE_BTN.click();
    }

    public String getSrcImage() {
        return IMAGE.getAttribute(SRC_ATTRIBUTE);
    }
}
