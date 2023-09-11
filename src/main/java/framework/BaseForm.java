package framework;

import framework.browser.Browser;
import framework.elements.BaseElement;
import framework.utils.WaiterUtils;
import framework.utils.SmartLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseForm {

    private BaseElement uniqElement;

    private String formName;

    protected BaseForm(BaseElement uniqElement, String formName) {
        this.uniqElement = uniqElement;
        this.formName = formName;
    }

    public void setUniqElement(BaseElement uniqElement) {
        this.uniqElement = uniqElement;
    }

    public String getTextUniqElement() {
        return uniqElement.getText();
    }

    public void scrollDown() {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollUp() {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public List<String> getElementsText(By elementsLocators) {
        SmartLogger.logInfo("Get elements text on " + this.formName);
        List<String> elementsText = new ArrayList<>();
        try {
            this.scrollUp();
            this.scrollDown();
            List<WebElement> elements = Browser.getDriver().findElements(elementsLocators);
            for (WebElement element : elements) {
                elementsText.add(element.getText());
            }
        } catch (Exception | Error ex) {
            SmartLogger.logError("Don't get elements text on " + this.formName);
        }

        return elementsText;
    }

    public boolean isFormClose() {
        if (WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator())) {
            SmartLogger.logInfo("Close " + formName + ".");
        }

        return WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator());
    }

    public boolean isFormOpen() {
        if (WaiterUtils.visibilityOfElementLocated(uniqElement.getLocator()).isDisplayed()) {
            SmartLogger.logInfo("Open " + formName + ".");
        }

        return uniqElement.isPresent();
    }
}
