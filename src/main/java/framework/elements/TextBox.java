package framework.elements;

import framework.utils.SmartLogger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By locator, String elementName) {
        super(locator, elementName);
    }

    public void inputText(String text) {
        SmartLogger.logInfo("Input '" + text + "' in " + this.getElementName() + ".");
        this.findElement().sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return this.findElement().getAttribute(attribute);
    }
}
